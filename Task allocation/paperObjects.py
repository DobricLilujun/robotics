# -*- coding: utf-8 -*-
"""
Created on Sat Dec  2 19:11:41 2023

@author: annar
"""
import math
import matplotlib.pyplot as plt
import matplotlib.patches as patches
import numpy as np
import random

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
        
        plt.show()
            

# Function to generate random products
def generate_random_products(num_products, warehouse_size):
    products = []
    for i in range(num_products):
        name = f"P{i+1}"
        weight = random.randint(50, 300)
        storage_location = [random.randint(0, warehouse_size[0]-1), random.randint(0, warehouse_size[1]-1)]
        products.append(Product(name, weight, storage_location))
    return products


# Function to check if a shelf can be placed at a given location
def can_place_shelf(map_matrix, row, col, shelf_size):
    return np.sum(map_matrix[row:row + shelf_size[0], col:col + shelf_size[1]]) == 0

# Function to generate random shelves in the warehouse with fixed size (1*5 or 2*5) and gaps around containers
def generate_random_shelves(num_shelves, warehouse_size):
    map_matrix = np.zeros(warehouse_size)
    shelf_sizes = [(1, 5), (2, 5)]  # Possible shelf sizes
    gap_between_containers = 2  # Gap between two containers

    for i in range(num_shelves):
        # Randomly choose a shelf size
        shelf_size = random.choice(shelf_sizes)

        placed = False
        while not placed:
            # Calculate the location to ensure parallel shelves with gaps around containers
            row_min = max(0, random.randint(0, warehouse_size[0] - shelf_size[0] - gap_between_containers))
            col_min = max(0, random.randint(0, warehouse_size[1] - shelf_size[1]))

            row_max = min(warehouse_size[0] - shelf_size[0], row_min + gap_between_containers)
            col_max = min(warehouse_size[1] - shelf_size[1], col_min + gap_between_containers)

            # Randomly choose a location within the specified range
            row = random.randint(row_min, row_max)
            col = random.randint(col_min, col_max)

            # Check if the shelf can be placed at the chosen location without overlapping
            if can_place_shelf(map_matrix, row, col, shelf_size):
                map_matrix[row:row + shelf_size[0], col:col + shelf_size[1]] = 1
                placed = True

    return map_matrix


# Function to generate regular shelves in the warehouse with fixed size (1*5 or 2*5) and gaps for robot movement
def generate_regular_shelves(warehouse_size, shelf_size=(5, 1), gap_between_shelves=2, robot_width=1):
    map_matrix = np.zeros(warehouse_size)

    for i in range(math.floor(warehouse_size[0]/shelf_size[0]+gap_between_shelves)):
        print ()
        for j in range(math.floor(warehouse_size[0]/(shelf_size[0]+robot_width))):
        # Calculate the location to ensure regularly spaced shelves with gaps for robot movement
            row = i * (shelf_size[0] + gap_between_shelves)
            col = j * (shelf_size[1] + robot_width) # Leave space for robot movement on the left

            # Check if the shelf can be placed at the chosen location without overlapping
            if can_place_shelf(map_matrix, row, col, shelf_size):
                map_matrix[row:row + shelf_size[0], col:col + shelf_size[1]] = 1

    return map_matrix