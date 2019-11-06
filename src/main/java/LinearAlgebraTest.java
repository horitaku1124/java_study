import linear_algebra.Matrix;
import linear_algebra.Tensor;
import linear_algebra.Vector;

public class LinearAlgebraTest {
    public static void main(String[] args) {
        Tensor o1 = new Tensor(1); // 1階のテンソル
        Tensor o2 = new Tensor(2); // 2階のテンソル


        Vector v1 = new Vector(new float[]{1, 2, 3});
        Vector v2 = new Vector(new float[]{4, 5, 6});

        System.out.println(v1);
        System.out.println(v2);

        Vector v3 = v1.add(v2);
        System.out.println(v3);

        Matrix m1 = new Matrix(new float[][] {
                {1,2,3},
                {4,5,6},
        });
        Matrix m2 = new Matrix(new float[][] {
                {7,8,9},
                {10,11,12},
        });
        System.out.println(m1);
        System.out.println(m2);

        Matrix m3 = m1.add(m2);
        System.out.println(m3);
    }
}
