package math;

import org.apache.commons.math3.util.FastMath;

public class ExpTest1 {
    public static void main(String[] args) {
        for (int i = 0;i < 5;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += Math.exp(j * 0.0001f);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "Math.exp", sum, (System.currentTimeMillis() - start));
        }

        for (int i = 0;i < 5;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += FastMath.exp(j * 0.0001f);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "FastMath.exp", sum, (System.currentTimeMillis() - start));
        }

        for (int i = 0;i < 5;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += exp1(j * 0.0001f);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "exp1", sum, (System.currentTimeMillis() - start));
        }
    }
    public static double exp1(double val) {
        final long tmp = (long) (1512775 * val + (1072693248 - 60801));
        return Double.longBitsToDouble(tmp << 32);
    }
}
