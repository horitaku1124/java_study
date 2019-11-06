package linear_algebra;

public class Vector extends Tensor {
    private final float[] scalars;
    public Vector(float[] scalars) {
        super(1); // ベクトルは1階のテンソル
        this.scalars = scalars;
    }

    public Vector add(Vector object) {
        float[] scalars = new float[this.scalars.length];
        for (int i = 0;i < this.scalars.length;i++) {
            scalars[i] = this.scalars[i] + object.scalars[i];
        }
        return new Vector(scalars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (scalars.length > 0) {
            sb.append(scalars[0]);
            for (int i = 1;i < scalars.length;i++) {
                sb.append(", ").append(scalars[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
