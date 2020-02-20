package boxer.model.warehouse.items;

import boxer.model.figures.Cuboid;
import boxer.model.figures.Cylinder;
import boxer.model.figures.Figure;
import boxer.model.figures.Sphere;

public class WarehouseItem {

    protected final Figure figure;

    WarehouseItem(Figure figure) {
        this.figure = figure;
    }

    WarehouseItem(double height, double baseRadius) {
        this.figure = new Cylinder(height, baseRadius);
    }

    WarehouseItem(double height, double width, double length) {
        this.figure = new Cuboid(height, width, length);
    }

    WarehouseItem(double radius) {
        this.figure = new Sphere(radius);
    }

    public void printInfo() {
        this.figure.printInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseItem)) return false;

        WarehouseItem that = (WarehouseItem) o;

        return figure.equals(that.figure);
    }

    @Override
    public int hashCode() {
        return figure.hashCode();
    }
}
