# -*- coding: utf-8 -*-
"""
Created on Tue Dec 19 18:12:16 2023

@author: leots
"""

import matplotlib.pyplot as plt
import matplotlib.patches as patches
import numpy as np
import networkx as nx
import copy
import pathPlanning



class Robot:
    def __init__(self, name, capacity):
        self.name = name
        self.availableCapacity = capacity
        self.route = ["CS"]
        self.routeLength = 0
        self.localRemainingProducts = {}
        
    def updateLocalRemainingProducts(self):
        productsToDelete = []
        for product in self.localRemainingProducts.values():
            if product.weight > self.availableCapacity:
                productsToDelete.append(product.name)
        for productName in productsToDelete:
            del self.localRemainingProducts[productName]

            

class Product:
    def __init__(self, name, weight, storageLocation, pickupLocation):
        self.name = name
        self.weight = weight
        self.storageLocation = storageLocation #where the product is located
        self.pickupLocation = pickupLocation # where the robot should go to pick product up
        
        
        
class Warehouse:
    def __init__(self, robotList, productList, mapMatrix):
        self.robots = {robot.name:robot for robot in robotList}
        self.allProducts = {product.name : product for product in productList}
        self.productsToProcess = {product.name : product for product in productList}
        self.map = np.array(mapMatrix)
        self.graph = self.createGraph()
        self.initializeRobots()
        
    
    def initializeRobots(self):
        
        
        for robot in self.robots.values():
            robot.localRemainingProducts = copy.deepcopy(self.productsToProcess)
            
            robot
    def assignTasks(self, iterationMax):
        print("Beginning of task assignment")
        robotOrder = [robotName for robotName in self.robots]
        
        iteration=0
        # self.display(iteration)
        
        while len(self.productsToProcess) > 0 and iteration<iterationMax:
            block=True

            while block:
                hasBlocked=False
                productsToAssign = []
                distances = []
                
                for robotName in robotOrder:
                    robot = self.robots[robotName]
                    
                    if iteration == 0:
                        itemToPickUp, distance = self.chooseFirstProduct(productsToAssign)
                        
                    else :
                        itemToPickUp, distance = self.chooseNextProduct(robot, productsToAssign)
                        
                    if self.detectBlockingSituation(robotName, itemToPickUp):
                        hasBlocked=True 
                        print("Blocking situation detected")
                        break
                    
                    else:
                        productsToAssign.append(itemToPickUp)
                        distances.append(distance)
                        
                if hasBlocked:
                    host = self.assignProductToOtherRobot(robotOrder, robotName, itemToPickUp)
                    robotOrder.remove(host)
                    hasBlocked = False
                else:
                    for i in range(len(robotOrder)):
                        self.assignProductToRobot(productsToAssign[i], robotOrder[i],distances[i])
                        
                    block = False
            iteration +=1
            # self.display(iteration)
            robotOrder = self.sortRobotByRouteLength()

        for robot in self.robots.values():
            robot.routeLength+=self.distance(robot.route[-1], "SA")
            robot.route.append("SA")
            
        iteration+=1
        # self.display(iteration)
        
        print("End of task assignment \n")
        
        print("Routes before postprocessing :")
        for robot in self.robots.values() :
            print("  -Route of", robot.name,":", robot.route,", length =", robot.routeLength)
        print("\n")
        print("Beginning of postprocessing")
        self.postprocessing()
        print("End of postprocessing \n")
        
        print("Routes after postprocessing :")
        for robot in self.robots.values() :
            print("  -Route of", robot.name,":", robot.route,", length =", robot.routeLength)
            
        print("\n")

        reponse = input("Do you want to display robots routes ? (y/n): ").lower()

        if reponse == "y":
            self.displayRoutes()

    def assignProductToOtherRobot(self, robotOrder, previousRobotName, productName):
        product = self.productsToProcess[productName]
        newRouteLengths = {}
        
        for robotName in robotOrder:
            if robotName != previousRobotName:
                robot=self.robots[robotName]
                newRouteLength = robot.routeLength+self.distance(robot.route[-1], product.name)
                newRouteLengths[robotName] = newRouteLength
                
        newRouteLengths = dict(sorted(newRouteLengths.items(), key=lambda item: item[1]))
        hostName = list(newRouteLengths)[0]
        distance = newRouteLengths[hostName] - self.robots[hostName].routeLength
        self.assignProductToRobot(productName, hostName, distance)
        
        return hostName
        
    
    def detectBlockingSituation(self, robotName, itemToPickUp):
        robotsRemainingProducts = {}       
        for robot in self.robots.values():
            remainingProducts = copy.deepcopy(robot.localRemainingProducts)
            if itemToPickUp in remainingProducts:
                del remainingProducts[itemToPickUp]
            robotsRemainingProducts[robot.name]=remainingProducts
        productsToDelete = []
        for product in robotsRemainingProducts[robotName].values():
            if product.weight > self.robots[robotName].availableCapacity - self.productsToProcess[itemToPickUp].weight:
                productsToDelete.append(product.name)
        for productName in productsToDelete:
            del robotsRemainingProducts[robotName][productName]
        globalRemainingProducts = copy.deepcopy(self.productsToProcess)
        del globalRemainingProducts[itemToPickUp]
        
        for product in globalRemainingProducts:
            productInAList = False
            for remainingProducts in robotsRemainingProducts.values():
                if product in remainingProducts:
                    productInAList = True
            if not productInAList:
                return True
        return False
    
    
    def chooseFirstProduct(self, assignedProducts):
        distancesToChargingArea = {}
        distancesToStorageArea = {}
        for product in self.productsToProcess.values():
            distancesToChargingArea[product.name] = self.distance("CS",product.name)
            distancesToStorageArea[product.name] = self.distance("SA",product.name)
        
        Lc = list(dict(sorted(distancesToChargingArea.items(), key=lambda item: item[1])).keys())
        
        for product in assignedProducts:
            Lc.remove(product)
            
        LcCopy = copy.deepcopy(Lc)
        for productName in LcCopy:
            if distancesToStorageArea[productName] < distancesToChargingArea[productName]:
                #replace l'élément à la fin de la liste
                Lc.remove(productName)
                Lc.append(productName)
        
        firstProduct = Lc[0]
        
        return firstProduct, distancesToChargingArea[firstProduct]

        
    def assignProductToRobot(self, productName, robotName, distance):
        print("assign ", productName, " to ", robotName)
        
        robot = self.robots[robotName]
        product = self.productsToProcess[productName]
        robot.route.append(productName)
        robot.routeLength+=distance
        robot.availableCapacity -= product.weight
        del self.productsToProcess[productName]
        for otherRobot in self.robots.values():
            if productName in otherRobot.localRemainingProducts:
                del otherRobot.localRemainingProducts[productName]

        robot.updateLocalRemainingProducts()
        
        
    def chooseNextProduct(self, robot, assignedProducts):
        robotLocation = robot.route[-1]
        distances = {}
        for product in robot.localRemainingProducts.values():
            distances[product.name]= self.distance(robotLocation, product.name)
            
        if len(self.productsToProcess) < len(self.robots):
            for productName in distances:
                distances[productName]+=self.distance("SA", productName)
        
        Lc = list(dict(sorted(distances.items(), key=lambda item: item[1])).keys())
        
        for product in assignedProducts:
            Lc.remove(product)
            
        for i in range(len(Lc)):
            product = robot.localRemainingProducts[Lc[i]]
            if robot.availableCapacity > product.weight :
                return Lc[i], distances[Lc[i]]
        
        
    def sortRobotByRouteLength(self):
        routeLengths={}
        
        for robot in self.robots.values():
            routeLengths[robot.name]=robot.routeLength
            
        return list(dict(sorted(routeLengths.items(), key=lambda item: item[1], reverse=True)).keys())
    
    
    def createGraph(self):
        graph = nx.Graph()
        length = len(self.map)
        width = len(self.map[0]) 
        
        #Add nodes ie locations of interest
        graph.add_node("CS", location=[0,0])
        graph.add_node("SA", location=[length-1,width-1])
        
        for product in self.productsToProcess.values():
            graph.add_node(product.name, location=product.pickupLocation)
            # Add weighted edges ie paths and their length
            for node in graph.nodes():
                if node != product.name:
                    nodes = dict(graph.nodes(data=True))
                    distance = round(pathPlanning.astarDistance(self.map, tuple(nodes[node]["location"]),tuple(product.pickupLocation)))
                    graph.add_edge(node, product.name, weight = distance)

        # graph.add_weighted_edges_from([("CS","P1",3), ("CS","P2",6), ("CS","P3",10), 
        #                                ("CS","P4",5), ("CS","P5",11), ("CS","P6",9),
        #                                ("CS","SA",16), ("P1","P2",5), ("P1","P3",9),
        #                                ("P1","P4",2), ("P1","P5",10), ("P1","P6",8),
        #                                ("P1","SA",13), ("P2","P3",6), ("P2","P4",7),
        #                                ("P2","P5",7), ("P2","P6",3), ("P2","SA",10),
        #                                ("P3","P4",11), ("P3","P5",1), ("P3","P6",9),
        #                                ("P3","SA",6), ("P4","P5",12), ("P4","P6",8),
        #                                ("P4","SA",11), ("P5","P6",8), ("P5","SA",5),
        #                                ("P6","SA",7)])
        
        return graph


    def distance(self, pointA, pointB):
        return self.graph.edges[(pointA,pointB)]['weight']
    
    def displayRoutes(self):
        steps = max(len(robot.route) for robot in self.robots.values())
        productList = self.allProducts.copy()
        for i in range (steps):
            self.display(i, productList)
            for robot in self.robots.values():
                if i > 0 and i < len(robot.route)-1:
                    del productList[robot.route[i]]
        
    
    def display(self, iteration, productList, backgroundColor = 0.95, shelvesColor = 0.5):
        fig, ax = plt.subplots()
        
        #display the shelves in gray and the paths in white
        colorMatrix = backgroundColor+self.map*(shelvesColor-1)
        ax.imshow(colorMatrix, cmap='gray', vmin=0, vmax=1)
        
        length = len(self.map)
        width = len(self.map[0])
        ax.set_xticks(np.arange(-0.5, width, 1), minor=True)
        ax.set_yticks(np.arange(-0.5, length, 1), minor=True)
        ax.grid(which="minor", color="gray", linewidth=0.1)
        
        #Add products locations
        elementLocations = [[None for i in range(width)] for i in range(length)]
        for product in productList.values():
            elementLocations[product.storageLocation[0]][product.storageLocation[1]]=product.name

        for robot in self.robots.values():
            if iteration > len(robot.route)-1:
                position = [length-1, width-1]
            else:
                nodes = dict(self.graph.nodes(data=True))
                position = nodes[robot.route[iteration]]['location']


            elementLocations[position[0]][position[1]]=robot.name
            cercle = patches.Circle((position[1], position[0]), 0.4, facecolor='orange')
            ax.add_patch(cercle)

        #display the elements on the map
        for i in range(length):
            for j in range(width):
                ax.text(j, i, elementLocations[i][j], ha='center', va='center', color='black')
                
    def postprocessing(self):
        slowestRobot = self.robots[self.sortRobotByRouteLength()[0]]
        print(slowestRobot.name, "is the robot with the longest route")
        productList = copy.copy(slowestRobot.route[1:-1])
        currentMaxRouteLength = slowestRobot.routeLength
        
        for product in productList:
            newMaxRouteLength, robot, position = self.tryToReallocate(product)
            if newMaxRouteLength and newMaxRouteLength < currentMaxRouteLength:
                self.assignProductToAnotherRobot(slowestRobot, product, robot, position)

                if self.sortRobotByRouteLength()[0] != slowestRobot:
                    break
                else :
                    currentMaxRouteLength = newMaxRouteLength
                    
                    
    def tryToReallocate(self, product):
        slowestRobot = self.robots[self.sortRobotByRouteLength()[0]]
        currentMaxRouteLength = slowestRobot.routeLength
        for robot in self.robots.values():
            if robot != slowestRobot:
                newMaxRouteLength, newPosition = self.tryToReallocateProductToRobot(product, robot)
                if newMaxRouteLength and newMaxRouteLength < currentMaxRouteLength:
                    host = robot
                    position = newPosition
                    currentMaxRouteLength = newMaxRouteLength
        try :
            return currentMaxRouteLength, host, position
        except:
            return None, None, None
    
    
    def tryToReallocateProductToRobot(self, product, robot):
        slowestRobot = self.robots[self.sortRobotByRouteLength()[0]]
        currentMaxRouteLength = slowestRobot.routeLength

        for i in range(len(robot.route)-1):           
            newMaxRouteLength = self.calculateNewMaxRouteLength(slowestRobot, product, robot, i+1)
            
            if newMaxRouteLength < currentMaxRouteLength:
                position = i+1
                currentMaxRouteLength = newMaxRouteLength
        try:
            return currentMaxRouteLength, position
        except:
            return None, None 
        
        
    def assignProductToAnotherRobot(self, oldRobot, product, newRobot, position):
        print("Reassign", product, "to",newRobot.name)
        #remove product from oldRobot's route
        oldRobot.route.remove(product)
        oldRobot.routeLength = self.calculateRouteLength(oldRobot.route)
        
        #add product to new robots route at position
        newRobot.route.insert(position, product)
        newRobot.routeLength = self.calculateRouteLength(newRobot.route)
        

    def calculateNewMaxRouteLength(self, slowestRobot, product, robotWithNewRoute, position):
        newRoute = copy.copy(robotWithNewRoute.route)
        newRoute.insert(position, product)
        
        newSlowRoute = copy.copy(slowestRobot.route)
        newSlowRoute.remove(product)
        maxRouteLength = max(self.calculateRouteLength(newRoute), self.calculateRouteLength(newSlowRoute))
        
        for robot in self.robots.values():
            if robot != robotWithNewRoute and robot != slowestRobot:
                if robot.routeLength > maxRouteLength:
                    maxRouteLength = robot.routeLength
                    
        return maxRouteLength
    
    
    def calculateRouteLength(self, route):
        distance = 0
        for i in range(len(route)-1):
            distance += self.distance(route[i], route[i+1])
        return distance