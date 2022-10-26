import java.util.Scanner;

public class Arrays2D {
    public int rows, columns, x, y, itemsInArray;
    int step = 0;

    int[][] arrayIn = new int[rows][columns];
    int[] snail = new int[rows * rows];

    public void readArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the number of rows of your matrice:");
        rows = sc.nextInt();
        System.out.println("Type in the number of columns of your matrice:");
        columns = sc.nextInt();
        itemsInArray = rows * columns;

        arrayIn = new int[rows][columns];

        System.out.println("Type in " + (rows * columns) + " numbers one after another:");
        for (x = 0; x < rows; x++) {
            for (y = 0; y < columns; y++) {
                arrayIn[x][y] = sc.nextInt();
            }
        }
    }

    public void printArray() {
        System.out.println("Your matrice is: ");
        for (x = 0; x < rows; x++) {
            for (y = 0; y < columns; y++) {
                System.out.print(arrayIn[x][y] + " ");
            }
            System.out.println();
        }
    }

    public int[] getSnailOrder() {
        snail = new int[rows * columns];
        int cycles = rows - 1;
        x = y = 0;
        for (int i = 0; i < cycles; i++) {
            for (; y < columns; y++) {
                moveTopRight(i);
                if (y == columns - 1) {
                    moveRightDown();
                    moveBottomLeftAndUp();
                }
            }
        }
        return snail;
    }

    public void printInSnailOrder(int[] array) {
        System.out.println();
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private void moveTopRight(int i) {
        if (i > 0) {
            y++;
        }
        getValueToArray();
    }

    private void moveBottomLeftAndUp() {
        while (y > 0) {
            y--;
            getValueToArray();
            if (y == 0) {
                rows--;
                columns--;
                moveLeftUp();
                break;
            }
        }
    }

    private void moveLeftUp() {
        for (int q = 0; q < rows - 1; q++) {
            x--;
            getValueToArray();
        }
    }

    private void moveRightDown() {
        while (x < rows) {
            x++;
            getValueToArray();
            if (x == rows - 1) {
                break;
            }
        }
    }

    private void getValueToArray() {
        if (step < itemsInArray) {
            snail[step] = arrayIn[x][y];
            step++;
        }
    }

    private boolean isEnd(int step) {
        return step == itemsInArray;
    }

}

