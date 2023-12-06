# -*- coding: utf-8 -*-
"""
Created on Sat Dec  2 19:30:59 2023

@author: annar
"""

from paperObjects import Robot, Product, Warehouse, generate_random_products, generate_regular_shelves
import numpy as np

def main():
    # Generate random products and shelves
    warehouse_size = (30, 30)  # Adjusted warehouse size
    random_products = generate_random_products(20, warehouse_size)
    regular_shelves = generate_regular_shelves(warehouse_size)

    # Create robots, products, and warehouse
    robot1 = Robot("R1", 527, [0, 0])
    robot2 = Robot("R2", 494, [0, 1])
    robot3 = Robot("R3", 439, [0, 2])


    robotList=[robot1, robot2, robot3]
    warehouse = Warehouse(robotList, random_products, regular_shelves)

    # Display the warehouse
    warehouse.display()

if __name__ == "__main__":
    main()
