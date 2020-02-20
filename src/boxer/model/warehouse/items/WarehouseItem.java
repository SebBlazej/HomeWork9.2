package boxer.model.warehouse.items;

import boxer.model.figures.Cuboid;
import boxer.model.figures.Cylinder;
import boxer.model.figures.Figure;
import boxer.model.figures.Sphere;

public class WarehouseItem implements Comparable<WarehouseItem> {

    final Figure figure;

    WarehouseItem(double height, double baseRadius) {
        this.figure = new Cylinder(height, baseRadius);
    }

    WarehouseItem(double height, double width, double length) {
        this.figure = new Cuboid(height, width, length);
    }

    WarehouseItem(double radius) {
        this.figure = new Sphere(radius);
    }

    @Override
    public int compareTo(WarehouseItem o) {
        return this.figure.compareTo(o.getFigure());
    }

    private Figure getFigure() {
        return this.figure;
    }

    void printInfo() {
        this.figure.printInfo();
    }


    @Override
    public String toString() {
        return "WarehouseItem{" +
                "figure=" + figure +
                '}';
    }
}
