package hus.oop.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        double[] coeffs = coefficients();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i] == 0) {
                continue;
            }

            if (!sb.isEmpty()) {
                sb.append(" + ");
            }

            if (i == 0) {
                sb.append(coeffs[i]);
            } else if (i == 1){
                sb.append(coeffs[i]).append("x");
            } else {
                sb.append(coeffs[i]).append("x^n");
            }
        }
        return sb.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        double[] coeffs = coefficients();
        if (coeffs.length <= 1) {
            return new double[]{0};
        }

        double[] derivativeCoeffs = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            derivativeCoeffs[i - 1] = i * coeffs[i];
        }
        return derivativeCoeffs;
    }
}
