# -*- coding: utf-8 -*-
"""
Created on Tue Dec 19 18:13:21 2023

@author: leots
"""

from objects import Robot, Product, Warehouse
import numpy as np

def paperSituation():
    robot1 = Robot("R1", 527)
    robot2 = Robot("R2", 494)
    robot3 = Robot("R3", 439)
    
    product1 = Product("P1", 181, [2,0], [2,1])
    product2 = Product("P2", 196, [2,3], [2,4])
    product3 = Product("P3", 127, [3,8], [3,7])
    product4 = Product("P4", 250, [4,2], [4,1])
    product5 = Product("P5", 124, [4,6], [4,7])
    product6 = Product("P6", 106, [5,5], [5,4])
    
    robotList=[robot1, robot2, robot3]
    productList = [product1, product2, product3, product4, product5, product6]
    
    mapMatrix = np.zeros((9,9))
    for i in range(2,7):
        mapMatrix[i][0]=1
        mapMatrix[i][2]=1
        mapMatrix[i][3]=1
        mapMatrix[i][5]=1
        mapMatrix[i][6]=1
        mapMatrix[i][8]=1
    
    warehouse = Warehouse(robotList, productList, mapMatrix)
    
    return warehouse