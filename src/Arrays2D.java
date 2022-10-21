import java.util.Scanner;

public class Arrays2D {
    public int r, c, x, y;
    int[][] arrayIn = new int[r][c];
    int[] snail = new int[r * r];

    public void readArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the number of rows of your matrice:");
        r = sc.nextInt();
        System.out.println("Type in the number of columns of your matrice:");
        c = sc.nextInt();

        arrayIn = new int[r][c];

        System.out.println("Type in " + (r + c) + " numbers one after another:");
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
        snail = new int[r * r];
        for (int i = 0; i < r * r; i++) {
            System.out.println("Step");
            for (; x >= 0; x--) {
                for (; y < c; y++) {
                    snail[i] = arrayIn[x][y];
                    i++;
                }
                y--;
                for (x = c - y; x < y; x++) {
                    snail[i] = arrayIn[x][y];
                    i++;
                }
            }
        }
        for (int i : snail) {
            System.out.print(i + " ");
        }
    }

}

