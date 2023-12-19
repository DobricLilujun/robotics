import pathPlanning
import numpy as np

def testAstar():
    visitedPosition = set()
    mapMatrix = np.zeros((9,9))
    for i in range(2,7):
        mapMatrix[i][0]=1
        mapMatrix[i][2]=1
        mapMatrix[i][3]=1
        mapMatrix[i][5]=1
        mapMatrix[i][6]=1
        mapMatrix[i][8]=1
    print(pathPlanning.astar(mapMatrix, (0,0), (4,1)))


def testAstarDistance():
    visitedPosition = set()
    mapMatrix = np.zeros((9,9))
    for i in range(2,7):
        mapMatrix[i][0]=1
        mapMatrix[i][2]=1
        mapMatrix[i][3]=1
        mapMatrix[i][5]=1
        mapMatrix[i][6]=1
        mapMatrix[i][8]=1
    print(pathPlanning.astarDistance(mapMatrix, (0,0), (4,1)))

