public class MazeSolver {
    private static final int PATH = 0;
    private static final int WALL = 1;
    private static final int VISITED = 2;

    private int[][] maze;
    private int rows, cols;

    public MazeSolver(int[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
    }

    public boolean solveMaze(int startX, int startY, int endX, int endY) {
        if (solve(startX, startY, endX, endY)) {
            printMaze();
            return true;
        } else {
            System.out.println("No path found.");
            return false;
        }
    }

    private boolean solve(int x, int y, int endX, int endY) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || maze[x][y] != PATH) {
            return false;
        }

        if (x == endX && y == endY) {
            maze[x][y] = VISITED;
            return true;
        }

        maze[x][y] = VISITED;


        if (solve(x + 1, y, endX, endY) ||
            solve(x, y + 1, endX, endY) ||
            solve(x - 1, y, endX, endY) ||
            solve(x, y - 1, endX, endY)) {
            return true;
        }

        maze[x][y] = PATH;
        return false;
    }

    private void printMaze() {
        for (int[] row : maze) {
            for (int cell : row) {
                System.out.print(cell == WALL ? "1 " : (cell == PATH ? "0 " : ". "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
        };

        MazeSolver solver = new MazeSolver(maze);
        solver.solveMaze(0, 0, 4, 4);
    }
}
