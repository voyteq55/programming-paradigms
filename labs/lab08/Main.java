import java.util.List;

class Main {
    public static void main(String[] args) {
        testElf();
        testElfNonPolymorphic();
    }

    private static void testElf() {
        Sphere sphere1 = new Sphere(5);
        Sphere sphere2 = new Sphere(3);
        Cuboid cuboid1 = new Cuboid(1, 1, 500);
        Cuboid cuboid2 = new Cuboid(2, 2, 2);
        Cylinder cylinder1 = new Cylinder(2, 2);
        Cylinder cylinder2 = new Cylinder(4, 3);
        Cone cone1 = new Cone(3, 7);
        Cone cone2 = new Cone(1, 1);

        List<Box> boxesToStore = List.of(sphere1, sphere2, cuboid1, cuboid2, cylinder1, cylinder2, cone1, cone2);
        Elf elf = new Elf();
        elf.storeBoxes(boxesToStore);
        System.out.printf("\nPolymorphic elf test:\n%s", elf.getStorageStringRepresentation());
        System.out.printf("Total (external) volume: %f\n", elf.getTotalStorageVolume());
    }

    private static void testElfNonPolymorphic() {
        BoxNonPolymorphic sphere1 = new BoxNonPolymorphic(5);
        BoxNonPolymorphic sphere2 = new BoxNonPolymorphic(3);
        BoxNonPolymorphic cuboid1 = new BoxNonPolymorphic(1, 1, 500);
        BoxNonPolymorphic cuboid2 = new BoxNonPolymorphic(2, 2, 2);
        BoxNonPolymorphic cylinder1 = new BoxNonPolymorphic(2, 2);
        BoxNonPolymorphic cylinder2 = new BoxNonPolymorphic(4, 3);
        BoxNonPolymorphic cone1 = new BoxNonPolymorphic(BoxShape.CONE, new double[]{3, 7});
        BoxNonPolymorphic cone2 = new BoxNonPolymorphic(BoxShape.CONE, new double[]{1, 1});

        List<BoxNonPolymorphic> boxesToStore = List.of(sphere1, sphere2, cuboid1, cuboid2, cylinder1, cylinder2, cone1, cone2);
        ElfNonPolymorphic elfNonPolymorphic = new ElfNonPolymorphic();
        elfNonPolymorphic.storeBoxes(boxesToStore);
        System.out.printf("\nNon-polymorphic elf test:\n%s", elfNonPolymorphic.getStorageStringRepresantation());
        System.out.printf("Total (external) volume: %f\n", elfNonPolymorphic.getTotalStorageVolume());
    }
}
