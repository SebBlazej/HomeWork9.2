package boxer.model.figures;

public abstract class Figure implements Comparable<Figure> {

    private double volume;

    Figure() {
    }

    public abstract double getHeight();

    public abstract double getWidth();

    public abstract double getLength();

    abstract double countVolume();

    @Override
    public abstract int compareTo(Figure o);

    void setVolume() {
        this.volume = countVolume();
    }

    private double getVolume() {
        return this.volume;
    }

    public void printInfo() {
        System.out.println("Objetosc - " + volume);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Figure)) return false;

        Figure figure = (Figure) o;

        return Double.compare(figure.getVolume(), getVolume()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getVolume());
        return (int) (temp ^ (temp >>> 32));
    }


    int compareVolumeTo(Figure o) {
        if (this.getVolume() < o.getVolume()) return -1;
        else if (this.getVolume() == o.getVolume()) return 0;
        return 1;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "volume=" + volume +
                '}';
    }
}
