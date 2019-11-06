package math;

import org.apache.commons.math3.util.FastMath;

public class SqrtTest1 {
    public static void main(String[] args) {
        for (int i = 0;i < 4;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += Math.sqrt(j);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "Math.exp", sum, (System.currentTimeMillis() - start));
        }

        for (int i = 0;i < 4;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += FastMath.sqrt(j);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "FastMath.sqrt", sum, (System.currentTimeMillis() - start));
        }

        for (int i = 0;i < 4;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += sqrt1(j);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "sqrt1", sum, (System.currentTimeMillis() - start));
        }
    }
    public static double sqrt1(final double a) {
        final long x = Double.doubleToLongBits(a) >> 32;
        double y = Double.longBitsToDouble((x + 1072632448) << 31);
        return y;
    }
}
