import heapq
import numpy as np

def heuristic(current, goal):
    return ((current[0] - goal[0]) ** 2 + (current[1] - goal[1]) ** 2) ** 0.5

def get_neighbors(warehouseMap, position):
    neighbors = []
    for i, j in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
        neighbor = (position[0] + i, position[1] + j)
        if 0 <= neighbor[0] < len(warehouseMap) and 0 <= neighbor[1] < len(warehouseMap[0]):
            if warehouseMap[neighbor[0]][neighbor[1]] == 0:
                neighbors.append(neighbor)
    return neighbors

def astar(warehouseMap, start, goal):
    heap = [(0, start)]
    came_from = {start: None}
    cost_so_far = {start: 0}

    while heap:
        current_cost, current_pos = heapq.heappop(heap)

        if current_pos == goal:
            path = []
            while current_pos is not None:
                path.append(current_pos)
                current_pos = came_from[current_pos]
            return path[::-1]  # Reverse the path to start from the beginning

        for neighbor in get_neighbors(warehouseMap,current_pos):
            new_cost = cost_so_far[current_pos] + 1  # Assuming a cost of 1 for each step
            if neighbor not in cost_so_far or new_cost < cost_so_far[neighbor]:
                cost_so_far[neighbor] = new_cost
                priority = new_cost + heuristic(neighbor, goal)
                heapq.heappush(heap, (priority, neighbor))
                came_from[neighbor] = current_pos

    return None  # No path found

def astarDistance(warehouseMap, start, goal):
    path = astar(warehouseMap, start, goal)
    return len(path)-1
