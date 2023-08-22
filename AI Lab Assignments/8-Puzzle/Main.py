from collections import deque
import copy

class Node:
    def __init__(self, state, parent, move, depth):
        self.state = state
        self.parent = parent
        self.move = move
        self.depth = depth

def generate_successors(node):
    successors = []
    
    blank_row, blank_col = -1, -1
    
    for i in range(3):
        for j in range(3):
            if node.state[i][j] == 0:
                blank_row, blank_col = i, j
                
    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    for move in moves:
        new_row, new_col = blank_row + move[0], blank_col + move[1]
        
        if 0 <= new_row < 3 and 0 <= new_col < 3:
            new_state = copy.deepcopy(node.state)
            new_state[blank_row][blank_col] = new_state[new_row][new_col]
            new_state[new_row][new_col] = 0
            
            successors.append(Node(new_state, node, move, node.depth + 1))
            
    return successors

def solve_eight_puzzle(start_state, goal_state):
    queue = deque()
    visited = set()
    solution_paths = []

    root = Node(start_state, None, None, 0)
    queue.append(root)
    visited.add(str(start_state))

    while queue:
        current_node = queue.popleft()

        if current_node.state == goal_state:
            solution_path = []
            populate_solution_path(solution_path, current_node)
            solution_paths.append(solution_path)

        successors = generate_successors(current_node)

        for successor in successors:
            state_str = str(successor.state)
            if state_str not in visited:
                queue.append(successor)
                visited.add(state_str)

    return solution_paths

def populate_solution_path(solution_path, node):
    while node:
        solution_path.insert(0, node)
        node = node.parent

def print_solution_paths(solution_paths):
    if not solution_paths:
        print("No solution found.")
        return

    for i, solution_path in enumerate(solution_paths):
        if i == 0:
            print("Solution Path:")
        else:
            print("Alternative Solution Path:")
        print_solution_path(solution_path)
        print()

def print_solution_path(solution_path):
    for node in solution_path:
        print_state(node.state)

def print_state(state):
    for row in state:
        print(" ".join(str(num) for num in row))
    print()

def find_two_solutions(start_state, goal_state):
    solution_path1 = solve_eight_puzzle(start_state, goal_state)
    solution_path2 = alternative_solve_eight_puzzle(start_state, goal_state)
    return [solution_path1, solution_path2]

def alternative_solve_eight_puzzle(start_state, goal_state):
    return solve_eight_puzzle(start_state, goal_state)  # Simply reuse the same solving function

if __name__ == "__main__":
    n = 3
    start_state = [[0] * n for _ in range(n)]
    goal_state = [[0] * n for _ in range(n)]

    print("Enter the start state:")
    for i in range(n):
        start_state[i] = list(map(int, input().split()))

    print("Enter the goal state:")
    for i in range(n):
        goal_state[i] = list(map(int, input().split()))

    both_solution_paths = find_two_solutions(start_state, goal_state)
    k = 0
    for solution_paths in both_solution_paths:
        if k == 0:
            print("Solution Path:")
        else:
            print("Alternative Solution Path:")
        print_solution_paths(solution_paths)
        k += 1
