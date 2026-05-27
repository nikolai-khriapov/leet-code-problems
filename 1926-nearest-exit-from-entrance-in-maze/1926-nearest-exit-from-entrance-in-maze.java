class Solution {
    private static final char EMPTY = '.';
    private static final char WALL = '+';
    private static final int[][] NEIGHBORS = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze == null || maze.length == 0 || maze[0].length == 0 || entrance == null || entrance.length != 2 || maze[entrance[0]][entrance[1]] != EMPTY) {
            throw new IllegalArgumentException("Invalid input");
        }

        int stepsCount = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = WALL;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] neighbor : NEIGHBORS) {
                    int nextRow = curr[0] + neighbor[0];
                    int nextCol = curr[1] + neighbor[1];
                    int[] next = new int[] {nextRow, nextCol};
                    if (isAllowed(maze, nextRow, nextCol)) {
                        if (isExit(maze, next)) {
                            return stepsCount + 1;
                        }
                        queue.offer(next);
                        maze[nextRow][nextCol] = WALL;
                    }
                }
            }
            stepsCount++;
        }
        
        return -1;
    }

    private boolean isAllowed(char[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == EMPTY;
    }

    private boolean isExit(char[][] maze, int[] cell) {
        return cell[0] == 0 || cell[0] == maze.length - 1 || cell[1] == 0 || cell[1] == maze[0].length - 1;
    }
}

// time  - O(n * m)
// space - O(n * m)
