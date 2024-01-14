import java.util.Arrays;

public class BoxNonPolymorphic {
    private final BoxShape shape;
    private final double[] shapeParameters;

    public BoxNonPolymorphic(BoxShape shape, double[] shapeParameters) {
        this.shape = shape;
        this.shapeParameters = shapeParameters;
    }

    public BoxNonPolymorphic(double sphereRadius) {
        this(BoxShape.SPHERE, new double[]{sphereRadius});
    }

    public BoxNonPolymorphic(double baseRadius, double height) {
        this(BoxShape.CYLINDER, new double[]{baseRadius, height});
    }

    public BoxNonPolymorphic(double xLength, double yLength, double zLength) {
        this(BoxShape.CUBOID, new double[]{xLength, yLength, zLength});
    }

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

    public double[] getLargestInsideCuboidDimensions() {
        if (shape == BoxShape.CUBOID) {
            return Arrays.copyOf(shapeParameters, shapeParameters.length);
        }
        if (shape == BoxShape.CYLINDER) {
            return new double[]{shapeParameters[0] * Math.sqrt(2), shapeParameters[0] * Math.sqrt(2), shapeParameters[1]};
        }
        if (shape == BoxShape.SPHERE) {
            double cubeSideLength = shapeParameters[0] * 2 / Math.sqrt(3);
            return new double[]{cubeSideLength, cubeSideLength, cubeSideLength};
        }
        throw new IllegalStateException("Unsupported box shape");
    }

    public double[] getSmallestOutsideCuboidDimensions() {
        if (shape == BoxShape.CUBOID) {
            return Arrays.copyOf(shapeParameters, shapeParameters.length);
        }
        if (shape == BoxShape.CYLINDER) {
            return new double[]{shapeParameters[0] * 2, shapeParameters[0] * 2, shapeParameters[1]};
        }
        if (shape == BoxShape.SPHERE) {
            double cubeSideLength = shapeParameters[0] * 2;
            return new double[]{cubeSideLength, cubeSideLength, cubeSideLength};
        }
        throw new IllegalStateException("Unsupported box shape");
    }

    public boolean fitsInto(BoxNonPolymorphic externalBox) {
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

    public String toString() {
        if (shape == BoxShape.CUBOID) {
            return String.format("Cuboid with dimensions: %f, %f, %f", shapeParameters[0], shapeParameters[1], shapeParameters[2]);
        }
        if (shape == BoxShape.CYLINDER) {
            return String.format("Cylinder with base radius: %f and height: %f", shapeParameters[0], shapeParameters[1]);
        }
        if (shape == BoxShape.SPHERE) {
            return String.format("Sphere with radius: %f", shapeParameters[0]);
        }
        return "Unsupported box shape";
    }
}
