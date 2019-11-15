package linear_algebra;

public class Matrix extends Tensor {
    private final float[][] o2scalars;
    public Matrix(float[][] o2scalars) {
        super(2); // 行列は2階のテンソル
        this.o2scalars = o2scalars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(o2scalars.length).append(" x ").append(o2scalars[0].length).append("\n");
        for (int i = 0;i < o2scalars.length;i++) {
            sb.append("|");
            for (int j = 0;j < o2scalars[i].length;j++) {
                sb.append(String.format("% 5.1f|", o2scalars[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Matrix add(Matrix object) {
        float[][] o2scalars = new float[this.o2scalars.length][this.o2scalars[0].length];

        for (int i = 0;i < this.o2scalars.length;i++) {
            for (int j = 0;j < this.o2scalars[i].length;j++) {
                o2scalars[i][j] = this.o2scalars[i][j] + object.o2scalars[i][j];
            }
        }
        return new Matrix(o2scalars);
    }

    public Matrix multiply(float scalar) {
        float[][] o2scalars = new float[this.o2scalars.length][this.o2scalars[0].length];

        for (int i = 0;i < this.o2scalars.length;i++) {
            for (int j = 0;j < this.o2scalars[i].length;j++) {
                o2scalars[i][j] = this.o2scalars[i][j] * scalar;
            }
        }
        return new Matrix(o2scalars);
    }

    public Matrix matrixMultiplication(Matrix object) {
        final float[][] our = o2scalars;
        float[][] newScalars = new float[our.length][our[0].length];
        for (int i = 0;i < our.length;i++) {
            for (int j = 0;j < our[0].length;j++) {

                float sum = 0;
                for (int k = 0;k < our.length;k++) {
                    sum += our[i][k] * object.o2scalars[k][j];
                }
                newScalars[i][j] = sum;
            }
        }

        return new Matrix(newScalars);
    }
}
