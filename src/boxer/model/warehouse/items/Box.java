package boxer.model.warehouse.items;

import boxer.model.figures.Figure;

public class Box extends WarehouseItem implements Comparable<Box> {

    public Box(Figure figure) {
        super(figure);
    }

    public Box(double height, double baseRadius){
        super(height, baseRadius);
    }

    public Box(double height, double width, double length){
        super(height, width, length);
    }

    @Override
    public String toString() {
        return "Box{} " + super.figure.toString();
    }

    @Override
    public void printInfo(){
        System.out.print("Pudelko");
        super.printInfo();
    }

    @Override
    public int compareTo(Box o) {
        return figure.compareVolumeTo(o.getFigure());
    }

    Figure getFigure(){
        return super.figure;
    }

}
