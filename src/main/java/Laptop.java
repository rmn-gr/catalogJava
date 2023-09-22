import java.util.Objects;

public class Laptop {
    Brand brand;
    Color color;

    public Laptop(Brand brand, Color color){
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s %s", brand, color);
    }

    @Override
    public boolean equals(Object obj) {
        Laptop lpt = (Laptop)obj;
        return this.brand == lpt.brand && this.color == lpt.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color);
    }
}
