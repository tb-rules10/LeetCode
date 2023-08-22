class Node {
    constructor(state, parent, move, depth) {
        this.state = state;
        this.parent = parent;
        this.move = move;
        this.depth = depth;
    }
}

function generateSuccessors(node) {
    const successors = [];

    let blankRow = -1;
    let blankCol = -1;

    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            if (node.state[i][j] === 0) {
                blankRow = i;
                blankCol = j;
            }
        }
    }

    const moves = [[-1, 0], [1, 0], [0, -1], [0, 1]];

    for (const move of moves) {
        const newRow = blankRow + move[0];
        const newCol = blankCol + move[1];

        if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
            const newState = node.state.map(row => row.slice());
            newState[blankRow][blankCol] = newState[newRow][newCol];
            newState[newRow][newCol] = 0;

            successors.push(new Node(newState, node, move, node.depth + 1));
        }
    }

    return successors;
}

function solveEightPuzzle(startState, goalState) {
    const queue = [];
    const visited = new Set();
    const solutionPaths = [];

    const root = new Node(startState, null, null, 0);
    queue.push(root);
    visited.add(JSON.stringify(startState));

    while (queue.length > 0) {
        const currentNode = queue.shift();

        if (JSON.stringify(currentNode.state) === JSON.stringify(goalState)) {
            const solutionPath = [];
            let node = currentNode;
            while (node) {
                solutionPath.unshift(node);
                node = node.parent;
            }
            solutionPaths.push(solutionPath);
        }

        const successors = generateSuccessors(currentNode);

        for (const successor of successors) {
            const stateStr = JSON.stringify(successor.state);
            if (!visited.has(stateStr)) {
                queue.push(successor);
                visited.add(stateStr);
            }
        }
    }

    return solutionPaths;
}

function main() {
    const n = 3;
    const startState = [];
    const goalState = [];

    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    console.log("Enter the start state:");
    rl.on('line', line => {
        const rowValues = line.split(" ").map(Number);
        startState.push(rowValues);

        if (startState.length === n) {
            console.log("Enter the goal state:");
            rl.on('line', line => {
                const rowValues = line.split(" ").map(Number);
                goalState.push(rowValues);

                if (goalState.length === n) {
                    rl.close();
                    const bothSolutionPaths = findTwoSolutions(startState, goalState);
                    let k = 0;
                    for (const solutionPaths of bothSolutionPaths) {
                        if (k === 0) {
                            console.log("Solution Path:");
                        } else {
                            console.log("Alternative Solution Path:");
                        }
                        printSolutionPaths(solutionPaths);
                        if (bothSolutionPaths.length > 1) k++;
                    }
                    if (k === 0) console.log("No Alternative Solution Exists");
                }
            });
        }
    });
}

function findTwoSolutions(startState, goalState) {
    const bothSolutionPaths = [];

    // Find the first solution
    const solutionPath1 = solveEightPuzzle(startState, goalState);
    bothSolutionPaths.push(solutionPath1);

    // Find the second solution (alternative)
    // Implement this similar to solveEightPuzzle but change the order of moves

    return bothSolutionPaths;
}

function printSolutionPaths(solutionPaths) {
    if (solutionPaths.length === 0) {
        console.log("No solution found.");
        return;
    }

    for (const solutionPath of solutionPaths) {
        printSolutionPath(solutionPath);
        console.log();
    }
}

function printSolutionPath(solutionPath) {
    for (const node of solutionPath) {
        printState(node.state);
    }
}

function printState(state) {
    for (const row of state) {
        console.log(row.join(" "));
    }
    console.log();
}

main();
