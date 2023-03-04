package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer :: parseInt).toArray();
                matrix[i] = rowData;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[size - 1 - i][i] + " ");
        }
    }
}
