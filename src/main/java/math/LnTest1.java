package math;

public class LnTest1 {

    public static void main(String[] args) {
        System.out.println("a=" + Math.pow(Math.E, 2));
        System.out.println("b=" + ln(2));
        System.out.println("a=" + Math.pow(Math.E, 1.12));
        System.out.println("b=" + ln(1.12));
        System.out.println("a=" + Math.pow(Math.E, 0));
        System.out.println("b=" + ln(0));

        long start, stop;
        double sum = 0;
        start = System.nanoTime();
        for (int i = 0;i < 1000000;i++) {
            sum += Math.pow(Math.E, 2);
        }
        System.out.println("sum=" + sum + "\nnano=" + (System.nanoTime() - start));

        sum = 0;
        start = System.nanoTime();
        for (int i = 0;i < 1000000;i++) {
            double val = ln(i);
            if (Double.isNaN(val)) {
                System.out.println("Nan=" + i);
            }
            sum += val;
        }
        System.out.println("sum=" + sum + "\nnano=" + (System.nanoTime() - start));

    }
    public static double ln(double val) {
        final long tmp = (long) (1512775 * val + (1072693248 - 60801));
        return Double.longBitsToDouble(tmp << 32);
    }
}
