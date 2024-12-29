package hus.oop.matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private double[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param rows số hàng, columns số cột
     */
    public Matrix(int rows, int columns) {
        /* TODO */
        data = new double[rows][columns];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = rand.nextDouble(10) + 1;
            }
        }
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param rows số hàng, columns số cột
     */
    private void initRandom(int rows, int columns) {
        /* TODO */
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = rand.nextDouble(10) + 1;
            }
        }
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public double get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public Matrix getSortedMatrix() {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length - 1; j++) {
                for (int k = 0; k < data[j].length - j - 1; k++) {
                    if (data[i][k] > data[i][k + 1]) {
                        double temp = data[i][k];
                        data[i][k] = data[i][k + 1];
                        data[i][k + 1] = temp;
                    }
                }
            }
        }
        return this;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public Matrix add(Matrix that) {
        /* TODO */
        Matrix sumOfMatrices = new Matrix(that.data[0].length, that.data[1].length);
        if (this.data.length == that.data.length) {
            for (int i = 0; i < data[0].length; i++) {
                for (int j = 0; j < data[1].length; j++) {
                    sumOfMatrices.data[i][j] = this.data[i][j] + that.data[i][j];
                }
            }
        }
        else {
            return null;
        }
        return sumOfMatrices;
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public Matrix minus(Matrix that) {
        /* TODO */
        Matrix sumOfMatrices = new Matrix(that.data[0].length, that.data[1].length);
        if (this.data.length == that.data.length) {
            for (int i = 0; i < data[0].length; i++) {
                for (int j = 0; j < data[1].length; j++) {
                    sumOfMatrices.data[i][j] = this.data[i][j] - that.data[i][j];
                }
            }
        }
        else {
            return null;
        }
        return sumOfMatrices;
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của hai ma trận.
     */
    public Matrix multiply(Matrix that) {
        /* TODO */
        Matrix mutipalMatrix = new Matrix(this.data[0].length, that.data[1].length);
        if (this.data[1].length == that.data[0].length) {
            for (int i = 0; i < mutipalMatrix.data[0].length; i++) {
                for (int j = 0; j < mutipalMatrix.data[1].length; j++) {
                    for (int k = 0; k < this.data[1].length; k++)
                        mutipalMatrix.data[i][j] += this.data[i][k] * that.data[k][j];
                }
            }
        }
        else {
            return null;
        }
        return mutipalMatrix;
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public Matrix scaled(int value) {
        /* TODO */
        Matrix mutipalMatrix = new Matrix(this.data[0].length, this.data[1].length);
        for (int row = 0; row < this.data[0].length; row++) {
            for (int colum = 0; colum < this.data[1].length; colum++) {
                mutipalMatrix.data[row][colum] = this.data[row][colum] * value;
            }
        }
        return mutipalMatrix;
    }

    /**
     * Phương thức nhân hàng thứ rowIndex của ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận có hàng rowIndex bằng hàng rowIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledRow(int value, int rowIndex) {
        /* TODO */
        Matrix mutipalMatrix = new Matrix(this.data[0].length, this.data[1].length);
        if (rowIndex < this.data[0].length) {
            for (int colum = 0; colum < this.data[1].length; colum++) {
                mutipalMatrix.data[rowIndex][colum] = this.data[rowIndex][colum] * value;
            }
        }
        else {
            return null;
        }
        return mutipalMatrix;
    }

    /**
     * Phương thức nhân cột thứ columnIndex của ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận có cột columnIndex bằng cột columnIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledColumn(int value, int columnIndex) {
        /* TODO */
        Matrix mutipalMatrix = new Matrix(this.data[0].length, this.data[1].length);
        for (int row = 0; row < this.data[0].length; row++) {
            mutipalMatrix.data[row][columnIndex] = this.data[row][columnIndex] * value;
        }
        return mutipalMatrix;
    }

    /**
     * Phương thức hoán đổi hai hàng của ma trận.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapRows(int firstIndex, int secondIndex) {
        /* TODO */
        if (firstIndex < this.data[0].length || secondIndex < this.data[1].length) {
            for (int colum = 0; colum < this.data[1].length; colum++) {
                double temp = this.data[firstIndex][colum];
                this.data[firstIndex][colum] = this.data[secondIndex][colum];
                this.data[secondIndex][colum] = temp;
            }
        }
        else {
            System.out.println("Out of bound of Array");
        }
    }

    /**
     * Phương thức hoán đổi hai cột của ma trận.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapColumns(int firstIndex, int secondIndex) {
        /* TODO */
        if (firstIndex < this.data[1].length || secondIndex < this.data[1].length) {
            for (int row = 0; row < this.data[0].length; row++) {
                double temp = this.data[row][firstIndex];
                this.data[row][firstIndex] = this.data[row][secondIndex];
                this.data[row][secondIndex] = temp;
            }
        }
        else {
            System.out.println("Out of bound Array");
        }
    }

    /**
     * Phương thức cộng hàng destIndex của ma trận với hàng sourceIndex của ma trận được nhân với một số value.
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addRow(double value, int sourceIndex, int destIndex) {
        /* TODO */
        if (sourceIndex < this.data[0].length || destIndex < this.data[0].length) {
            for (int colum = 0; colum < this.data[1].length; colum++) {
                this.data[destIndex][colum] = this.data[sourceIndex][colum] * value;
            }
        }
        else {
            System.out.println("out of bound Array");
        }
    }

    /**
     * Phương thức cộng cột destIndex của ma trận với cột sourceIndex của ma trận được nhân với một số value.
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addColumn(double value, int sourceIndex, int destIndex) {
        /* TODO */
        if (sourceIndex < this.data[1].length || destIndex < this.data[1].length) {
            for (int row = 0; row < this.data[0].length; row++) {
                this.data[row][destIndex] = this.data[row][sourceIndex] * value;
            }
        }
        else {
            System.out.println("out of bound Array");
        }
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public Matrix transpose() {
        /* TODO */
        Matrix displacementMatrix = new Matrix(this.data[1].length, this.data[0].length);
        for (int row = 0; row < displacementMatrix.data[0].length; row++) {
            for (int colum = 0; colum < displacementMatrix.data[1].length; colum++) {
                displacementMatrix.data[row][colum] = this.data[colum][row];
            }
        }
        return displacementMatrix;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng (row echelon form)
     * sau khi thực hiện phép khử Gauss.
     * @return ma trận dạng hình thang theo hàng.
     */
    public Matrix gaussianElimination() {
        /* TODO */
        double[][] result = copyData(data); // Copy to avoid modifying the original matrix

        int minDim = Math.min(this.data[0].length, this.data[1].length); // Minimum dimension to handle non-square matrices

        for (int pivot = 0; pivot < minDim; pivot++) {
            // Step 1: Find the largest absolute value in the current column (partial pivoting)
            int maxRow = pivot;
            for (int row = pivot + 1; row < this.data[0].length; row++) {
                if (Math.abs(result[row][pivot]) > Math.abs(result[maxRow][pivot])) {
                    maxRow = row;
                }
            }

            // Step 2: Swap rows to move the largest element to the pivot position
            if (maxRow != pivot) {
                swapRows(result, pivot, maxRow);
            }

            // Step 3: Perform row reduction to create zeros below the pivot
            for (int row = pivot + 1; row < this.data[0].length; row++) {
                if (result[row][pivot] != 0) {
                    double factor = result[row][pivot] / result[pivot][pivot];
                    for (int col = pivot; col < this.data[1].length; col++) {
                        result[row][col] -= factor * result[pivot][col];
                    }
                }
            }
        }

        return new Matrix(result[0].length, result[1].length); // Ret
    }

    private double[][] copyData(double[][] original) {
        double[][] copy = new double[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }

    private void swapRows(double[][] matrix, int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    public double[][] getData() {
        return data;
    }

    /**
     * Biểu diễn ma trận theo định dạng
     * a11 a12 ... a1n
     * a21 a22 ... a2n
     * ...
     * am1 am2 ... amn
     * @return một chuỗi biểu diễn ma trận.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (double[] row : data) {
            for (double value : row) {
                builder.append(String.format("%10.4f", value)); // Định dạng số với 4 chữ số thập phân
            }
            builder.append("\n"); // Xuống dòng sau mỗi hàng
        }

        return builder.toString().trim(); // Loại bỏ dòng trống cuối cùng
    }

}
