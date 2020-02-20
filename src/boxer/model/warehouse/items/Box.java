package boxer.model.warehouse.items;


public class Box extends WarehouseItem {

    public Box(double height, double baseRadius) {
        super(height, baseRadius);
    }

    public Box(double height, double width, double length) {
        super(height, width, length);
    }

    @Override
    public void printInfo() {
        System.out.print("Pudelko");
        super.printInfo();
    }

    @Override
    public String toString() {
        return "Box{} " + super.figure.toString();
    }


}
