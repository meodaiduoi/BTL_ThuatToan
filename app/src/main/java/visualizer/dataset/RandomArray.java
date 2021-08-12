package visualizer.dataset;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class RandomArray {
    private int size = 10;
    private ArrayList<Integer> array = new ArrayList<>();

    public RandomArray () {
        arrayGenerator(false, false, false);
    }

    public RandomArray (int size) {
        this.size = size;
        arrayGenerator(false, false, false);
    }

    public RandomArray(int size, boolean isSorted){
        this.size = size;
        arrayGenerator(isSorted, false, false);
    }

    private void arrayGenerator (boolean isSorted, boolean isReversed, boolean isNearlySorted) {
        Random rd = new Random();

        for (int i = 0; i < size; i++) { array.add(rd.nextInt()); }

        if (isSorted) {

            Collections.reverse(this.array);

            if (isNearlySorted) {
                for (int i = 0; i < this.array.size(); i++) {
                    this.array.set(i, rd.nextInt());
                }
            }
        }
    }

    public int getLength() {
        return array.size();
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public int getNumber(int position) {
        return array.get(position);
    }

    public int getRandomNumber() {
        return array.get(new Random().nextInt((array.size() - 0) + 0));
    }

}
