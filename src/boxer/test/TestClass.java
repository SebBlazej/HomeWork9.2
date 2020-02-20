package boxer.test;

import boxer.app.BoxChooser;
import boxer.model.warehouse.items.Box;
import boxer.model.warehouse.items.Product;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        BoxChooser boxChooser = new BoxChooser();
        boxChooser.addBoxToList(createBoxList());
        List<Product> productList = createProductList();

        testBoxFitter(boxChooser, productList);
    }

    private static void testBoxFitter(BoxChooser boxChooser, List<Product> productList) {
        for (Product product : productList) {
            System.out.println();
            product.printInfo();
            try {
                System.out.println("Najlepszym pudełkiem będzie - ");
                boxChooser.findPerfectBox(product).printInfo();
                System.out.println();
            } catch (NullPointerException ex) {
                System.out.println("Nie znaleziono odpowiedniego pudełka.");
                System.out.println();
            }
        }
    }

    private static List<Box> createBoxList() {
        List<Box> boxList = new ArrayList<>();

        boxList.add(new Box(10, 7));
        boxList.add(new Box(10, 10, 10));
        boxList.add(new Box(10, 5));

        boxList.add(new Box(10, 7, 10));
        boxList.add(new Box(10, 7, 15));

        boxList.add(new Box(0.99, 1, 1));
        boxList.add(new Box(1.1, 1, 1));
        boxList.add(new Box(1, 0.5));

        boxList.add(new Box(60, 45));
        boxList.add(new Box(60, 50));
        boxList.add(new Box(75, 31));
        boxList.add(new Box(60, 60, 60));

        boxList.add(new Box(10, 4));
        boxList.add(new Box(10, 5.1));
        boxList.add(new Box(10, 5));

        boxList.add(new Box(5, 5, 10));
        boxList.add(new Box(5, 10, 7));

        boxList.add(new Box(1999, 350, 100));
        return boxList;
    }

    private static List<Product> createProductList() {
        List<Product> tempList = new ArrayList<>();

        tempList.add(new Product("Kula sniezna", 5));
        tempList.add(new Product("Sanki", 10, 7, 5));
        tempList.add(new Product("Mała kostka", 1, 1, 1));

        tempList.add(new Product("Wielkie kuliszcze", 30));
        tempList.add(new Product("Bombka", 5));

        tempList.add(new Product("Drewniany klocek", 5, 10, 5));

        tempList.add(new Product("Wielki produkt", 1999, 350, 100));

        return tempList;
    }
}
