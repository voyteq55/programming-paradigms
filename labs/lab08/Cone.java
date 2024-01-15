public class Cone extends Box {
    private final double baseRadius;
    private final double height;

    public Cone(double baseRadius, double height) {
        this.baseRadius = baseRadius;
        this.height = height;
    }

    @Override
    public double[] getLargestInsideCuboidDimensions() {
        double cuboidBaseLength = 2 * Math.sqrt(2) * baseRadius / 3;
        return new double[]{cuboidBaseLength, cuboidBaseLength, height / 3};
    }

    @Override
    public double[] getSmallestOutsideCuboidDimensions() {
        return new double[]{baseRadius * 2, baseRadius * 2, height};
    }

    @Override
    public String toString() {
        return String.format("Cone with base radius: %f and height: %f", baseRadius, height);
    }
}
