import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElfNonPolymorphic {
    private final List<List<BoxNonPolymorphic>> arrangedBoxes;

    public ElfNonPolymorphic() {
        arrangedBoxes = new ArrayList<>();
    }

    public void storeBoxes(List<BoxNonPolymorphic> boxes) {
        List<BoxNonPolymorphic> boxesToStore = new ArrayList<>(boxes);
        boxesToStore.sort(Comparator.comparing(BoxNonPolymorphic::getSmallestOutsideCuboidVolume).reversed());
        for (BoxNonPolymorphic currentBox : boxesToStore) {
            arrangeBox(currentBox);
        }
    }

    private void arrangeBox(BoxNonPolymorphic currentBox) {
        boolean foundBoxToPutInto = false;
        int externalBoxIndex = 0;
        while (!foundBoxToPutInto && externalBoxIndex < arrangedBoxes.size()) {
            List<BoxNonPolymorphic> currentExternalBox = arrangedBoxes.get(externalBoxIndex);
            BoxNonPolymorphic mostInsideBox = currentExternalBox.get(currentExternalBox.size() - 1);
            if (currentBox.fitsInto(mostInsideBox)) {
                currentExternalBox.add(currentBox);
                foundBoxToPutInto = true;
            }
            externalBoxIndex++;
        }
        if (!foundBoxToPutInto) {
            addNewExternalBox(currentBox);
        }
    }

    private void addNewExternalBox(BoxNonPolymorphic boxToAdd) {
        List<BoxNonPolymorphic> newExternalBox = new ArrayList<>();
        newExternalBox.add(boxToAdd);
        arrangedBoxes.add(newExternalBox);
    }

    public double getTotalStorageVolume() {
        double currentTotalStorageVolume = 0;
        for (List<BoxNonPolymorphic> currentExternalBox : arrangedBoxes) {
            currentTotalStorageVolume += currentExternalBox.get(0).getSmallestOutsideCuboidVolume();
        }
        return currentTotalStorageVolume;
    }

    public String getStorageStringRepresantation() {
        StringBuilder currentStorage = new StringBuilder();
        for (List<BoxNonPolymorphic> externalBox : arrangedBoxes) {
            currentStorage.append("External box: ");
            for (BoxNonPolymorphic box : externalBox) {
                currentStorage.append(box).append(", ");
            }
            currentStorage.append("\n");
        }
        return currentStorage.toString();
    }
}
