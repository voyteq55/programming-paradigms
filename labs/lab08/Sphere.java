public class Sphere extends Box {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double[] getLargestInsideCuboidDimensions() {
        double cubeSideLength = radius * 2 / Math.sqrt(3);
        return new double[]{cubeSideLength, cubeSideLength, cubeSideLength};
    }

    @Override
    public double[] getSmallestOutsideCuboidDimensions() {
        double cubeSideLength = radius * 2;
        return new double[]{cubeSideLength, cubeSideLength, cubeSideLength};
    }

    @Override
    public String toString() {
        return String.format("Sphere with radius: %f", radius);
    }
}
