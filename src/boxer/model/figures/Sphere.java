package boxer.model.figures;

public class Sphere extends Figure implements Comparable<Figure> {

    private double radius;

    public Sphere(double radius) {
        super();
        this.radius = radius;
        super.setVolume();
    }

    @Override
    public int compareTo(Figure f) {
        if (this.equals(f)) return 0;
        else if (this.getHeight() <= f.getHeight()) {
            if (f instanceof Cuboid && (this.radius * 2 <= f.getWidth() && this.radius * 2 <= f.getLength())) return -1;
            else if (f instanceof Cylinder && (this.radius <= ((Cylinder) f).getBaseRadius())) return -1;
        }
        return 1;
    }

    @Override
    public double getHeight() {
        return this.radius * 2;
    }

    @Override
    public double getWidth() {
        return this.radius * 2;
    }

    @Override
    public double getLength() {
        return this.radius * 2;
    }

    @Override
    double countVolume() {
        return ((4 * Math.PI * Math.pow(this.radius, 3)) / 3);
    }

    private double getRadius() {
        return this.radius;
    }

    @Override
    public void printInfo() {
        System.out.println(" - o kształcie -  Sfery");
        System.out.println("Wysokość " + this.getHeight() + " | Średnica - " + this.radius);
        super.printInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Sphere)) return false;
        if (!super.equals(o)) return false;

        Sphere sphere = (Sphere) o;

        return Double.compare(sphere.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
