import heapq
from paperObjects import    

class AStar:
    def __init__(self, warehouse):
        self.warehouse = warehouse
        self.visited = set()

    def heuristic(self, current, goal):
        # A simple heuristic function (Euclidean distance)
        return ((current[0] - goal[0]) ** 2 + (current[1] - goal[1]) ** 2) ** 0.5

    def get_neighbors(self, position):
        neighbors = []
        for i, j in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            neighbor = (position[0] + i, position[1] + j)
            if 0 <= neighbor[0] < len(self.warehouse.map) and 0 <= neighbor[1] < len(self.warehouse.map[0]):
                if self.warehouse.map[neighbor[0]][neighbor[1]] == 0:  # Check if it's a valid path
                    neighbors.append(neighbor)
        return neighbors

    def astar(self, start, goal):
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

            if current_pos in self.visited:
                continue

            self.visited.add(current_pos)

            for neighbor in self.get_neighbors(current_pos):
                new_cost = cost_so_far[current_pos] + 1  # Assuming a cost of 1 for each step
                if neighbor not in cost_so_far or new_cost < cost_so_far[neighbor]:
                    cost_so_far[neighbor] = new_cost
                    priority = new_cost + self.heuristic(neighbor, goal)
                    heapq.heappush(heap, (priority, neighbor))
                    came_from[neighbor] = current_pos

        return None  # No path found


def main():
    warehouse_size = (30, 30)

    robot1 = Robot("R1", 527, [0,0])
    robot2 = Robot("R2", 494, [0,1])
    robot3 = Robot("R3", 439, [0,2])

    product1 = Product("P1", 181, [2,0])
    product2 = Product("P2", 196, [2,3])
    product3 = Product("P3", 127, [3,8])
    product4 = Product("P4", 250, [4,2])
    product5 = Product("P5", 124, [4,6])
    product6 = Product("P6", 206, [5,5])

    robotList=[robot1, robot2, robot3]
    productList = [product1, product2, product3, product4, product5, product6]


    robotList = [robot1, robot2, robot3]
    warehouse = Warehouse(robotList, random_products, regular_shelves)

    # Display the warehouse
    warehouse.display()

    # Example: A* algorithm from the charging station to a random product location
    a_star = AStar(warehouse)
    charging_station = robot1.location
    random_product_location = random.choice(list(warehouse.products.values())).storageLocation

    path = a_star.astar(charging_station, random_product_location)

    # Display the path
    if path:
        print("A* Path:", path)
        warehouse.display_path(path)
    else:
        print("No path found.")

if __name__ == "__main__":
    main()