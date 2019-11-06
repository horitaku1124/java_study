package math;

import org.apache.commons.math3.util.FastMath;

public class PowTest1 {
    public static void main(String[] args) {
        for (int i = 0;i < 3;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += Math.pow(j, 2);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "Math.pow", sum, (System.currentTimeMillis() - start));
        }
        for (int i = 0;i < 3;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += FastMath.pow(j, 2);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "FastMath.pow", sum, (System.currentTimeMillis() - start));
        }

        for (int i = 0;i < 3;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += pow1(j, 2);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "pow1", sum, (System.currentTimeMillis() - start));
        }

        for (int i = 0;i < 3;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += pow2(j, 2);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "pow2", sum, (System.currentTimeMillis() - start));
        }

        for (int i = 0;i < 3;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += pow3(j, 2);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "pow3", sum, (System.currentTimeMillis() - start));
        }

        for (int i = 0;i < 3;i++) {
            long start;
            double sum = 0;
            start = System.currentTimeMillis();
            for (int j = 0;j < 1000000;j++) {
                sum += pow4(j, 2);
            }
            System.out.format("%-13s sum= %8.0f %dms\n", "pow4", sum, (System.currentTimeMillis() - start));
        }
    }

    public static double pow1(final double a, final double b) {
        final int x = (int) (Double.doubleToLongBits(a) >> 32);
        final int y = (int) (b * (x - 1072632447) + 1072632447);
        return Double.longBitsToDouble(((long) y) << 32);
    }

    public static double pow2(final double a, final double b) {
        final long tmp = Double.doubleToLongBits(a);
        final long tmp2 = (long)(b * (tmp - 4606921280493453312L)) + 4606921280493453312L;
        return Double.longBitsToDouble(tmp2);
    }

    public static double pow3(final double a, final double b) {
        final double x = (Double.doubleToLongBits(a) >> 32);
        final long tmp2 = (long) (1512775 * (x - 1072632447) / 1512775 * b + (1072693248 - 60801));
        return Double.longBitsToDouble(tmp2 << 32);
    }
    public static double pow4(final double a, final double b) {
        final int tmp = (int) (Double.doubleToLongBits(a) >> 32);
        final int tmp2 = (int) (b * (tmp - 1072632447) + 1072632447);
        return Double.longBitsToDouble(((long) tmp2) << 32);
    }
}
