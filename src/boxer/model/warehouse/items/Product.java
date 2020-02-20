package boxer.model.warehouse.items;

import boxer.model.figures.Cuboid;
import boxer.model.figures.Figure;
import boxer.model.figures.Sphere;

public class Product extends WarehouseItem {

    private String name;


    public Product(String name, Figure figure) {
        super(figure);
        this.name = name;
    }

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

    public int compareSizeTo(Box o) {
        if(this.figure.equals(o.figure)) return 0;
        if (this.figure instanceof Cuboid) return ((Cuboid) this.figure).compareTo(o.getFigure());
        else if (this.figure instanceof Sphere) return ((Sphere) this.figure).compareTo(o.getFigure());
        else return 1;
    }

}
