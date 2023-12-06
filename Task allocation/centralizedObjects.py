# -*- coding: utf-8 -*-
"""
Created on Sun Dec  3 18:32:40 2023

@author: annar
"""

import matplotlib.pyplot as plt
import matplotlib.patches as patches
import numpy as np
import networkx as nx
import copy
import paperAlgorithms as algo #TODO change with your algo



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
        self.productsToProcess = {product.name : product for product in productList}
        self.map = np.array(mapMatrix)
        self.graph = self.createGraph()
        self.initializeRobots()
        
    
    def initializeRobots(self):
        for robot in self.robots.values():
            robot.localRemainingProducts = copy.deepcopy(self.productsToProcess)
            
            
    def assignTasks(self, iterationMax):
        robotOrder = [robotName for robotName in self.robots]
        
        iteration=0
        self.display(iteration)
        
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
                    
                else:
                    for i in range(len(robotOrder)):
                        self.assignProductToRobot(productsToAssign[i], robotOrder[i],distances[i])
                        
                    block = False
                    
            iteration +=1
            self.display(iteration)
            robotOrder = self.sortRobotByRouteLength()

        for robot in self.robots.values():
            robot.route.append("SA")
        
        iteration+=1
        self.display(iteration)
        
        
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
            #Add weighted edges ie paths and their length
            
            for node in graph.nodes():
                if node != product.name:
                    distance = algo.distance(graph.nodes[node]["location"], product.pickupLocation)
                    graph.add_edge(node, product.name, weight = distance)
        
        return graph


    def distance(self, pointA, pointB):
        return self.graph.edges[(pointA,pointB)]['weight']
        
    
    def display(self, iteration, backgroundColor = 0.95, shelvesColor = 0.5):
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
        
        for product in self.productsToProcess.values():
            elementLocations[product.storageLocation[0]][product.storageLocation[1]]=product.name
        for robot in self.robots.values():
            if iteration > len(robot.route)-1:
                position = [length-1, width-1]
            else:
                position = self.graph.nodes[robot.route[iteration]]['location']
            elementLocations[position[0]][position[1]]=robot.name
            cercle = patches.Circle((position[1], position[0]), 0.4, facecolor='orange')
            ax.add_patch(cercle)
            
        #display the elements on the map
        for i in range(length):
            for j in range(width):
                ax.text(j, i, elementLocations[i][j], ha='center', va='center', color='black')
