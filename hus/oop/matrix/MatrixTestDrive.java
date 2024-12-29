package hus.oop.matrix;

import java.util.Arrays;
import java.util.Random;

public class MatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Yêu cầu

        Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [5, 10], lưu vào biến n.
        Tạo ra 2 ma trận vuông có cùng kích thước n. Trong đó các phần tử của ma trận được khởi tạo bằng cách sinh ngẫu nhiên
        có giá trị nằm trong đoạn [1, 10].

        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra một ma trận dạng hình thang theo hàng (row echelon form) dùng phép khử Gauss của 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text theo tên <TenSinhVien_MaSinhVien_Matrix.txt>
         (Ví dụ, NguyenVanA_123456_Matrix.txt).
         Nén các file source code và file text kết quả vào file <TenSinhVien_MaSinhVien_Matrix.zip>, nộp lên classroom.
         */
        Random rand = new Random();
        int n = rand.nextInt(5, 11);
        SquareMatrix squareMatrixA = new SquareMatrix(n);
        SquareMatrix squareMatrixB = new SquareMatrix(n);

        // test square matrix
        System.out.println("Matrix A:");
        System.out.println(squareMatrixA.toString());
        System.out.println("Matrix B:");
        System.out.println(squareMatrixB.toString());
        System.out.println("Matrix A transpose: ");
        System.out.println(squareMatrixA.transpose());
        System.out.println("Matrix B transpose: ");
        System.out.println(squareMatrixB.transpose());
        System.out.println();

        System.out.println("Matrix A principalDiagonal:");
        System.out.println(Arrays.toString(squareMatrixA.principalDiagonal()));
        System.out.println("Matrix A secondaryDiagonal:");
        System.out.println(Arrays.toString(squareMatrixA.secondaryDiagonal()));
        System.out.println();

        System.out.println("Matrix B principalDiagonal:");
        System.out.println(Arrays.toString(squareMatrixB.principalDiagonal()));
        System.out.println("Matrix B secondaryDiagonal:");
        System.out.println(Arrays.toString(squareMatrixB.secondaryDiagonal()));
        System.out.println();

        System.out.println("sum of 2 matrixes:");
        System.out.println(squareMatrixA.add(squareMatrixB));
        System.out.println();

        System.out.println("distract of 2 matrixs:");
        System.out.println(squareMatrixA.minus(squareMatrixB));
        System.out.println();

        System.out.println("Mutipla of 2 matrixs:");
        System.out.println(squareMatrixA.multiply(squareMatrixB));
        System.out.println();

        System.out.println("Gaussian:");
        System.out.println(squareMatrixA.gaussianElimination().toString()); // INCORRECT
        //squareMatrixA.gaussianElimination().toString();
        
    }
}
