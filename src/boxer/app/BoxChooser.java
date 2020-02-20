package boxer.app;

import boxer.model.warehouse.items.Box;
import boxer.model.warehouse.items.Product;

import java.util.ArrayList;
import java.util.List;

public class BoxChooser {

    private List<Box> boxList = new ArrayList<>();

    public BoxChooser() {
    }

    public void addBoxToList(Box box) {
        this.boxList.add(box);
    }

    public void addBoxToList(List<Box> boxList) {
        this.boxList.addAll(boxList);
    }

    public Box findPerfectBox(Product product) {
        List<Box> possibleBoxesList = findPossibleBoxes(product);

        return findSmallestBox(possibleBoxesList);
    }

    private Box findSmallestBox(List<Box> possibleBoxesList) {
        Box smallestBox = null;
        if (possibleBoxesList.size() == 1) return possibleBoxesList.get(0);
        else if (possibleBoxesList.size() > 1) {
            smallestBox = possibleBoxesList.get(0);
            possibleBoxesList.remove(smallestBox);
            for (Box box : possibleBoxesList) {
                smallestBox = getSmallerBox(smallestBox, box);
            }
        }
        return smallestBox;
    }

    private Box getSmallerBox(Box firstBox, Box secondBox) {
        if (firstBox.compareTo(secondBox) <= 0) return firstBox;
        else return secondBox;
    }

    private List<Box> findPossibleBoxes(Product product) {
        List<Box> tempList = new ArrayList<>();
        for (Box box : boxList) {
            if (product.compareTo(box) <= 0) tempList.add(box);
        }
        return tempList;
    }

}
