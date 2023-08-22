#include <iostream>
#include <vector>
#include <deque>
#include <set>
#include <algorithm>

using namespace std;

struct Node {
    vector<vector<int>> state;
    Node* parent;
    pair<int, int> move;
    int depth;

    Node(const vector<vector<int>>& s, Node* p, const pair<int, int>& m, int d) : state(s), parent(p), move(m), depth(d) {}
};

vector<Node> generate_successors(const Node& node) {
    vector<Node> successors;

    int blank_row = -1;
    int blank_col = -1;

    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            if (node.state[i][j] == 0) {
                blank_row = i;
                blank_col = j;
            }
        }
    }

    vector<pair<int, int>> moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (const auto& move : moves) {
        int new_row = blank_row + move.first;
        int new_col = blank_col + move.second;

        if (new_row >= 0 && new_row < 3 && new_col >= 0 && new_col < 3) {
            vector<vector<int>> new_state = node.state;
            swap(new_state[blank_row][blank_col], new_state[new_row][new_col]);

            successors.emplace_back(new_state, &node, move, node.depth + 1);
        }
    }

    return successors;
}

bool operator==(const Node& lhs, const Node& rhs) {
    return lhs.state == rhs.state;
}

struct NodeHash {
    size_t operator()(const Node& node) const {
        size_t hash_value = 0;
        for (const auto& row : node.state) {
            for (int num : row) {
                hash_value = hash_value * 10 + num;
            }
        }
        return hash_value;
    }
};

vector<vector<Node>> solve_eight_puzzle(const vector<vector<int>>& start_state, const vector<vector<int>>& goal_state) {
    deque<Node> queue;
    set<Node, NodeHash> visited;
    vector<vector<Node>> solution_paths;

    Node root(start_state, nullptr, make_pair(0, 0), 0);
    queue.push_back(root);
    visited.insert(root);

    while (!queue.empty()) {
        Node current_node = queue.front();
        queue.pop_front();

        if (current_node.state == goal_state) {
            vector<Node> solution_path;
            Node* node_ptr = &current_node;
            while (node_ptr) {
                solution_path.insert(solution_path.begin(), *node_ptr);
                node_ptr = node_ptr->parent;
            }
            solution_paths.push_back(solution_path);
        }

        vector<Node> successors = generate_successors(current_node);

        for (const Node& successor : successors) {
            if (visited.find(successor) == visited.end()) {
                queue.push_back(successor);
                visited.insert(successor);
            }
        }
    }

    return solution_paths;
}

int main() {
    int n = 3;
    vector<vector<int>> start_state(n, vector<int>(n));
    vector<vector<int>> goal_state(n, vector<int>(n));

    cout << "Enter the start state:" << endl;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> start_state[i][j];
        }
    }

    cout << "Enter the goal state:" << endl;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> goal_state[i][j];
        }
    }

    vector<vector<Node>> both_solution_paths = solve_eight_puzzle(start_state, goal_state);

    int k = 0;
    for (const vector<Node>& solution_paths : both_solution_paths) {
        if (k == 0) {
            cout << "Solution Path:" << endl;
        } else {
            cout << "Alternative Solution Path:" << endl;
        }

        for (const Node& node : solution_paths) {
            for (const vector<int>& row : node.state) {
                for (int num : row) {
                    cout << num << " ";
                }
                cout << endl;
            }
            cout << endl;
        }

        ++k;
    }

    if (k == 0) {
        cout << "No Alternative Solution Exists" << endl;
    }

    return 0;
}
