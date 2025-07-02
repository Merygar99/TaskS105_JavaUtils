package level1.exercise5;

import java.io.Serializable;
import java.util.Objects;

public class Square implements Serializable {
    private static final long SERIALVERSION = 1L;
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
