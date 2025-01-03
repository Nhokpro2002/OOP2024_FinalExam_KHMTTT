package hus.oop.matrix;

public class SquareMatrix extends Matrix {

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param size
     */
    public SquareMatrix(int size) {
        /* TODO */
        super(size, size);
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public double[] principalDiagonal() {
        /* TODO */
        int size = this.getData()[0].length;
        double[] diagonal = new double[size];

        for (int i = 0; i < size; i++) {
            diagonal[i] = this.getData()[i][i]; // Lấy phần tử tại hàng i, cột i
        }
        return diagonal;
    }


    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public double[] secondaryDiagonal() {
        /* TODO */
        int size = this.getData()[1].length;
        double[] diagonal = new double[size];

        for (int i = 0; i < size; i++) {
            diagonal[i] = this.getData()[i][size - i - 1]; // Lấy phần tử tại hàng i, cột i
        }
        return diagonal;
    }
}
