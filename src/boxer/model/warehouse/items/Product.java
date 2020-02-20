package boxer.model.warehouse.items;

public class Product extends WarehouseItem {

    private String name;

    public Product(String name, double height, double width, double length) {
        super(height, width, length);
        this.name = name;
    }

    public Product(String name, double radius) {
        super(radius);
        this.name = name;
    }



    @Override
    public void printInfo() {
        System.out.print("Produkt - " + this.name);
        super.printInfo();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", figure=" + figure +
                "} " + super.toString();
    }

}
