# -*- coding: utf-8 -*-
"""
Created on Tue Dec 19 18:14:23 2023

@author: annar
"""

from objects import Product, Robot, Warehouse
from exampleSituation import paperSituation
import networkx as nx

warehouse = paperSituation()
warehouse.assignTasks(iterationMax = 20)

