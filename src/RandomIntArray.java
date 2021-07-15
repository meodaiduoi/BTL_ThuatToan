import java.util.ArrayList;
import java.util.Random;

public class RandomIntArray {
    private int size = 10;
    private ArrayList<Integer> array = new ArrayList<>();
    RandomIntArray () {
        arrayGenerator();
    }

    RandomIntArray (int size) {
        this.size = size;
        arrayGenerator();
    }

    private void arrayGenerator () {
        Random rd = new Random();
        for (int i = 0; i < this.size; i++) {
            this.array.add(rd.nextInt());
        }
    }

    public int getLength() {
        return array.size();
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public int getElement(int position) {
        return array.get(position);
    }
}



