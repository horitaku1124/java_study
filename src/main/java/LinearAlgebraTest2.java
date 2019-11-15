import linear_algebra.Matrix;
import linear_algebra.Tensor;
import linear_algebra.Vector;

public class LinearAlgebraTest2 {
    public static void main(String[] args) {
        Vector v1 = new Vector(new float[] {1, 2, 3});
        Vector v2 = v1.multiply(10);
        System.out.println(v2);

        Matrix m1 = new Matrix(new float[][] {
                {1, 2, 3},
                {4, 5, 6},
        });
        Matrix m2 = m1.multiply(10);
        System.out.println(m2);


        Vector v10 = new Vector(new float[] {1, 2, 3}, false);
        Vector v11 = new Vector(new float[] {4, 5, 6}, true);
        float result = v10.innerProduct(v11);
        System.out.println(result);

        Matrix m10 = new Matrix(new float[][] {
                {1, 2},
                {3, 4},
        });
        Matrix m11 = new Matrix(new float[][] {
                {5, 6},
                {7, 8},
        });
        System.out.println(m10.matrixMultiplication(m11));
    }
}
