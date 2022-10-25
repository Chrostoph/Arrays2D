import java.util.Scanner;

public class Arrays2D {
    public int r, c, x, y, n;
    int[][] arrayIn = new int[r][c];
    int[] snail = new int[r * r];

    public void readArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the number of rows of your matrice:");
        r = sc.nextInt();
        System.out.println("Type in the number of columns of your matrice:");
        c = sc.nextInt();
        n = r * r;

        arrayIn = new int[r][c];

        System.out.println("Type in " + (r * c) + " numbers one after another:");
        for (x = 0; x < r; x++) {
            for (y = 0; y < c; y++) {
                arrayIn[x][y] = sc.nextInt();
            }
        }
    }

    public void printArray() {
        System.out.println("Your matrice is: ");
        for (x = 0; x < r; x++) {
            for (y = 0; y < c; y++) {
                System.out.print(arrayIn[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void snail() {
        System.out.println();
        snail = new int[r * r];
        int step = 0;
        int cycles = r - 1;
        x = y = 0;
        mainLoop:
        for (int i = 0; i < cycles; i++) {
            for (; y < r; y++) {
                if (i > 0) {
                    y++;
                }
                printValue();
                if (isEnd(step++)) break mainLoop;
                if (y == r - 1) {
                    moveRightDown();
                    if (isEnd(step++)) break mainLoop;
                    while (y > 0) {
                        y--;
                        printValue();
                        if (isEnd(step++)) break mainLoop;
                        if (y == 0) {
                            r--;
                            moveLeftUp();
                            if (isEnd(step++)) break mainLoop;
                            break;
                        }
                    }
                    break;
                }
            }
            System.out.println();
        }
    }

    private void moveLeftUp() {
        for (int q = 0; q < r - 1; q++) {
            x--;
            printValue();
        }
    }

    private void moveRightDown() {
        while (x < r) {
            x++;
            printValue();
            if (x == r - 1) {
                break;
            }
        }
    }

    private void printValue() {
        System.out.print(arrayIn[x][y] + " ");
    }

    private boolean isEnd(int step) {
        return step == n;
    }

}

