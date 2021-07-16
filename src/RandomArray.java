import java.util.ArrayList;
import java.util.Random;

public class RandomArray {
    private int size = 10;
    private ArrayList<Number> array = new ArrayList<>();
    RandomArray () {
        arrayGenerator(true);
    }

    RandomArray (int size) {
        this.size = size;
        arrayGenerator(true);
    }

    RandomArray (int size, boolean isInt) {
        this.size = size;
        arrayGenerator(isInt);
    }

    private void arrayGenerator (boolean isInt) {
        if (isInt) {
            Random rd = new Random();
            for (int i = 0; i < this.size; i++) {
                // this.array.add(rd.nextInt((100 + 100) + 1) - 100);
                this.array.add(rd.nextInt());
            }
        }
        else {
            Random rd = new Random();
            for (int i = 0; i < this.size; i++) {
                this.array.add(rd.nextDouble());
            }
        }
    }

    public int getLength() {
        return array.size();
    }

    public ArrayList<Number> getArray() {
        return array;
    }

    public Number getElement(int position) {
        return array.get(position);
    }
}
