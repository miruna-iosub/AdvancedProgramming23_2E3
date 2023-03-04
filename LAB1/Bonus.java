package bonus;

import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int degree = scanner.nextInt();

        if (n <= 0 || m <= 0 || degree <= 0) {
            System.out.println("The integers must be positive.");
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
        int[][] C = new int[n][n];
        for (int i = 2; i <= n; i++) {
            C = multiply(A, B);
            System.out.println("A^" + i);

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(C[j][k] + " ");
                }
                System.out.println();
            }
        }


        int[][] D = new int[m][degree];
        D = createAdjacencyMatrix(m, degree);

        System.out.println("Regular adjacency matrix");
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                System.out.print(D[j][k] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] multiply(int[][] A, int[][] B) {
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

    public static int[][] createAdjacencyMatrix(int vertices, int degree) {
        int[][] matrix = new int[vertices][vertices];

        int isDegreeEven = 1;
        if (degree % 2 != 0) isDegreeEven = 1;

        int edges = degree / 2;
        if (isDegreeEven == 0) {
            edges++;
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 1; j <= edges; j++) {
                int neighborIndex = (i + j) % vertices;
                matrix[i][neighborIndex] = 1;
                matrix[neighborIndex][i] = 1;
            }
        }
        return matrix;
    }
}
