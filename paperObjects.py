# -*- coding: utf-8 -*-
"""
Created on Sat Dec  2 19:11:41 2023

@author: annar
"""
import matplotlib.pyplot as plt
import matplotlib.patches as patches
import numpy as np

class Robot:
    def __init__(self, name, capacity, chargingLocation):
        self.name = name
        self.capacity = capacity
        self.location = chargingLocation
        self.warehouse = None
        self.m = 1
        self.localRemainingProducts = {}
        self.globalRemainingProduct = {}
        self.localRouteLength = 0
        
    def initialization(self):
        self.m = len(self.warehouse.robots)
        self.localRemainingProducts = self.warehouse.products
        self.globalRemainingProduct = self.warehouse.products
        
        
class Product:
    def __init__(self, name, weight, storageLocation):
        self.name = name
        self.weight = weight
        self.storageLocation = storageLocation
        
        
class Warehouse:
    def __init__(self, robotList, productList, mapMatrix):
        self.robots = {robot.name:robot for robot in robotList}
        self.products = {product.name : product for product in productList}
        self.map = np.array(mapMatrix)
        for robot in robotList:
            robot.warehouse = self
            robot.initialization()
            
        
        
        
    def display(self, backgroundColor = 0.95, shelvesColor = 0.5):
        fig, ax = plt.subplots()
        
        #display the shelves in gray and the paths in white
        colorMatrix = backgroundColor+self.map*(shelvesColor-1)
        ax.imshow(colorMatrix, cmap='gray', vmin=0, vmax=1)
        
        #Add products locations
        length = len(self.map)
        width = len(self.map[0])
        elementLocations = [[None for i in range(width)] for i in range(length)]
        ax.set_xticks(np.arange(-0.5, width, 1), minor=True)
        ax.set_yticks(np.arange(-0.5, length, 1), minor=True)
        ax.grid(which="minor", color="gray", linewidth=0.1)
        
        for productName in self.products:
            product = self.products[productName]
            elementLocations[product.storageLocation[0]][product.storageLocation[1]]=productName
        for robotName in self.robots:
            robot = self.robots[robotName]
            position = robot.location
            elementLocations[position[0]][position[1]]=robotName
            cercle = patches.Circle((position[1], position[0]), 0.4, facecolor='orange')
            ax.add_patch(cercle)
            
        #display the elements on the map
        for i in range(length):
            for j in range(width):
                ax.text(j, i, elementLocations[i][j], ha='center', va='center', color='black')
        
        
            
        