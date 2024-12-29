package hus.oop.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        coefficients = new ArrayList<>();
    }

    // Hàm dựng khởi tạo coefficients kiểu List ban đầu là new ArrayList
    // Hàm dựng duy nhất của class

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] coefficientsDoubleArray = new double[coefficients.size()];
        for (int i = 0; i < coefficientsDoubleArray.length; i++) {
            coefficientsDoubleArray[i] = coefficients.get(i);
        }
        return coefficientsDoubleArray;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtStart(double coefficient) {
        /* TODO */
        this.coefficients.add(0, coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtEnd(double coefficient) {
        /* TODO */
        this.coefficients.add(this.coefficients.size() - 1, coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtPosition(double coefficient, int index) {
        /* TODO */
        this.coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        this.coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double total = 0;
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            total += coefficients.get(i) * Math.pow(x, i);
        }
        return total;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public ListPolynomial derivative() {
        /* TODO */
        if (coefficients.size() == 1) {
            return null;
        }
        List<Double> derivativeCoeffs = new ArrayList<>();
        for (int i = 1; i < coefficients.size(); i++) {
            derivativeCoeffs.add(i * coefficients.get(i));
        }
        coefficients = derivativeCoeffs;
        return this;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ListPolynomial plus(Polynomial another) {
        /* TODO */
        ListPolynomial newPolynomial = new ListPolynomial();
        int max = Math.max(this.degree(), another.degree());
        double[] newDoubleCoeffs = new double[max + 1];
        for (int i = 0; i < max + 1; i++) {
            double a = i < this.degree() ? this.coefficient(i) : 0;
            double b = i < another.degree() ? another.coefficient(i) : 0;
            newPolynomial.coefficients.add(a + b);
        }
        return newPolynomial;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plusTo(Polynomial another) {
        /* TODO */
        ListPolynomial newPolynomial = new ListPolynomial();
        int max = Math.max(this.degree(), another.degree());
        double[] newDoubleCoeffs = new double[max + 1];
        for (int i = 0; i < max + 1; i++) {
            double a = i < this.degree() ? this.coefficient(i) : 0;
            double b = i < another.degree() ? another.coefficient(i) : 0;
            newPolynomial.coefficients.add(a + b);
        }
        this.coefficients = newPolynomial.coefficients;
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là hiệu hai đa thức.
     */
    public ListPolynomial minus(Polynomial another) {
        /* TODO */
        ListPolynomial newPolynomial = new ListPolynomial();
        int max = Math.max(this.degree(), another.degree());
        for (int i = 0; i < max + 1; i++) {
            double a = i < this.degree() ? this.coefficient(i) : 0;
            double b = i < another.degree() ? another.coefficient(i) : 0;
            newPolynomial.coefficients.add(a - b);
        }
        return newPolynomial;
    }

    /**
     * Trừ đa thức hiện tại cho đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minusFrom(Polynomial another) {
        /* TODO */
        ListPolynomial newPolynomial = new ListPolynomial();
        int max = Math.max(this.degree(), another.degree());
        double[] newDoubleCoeffs = new double[max + 1];
        for (int i = 0; i < max + 1; i++) {
            double a = i < this.degree() ? this.coefficient(i) : 0;
            double b = i < another.degree() ? another.coefficient(i) : 0;
            newPolynomial.coefficients.add(a - b);
        }
        this.coefficients = newPolynomial.coefficients;
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ListPolynomial multiply(Polynomial another) {
        /* TODO */
        int maxDegree = another.degree() + this.degree();
        ListPolynomial newPolynomial = new ListPolynomial();
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                double sum = 0;
                sum += this.coefficient(i) * another.coefficient(j);
                newPolynomial.coefficients.add(sum);
            }
        }
        return newPolynomial;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiplyBy(Polynomial another) {
        /* TODO */
        int maxDegree = another.degree() + this.degree();
        ListPolynomial newPolynomial = new ListPolynomial();
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                double sum = 0;
                sum += this.coefficient(i) * another.coefficient(j);
                newPolynomial.coefficients.add(sum);
            }
        }
        this.coefficients = newPolynomial.coefficients;
        return this;
    }
}
