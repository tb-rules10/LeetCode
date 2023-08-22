import java.util.*;
public class Main {

    public static void main(String[] args) {

        int n = 3;
        int[][] startState = new int[n][n];
        int[][] goalState = new int[n][n];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the start state:");
        for (int i = 0; i < n; i++) {
            String[] rowValues = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                startState[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        System.out.println("Enter the goal state:");
        for (int i = 0; i < n; i++) {
            String[] rowValues = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                goalState[i][j] = Integer.parseInt(rowValues[j]);
            }
        }

//        int[][] startState = {
//                {1, 2, 3},
//                {5, 6, 4},
//                {0, 7, 8}
//        };
//        int[][] goalState = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 0}
//        };

        int k = 0;
        List<List<List<Node>>> bothSolutionPaths = findTwoSolutions(startState, goalState);
        for(List<List<Node>> solutionPaths : bothSolutionPaths) {
            switch (k) {
                case 0 -> System.out.println("Solution Path:");
                case 1 -> System.out.println("Alternative Solution Path:");
            }
            printSolutionPaths(solutionPaths);
            if (bothSolutionPaths.size() > 1)  k++;
        }
        if(k == 0) System.out.println("No Alternative Solution Exists");
    }
    public static List<List<List<Node>>> findTwoSolutions(int[][] startState, int[][] goalState) {
        List<List<List<Node>>> bothSolutionPaths = new ArrayList<>();

        // Find the first solution
        List<List<Node>> solutionPath1 = solveEightPuzzle(startState, goalState);
        bothSolutionPaths.add(solutionPath1);

       // Find Second Solution
        List<List<Node>> solutionPath2 = alternativeSolveEightPuzzle(startState, goalState);
        bothSolutionPaths.add(solutionPath2);

        return bothSolutionPaths;
    }
    public static List<List<Node>> alternativeSolveEightPuzzle(int[][] startState, int[][] goalState) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<List<Node>> solutionPaths = new ArrayList<>();

        Node root = new Node(startState, null, null, 0);
        queue.add(root);
        visited.add(Arrays.deepToString(startState));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (Arrays.deepEquals(currentNode.state, goalState)) {
                List<Node> solutionPath = new ArrayList<>();
                populateSolutionPath(solutionPath, currentNode);
                solutionPaths.add(solutionPath);
            }

            List<Node> successors = generateAlternativeSuccessors(currentNode);

            for (Node successor : successors) {
                String stateStr = Arrays.deepToString(successor.state);
                if (!visited.contains(stateStr)) {
                    queue.add(successor);
                    visited.add(stateStr);
                }
            }
        }

        return solutionPaths;
    }
    public static List<List<Node>> solveEightPuzzle(int[][] startState, int[][] goalState) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<List<Node>> solutionPaths = new ArrayList<>();

        Node root = new Node(startState, null, null, 0);
        queue.add(root);
        visited.add(Arrays.deepToString(startState));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (Arrays.deepEquals(currentNode.state, goalState)) {
                List<Node> solutionPath = new ArrayList<>();
                populateSolutionPath(solutionPath, currentNode);
                solutionPaths.add(solutionPath);
            }

            List<Node> successors = generateSuccessors(currentNode);

            for (Node successor : successors) {
                String stateStr = Arrays.deepToString(successor.state);
                if (!visited.contains(stateStr)) {
                    queue.add(successor);
                    visited.add(stateStr);
                }
            }
        }

        return solutionPaths;
    }
    public static List<Node> generateAlternativeSuccessors(Node node) {
        List<Node> successors = new ArrayList<>();

        int blankRow = -1;
        int blankCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (node.state[i][j] == 0) {
                    blankRow = i;
                    blankCol = j;
                }
            }
        }

        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Change order of moves

        for (int[] move : moves) {
            int newRow = blankRow + move[0];
            int newCol = blankCol + move[1];

            if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                int[][] newState = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    newState[i] = Arrays.copyOf(node.state[i], 3);
                }
                newState[blankRow][blankCol] = newState[newRow][newCol];
                newState[newRow][newCol] = 0;

                successors.add(new Node(newState, node, move, node.depth + 1));
            }
        }

        return successors;
    }
    public static List<Node> generateSuccessors(Node node) {
        List<Node> successors = new ArrayList<>();

        int blankRow = -1;
        int blankCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (node.state[i][j] == 0) {
                    blankRow = i;
                    blankCol = j;
                }
            }
        }

        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] move : moves) {
            int newRow = blankRow + move[0];
            int newCol = blankCol + move[1];

            if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                int[][] newState = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    newState[i] = Arrays.copyOf(node.state[i], 3);
                }
                newState[blankRow][blankCol] = newState[newRow][newCol];
                newState[newRow][newCol] = 0;

                successors.add(new Node(newState, node, move, node.depth + 1));
            }
        }

        return successors;
    }

    public static void populateSolutionPath(List<Node> solutionPath, Node node) {
        while (node != null) {
            solutionPath.add(0, node);
            node = node.parent;
        }
    }

    public static void printSolutionPaths(List<List<Node>> solutionPaths) {
        if (solutionPaths.isEmpty()) {
            System.out.println("No solution found.");
            return;
        }

        for (List<Node> solutionPath : solutionPaths) {
            printSolutionPath(solutionPath);
            System.out.println();
        }
    }

    public static void printSolutionPath(List<Node> solutionPath) {
        for (Node node : solutionPath) {
            printState(node.state);
        }
    }

    public static void printState(int[][] state) {
        for (int[] row : state) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Node {
        int[][] state;
        Node parent;
        int[] move;
        int depth;

        public Node(int[][] state, Node parent, int[] move, int depth) {
            this.state = state;
            this.parent = parent;
            this.move = move;
            this.depth = depth;
        }
    }
}

