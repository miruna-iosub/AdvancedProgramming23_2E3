package Homework;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The integer must be positive.");
            return;
        }

        long startTime = System.nanoTime();

        int[][] latinSquare = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                latinSquare[i][j] = (i + j) % n + 1;
            }
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        if (n > 30000) {
            System.out.printf("%d milliseconds\n", totalTime / 1000000);
        } else {
            for (int i = 0; i < n; i++) {
                String line = "";
                String column = "";
                for (int j = 0; j < n; j++) {
                    line += latinSquare[i][j] + " ";
                    column += latinSquare[j][i] + " ";
                }
                System.out.println("Line " + (i + 1) + ": " + line);
                System.out.println("Column " + (i + 1) + ": " + column);
            }

            System.out.println("Elements of latinSquare: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(latinSquare[i][j] + "\t");
                }
                System.out.println(" ");
            }
        }
    }
}
