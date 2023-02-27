package Bonus;

import java.util.Scanner;

public class Cycle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The integer must be positive.");
            return;
        }

        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            A[i][(i + 1) % n] = 1;
            A[(i + 1) % n][i] = 1;
        }

        System.out.println("A^1");
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(A[j][k] + " ");
            }
            System.out.println();
        }

        int[][] B = A;
        int [][] C = new int[n][n];
        for (int i = 2; i <= n; i++) {
            C = Multiply(A,B);
            System.out.println("A^" + i);

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(C[j][k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] Multiply(int[][] A, int [][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}