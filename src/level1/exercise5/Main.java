package level1.exercise5;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(4);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("square1.ser"))) {
            out.writeObject(square1);
            System.out.println("Object serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("square1.ser"))) {
            Square squareRecovered = (Square) in.readObject();
            System.out.println("Object deserialized: " + squareRecovered);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
