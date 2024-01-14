public class Cuboid extends Box {
    private final double xLength, yLength, zLength;

    public Cuboid(double xLength, double yLength, double zLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.zLength = zLength;
    }

    @Override
    public double[] getLargestInsideCuboidDimensions() {
        return new double[]{xLength, yLength, zLength};
    }

    @Override
    public double[] getSmallestOutsideCuboidDimensions() {
        return getLargestInsideCuboidDimensions();
    }

    @Override
    public String toString() {
        return String.format("Cuboid with dimensions: %f, %f, %f", xLength, yLength, zLength);
    }
}
