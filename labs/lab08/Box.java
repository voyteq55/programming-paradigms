import java.util.Arrays;

public abstract class Box {
    public abstract double[] getLargestInsideCuboidDimensions();
    public abstract double[] getSmallestOutsideCuboidDimensions();

    public double getLargestInsideCuboidVolume() {
        double[] largestCuboidDimensions = getLargestInsideCuboidDimensions();
        if (largestCuboidDimensions.length != 3) {
            throw new IllegalStateException(String.format("Cuboid must have 3 dimensions, found %d", largestCuboidDimensions.length));
        }
        return largestCuboidDimensions[0] * largestCuboidDimensions[1] * largestCuboidDimensions[2];
    }

    public double getSmallestOutsideCuboidVolume() {
        double[] smallestCuboidDimensions = getSmallestOutsideCuboidDimensions();
        if (smallestCuboidDimensions.length != 3) {
            throw new IllegalStateException(String.format("Cuboid must have 3 dimensions, found %d", smallestCuboidDimensions.length));
        }
        return smallestCuboidDimensions[0] * smallestCuboidDimensions[1] * smallestCuboidDimensions[2];
    }

    public boolean fitsInto(Box externalBox) {
        double[] internalBoxOutsideCuboidDimensions = getSmallestOutsideCuboidDimensions();
        double[] externalBoxInsideCuboidDimensions = externalBox.getLargestInsideCuboidDimensions();
        Arrays.sort(internalBoxOutsideCuboidDimensions);
        Arrays.sort(externalBoxInsideCuboidDimensions);
        for (int i = 0; i < internalBoxOutsideCuboidDimensions.length; i++) {
            if (internalBoxOutsideCuboidDimensions[i] > externalBoxInsideCuboidDimensions[i]) {
                return false;
            }
        }
        return true;
    }
}
