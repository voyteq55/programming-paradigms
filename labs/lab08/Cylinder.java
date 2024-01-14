public class Cylinder extends Box {
    private final double baseRadius;
    private final double height;

    public Cylinder(double baseRadius, double height) {
        this.baseRadius = baseRadius;
        this.height = height;
    }

    @Override
    public double[] getLargestInsideCuboidDimensions() {
        return new double[]{baseRadius * Math.sqrt(2), baseRadius * Math.sqrt(2), height};
    }

    @Override
    public double[] getSmallestOutsideCuboidDimensions() {
        return new double[]{baseRadius * 2, baseRadius * 2, height};
    }

    @Override
    public String toString() {
        return String.format("Cylinder with base radius: %f and height: %f", baseRadius, height);
    }
}
