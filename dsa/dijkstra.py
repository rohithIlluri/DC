import heapq
from collections import defaultdict

def dijkstra(graph, start):
    # Initialize distances and predecessors
    distances = {node: float('infinity') for node in graph}
    distances[start] = 0
    predecessors = {node: None for node in graph}
    
    # Priority queue to store vertices that need to be processed
    pq = [(0, start)]
    
    while pq:
        # Get the node with the smallest distance
        current_distance, current_node = heapq.heappop(pq)
        
        # If we've found a longer path, skip it
        if current_distance > distances[current_node]:
            continue
        
        # Check all neighbors of the current node
        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight
            
            # If we've found a shorter path, update it
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                predecessors[neighbor] = current_node
                heapq.heappush(pq, (distance, neighbor))
    
    return distances, predecessors

# Example usage
graph = {
    'A': {'B': 4, 'C': 2},
    'B': {'A': 4, 'C': 1, 'D': 5},
    'C': {'A': 2, 'B': 1, 'D': 8, 'E': 10},
    'D': {'B': 5, 'C': 8, 'E': 2, 'F': 6},
    'E': {'C': 10, 'D': 2, 'F': 3},
    'F': {'D': 6, 'E': 3}
}

start_node = 'A'
distances, predecessors = dijkstra(graph, start_node)

print("Shortest distances from node", start_node)
for node, distance in distances.items():
    print(f"{node}: {distance}")

print("\nPredecessors:")
for node, predecessor in predecessors.items():
    print(f"{node}: {predecessor}")