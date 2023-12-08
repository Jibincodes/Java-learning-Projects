package businessmathe2;

public class gaussianelimination {

    public static void main(String[] args) {
        double[][] coefficients = {
            {1, 3, 4},
            {2, 4, 7}
        };
       
        int n = coefficients.length;
        double[] x = new double[n];
        //----------------------------------------------------
     //Algorithm 1: Reduction
        for (int k = 0; k < n; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = coefficients[i][k] / coefficients[k][k];
                for (int j = k; j <= n; j++) {
                    coefficients[i][j] -= factor * coefficients[k][j];
                }
            }
        }
        //------------------------------------------------------
     // Algorithm 2: The substitution part
        for (int i = n - 1; i >= 0; i--) {
            x[i] = coefficients[i][n];
            for (int j = i + 1; j < n; j++) {
                x[i] -= coefficients[i][j] * x[j];
            }
            x[i] /= coefficients[i][i];
        }
        System.out.println("Solution of the equations are:");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
