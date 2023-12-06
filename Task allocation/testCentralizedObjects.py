# -*- coding: utf-8 -*-
"""
Created on Sun Dec  3 19:31:37 2023

@author: annar
"""

from centralizedObjects import Product, Robot, Warehouse
from centralizedSituation import paperSituation
import networkx as nx

warehouse = paperSituation()

def testDecentralizedObjects():
    warehouse.assignTasks(iterationMax = 20)
    
testDecentralizedObjects()
