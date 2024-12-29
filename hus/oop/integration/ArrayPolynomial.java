package hus.oop.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    // Class chỉ có 1 hàm dựng để khởi tạo dữ liệu

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        return coefficents;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtStart(double coefficient) {
        /* TODO */
        if (size == coefficents.length) {
            enlarge();
        }
        insertAtPosition(coefficient, 0);
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtEnd(double coefficient) {
        /* TODO */
        if (size == coefficents.length) {
            enlarge();
        }
        insertAtPosition(coefficient, coefficents.length - 1);
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtPosition(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == coefficents.length) {
            enlarge();
        }
        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficents.length - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double total = 0;
        for (int i = coefficents.length - 1; i >= 0; i--) {
            total += coefficents[i] * Math.pow(x, i);
        }
        return total;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public ArrayPolynomial derivative() {
        /* TODO */
        if (coefficents.length == 1) {
            return null;
        }
        double[] derivativeCoeffs = new double[coefficents.length - 1];
        for (int i = 1; i < coefficents.length; i++) {
            derivativeCoeffs[i - 1] = i * coefficents[i];
        }
        coefficents = derivativeCoeffs;
        return this;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ArrayPolynomial plus(Polynomial another) {
        /* TODO */
        ArrayPolynomial newPolynomial = new ArrayPolynomial();
        int max = Math.max(this.degree(), another.degree());
        double[] newDoubleCoeffs = new double[max + 1];
        for (int i = 0; i < max + 1; i++) {
            double a = i < this.degree() ? this.coefficient(i) : 0;
            double b = i < another.degree() ? another.coefficient(i) : 0;
            newPolynomial.coefficents[i] = a + b;
        }
        return newPolynomial;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plusTo(Polynomial another) {
        /* TODO */
        ArrayPolynomial newPolynomial = new ArrayPolynomial();
        int max = Math.max(this.degree(), another.degree());
        double[] newDoubleCoeffs = new double[max + 1];
        for (int i = 0; i < max + 1; i++) {
            double a = i < this.degree() ? this.coefficient(i) : 0;
            double b = i < another.degree() ? another.coefficient(i) : 0;
            newPolynomial.coefficents[i] = a + b;
        }
        this.coefficents = newPolynomial.coefficents;
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là hiệu hai đa thức.
     */
    public ArrayPolynomial minus(Polynomial another) {
        /* TODO */
        ArrayPolynomial newPolynomial = new ArrayPolynomial();
        int max = Math.max(this.degree(), another.degree());
        double[] newDoubleCoeffs = new double[max + 1];
        for (int i = 0; i < max + 1; i++) {
            double a = i < this.degree() ? this.coefficient(i) : 0;
            double b = i < another.degree() ? another.coefficient(i) : 0;
            newPolynomial.coefficents[i] = a - b;
        }
        return newPolynomial;
    }

    /**
     * Trừ đa thức hiện tại cho đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minusFrom(Polynomial another) {
        /* TODO */
        ArrayPolynomial newPolynomial = new ArrayPolynomial();
        int max = Math.max(this.degree(), another.degree());
        double[] newDoubleCoeffs = new double[max + 1];
        for (int i = 0; i < max + 1; i++) {
            double a = i < this.degree() ? this.coefficient(i) : 0;
            double b = i < another.degree() ? another.coefficient(i) : 0;
            newPolynomial.coefficents[i] = a - b;
        }
        this.coefficents = newPolynomial.coefficents;
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ArrayPolynomial multiply(Polynomial another) {
        /* TODO */
        ArrayPolynomial newPolynomial = new ArrayPolynomial();
        int max = this.degree() + another.degree();
        newPolynomial.coefficents = new double[max + 1];
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j < another.degree(); j++) {
                double total =+ this.coefficient(i) * another.coefficient(j);
                newPolynomial.coefficents[i + j] = total;
            }
        }
        return newPolynomial;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiplyBy(Polynomial another) {
        /* TODO */
        ArrayPolynomial newPolynomial = new ArrayPolynomial();
        int max = this.degree() + another.degree();
        newPolynomial.coefficents = new double[max + 1];
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j < another.degree(); j++) {
                double total =+ this.coefficient(i) * another.coefficient(j);
                newPolynomial.coefficents[i + j] = total;
            }
        }
        this.coefficents = newPolynomial.coefficents;
        return this;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        coefficents = Arrays.copyOf(coefficents, coefficents.length * 2);
    }
}
