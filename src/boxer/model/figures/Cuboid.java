package boxer.model.figures;

public class Cuboid extends Figure implements Comparable<Figure>{

    private double height;
    private double width;
    private double length;

    public Cuboid(double height, double width, double length) {
        super();
        this.height = height;
        this.length = length;
        this.width = width;
        super.setVolume();
    }

    @Override
    public int compareTo(Figure f) {
        if(this.equals(f)) return 0;
        else if(this.getHeight() <= f.getHeight()) {
            if (f instanceof Cylinder && (this.getDiagonalOfTopViewProjection() <= ((Cylinder) f).getBaseRadius() * 2)) return -1;
            else if (f instanceof Cuboid && (ifFitCuboid(((Cuboid) f)) || ifFitCuboidAfterRotationInto(((Cuboid) f)))) return -1;
        }
        return 1;
    }

    private boolean ifFitCuboid(Cuboid cuboid){
        return (this.length <= cuboid.getLength() && this.width <= cuboid.getWidth());
    }

    private boolean ifFitCuboidAfterRotationInto(Cuboid cuboid){
        return (this.length <= cuboid.getWidth() && this.width <= cuboid.getLength());
    }

    private double getDiagonalOfTopViewProjection() {
        return Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getLength(), 2));
    }


    @Override
    double countVolume() {
        return this.height * this.width * this.length;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getLength() {
        return this.length;
    }

    @Override
    public void printInfo() {
        System.out.println(" - o kształcie - Prostopadloscianu");
        System.out.println("Wysokosc - " + this.height  + " | Szerokość - " + this.width + " | Długość - " + this.length);
        super.printInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if (!(o instanceof Cuboid)) return false;
        if (!super.equals(o)) return false;

        Cuboid cuboid = (Cuboid) o;

        if (Double.compare(cuboid.getHeight(), getHeight()) != 0) return false;
        if (Double.compare(cuboid.getWidth(), getWidth()) != 0) return false;
        return Double.compare(cuboid.getLength(), getLength()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getWidth());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLength());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Cuboid{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                "} " + super.toString();
    }
}
