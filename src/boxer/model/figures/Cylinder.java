package boxer.model.figures;

public class Cylinder extends Figure {

    private double baseRadius;
    private double height;

    public Cylinder(double height, double baseRadius) {
        super();
        this.baseRadius = baseRadius;
        this.height = height;
        super.setVolume();
    }

    double getBaseRadius() {
        return this.baseRadius;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.baseRadius * 2;
    }

    @Override
    public double getLength() {
        return this.baseRadius * 2;
    }

    @Override
    double countVolume() {
        return (Math.PI * Math.pow(this.baseRadius, 2) * this.height);
    }

    @Override
    public void printInfo() {
        System.out.println(" - o kształcie - Cylindra");
        System.out.println("Wysokosc - " + this.height + " | Średnica podstawy - " + this.baseRadius);
        super.printInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if (!(o instanceof Cylinder)) return false;
        if (!super.equals(o)) return false;

        Cylinder cylinder = (Cylinder) o;

        if (Double.compare(cylinder.getBaseRadius(), getBaseRadius()) != 0) return false;
        return Double.compare(cylinder.getHeight(), getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getBaseRadius());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "baseRadius=" + baseRadius +
                ", height=" + height +
                "} " + super.toString();
    }
}
