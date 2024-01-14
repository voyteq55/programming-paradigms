import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Elf {
    private final List<List<Box>> arrangedBoxes;

    public Elf() {
        arrangedBoxes = new ArrayList<>();
    }

    public void storeBoxes(List<Box> boxes) {
        List<Box> boxesToStore = new ArrayList<>(boxes);
        boxesToStore.sort(Comparator.comparing(Box::getSmallestOutsideCuboidVolume).reversed());
        for (Box currentBox : boxesToStore) {
            arrangeBox(currentBox);
        }
    }

    private void arrangeBox(Box currentBox) {
        boolean foundBoxToPutInto = false;
        int externalBoxIndex = 0;
        while (!foundBoxToPutInto && externalBoxIndex < arrangedBoxes.size()) {
            List<Box> currentExternalBox = arrangedBoxes.get(externalBoxIndex);
            Box mostInsideBox = currentExternalBox.get(currentExternalBox.size() - 1);
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

    private void addNewExternalBox(Box boxToAdd) {
        List<Box> newExternalBox = new ArrayList<>();
        newExternalBox.add(boxToAdd);
        arrangedBoxes.add(newExternalBox);
    }

    public double getTotalStorageVolume() {
        double currentTotalStorageVolume = 0;
        for (List<Box> currentExternalBox : arrangedBoxes) {
            currentTotalStorageVolume += currentExternalBox.get(0).getSmallestOutsideCuboidVolume();
        }
        return currentTotalStorageVolume;
    }

    public String getStorageStringRepresentation() {
        StringBuilder currentStorage = new StringBuilder();
        for (List<Box> externalBox : arrangedBoxes) {
            currentStorage.append("External box: ");
            for (Box box : externalBox) {
                currentStorage.append(box).append(", ");
            }
            currentStorage.append("\n");
        }
        return currentStorage.toString();
    }
}
