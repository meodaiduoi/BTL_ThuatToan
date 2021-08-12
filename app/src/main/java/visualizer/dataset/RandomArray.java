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

    public RandomArray(int size, boolean isSorted) {
        this.size = size;
        arrayGenerator(isSorted, false, false);
    }

    public RandomArray(int size, boolean isSorted, boolean isReversed, boolean isNearlySorted) {
        this.size = size;
        arrayGenerator(isSorted, isReversed, isNearlySorted);
    }

    private void arrayGenerator (boolean isSorted, boolean isReversed, boolean isNearlySorted) {
        Random rd = new Random();

        for (int i = 0; i < this.size; i++) {
            array.add(rd.nextInt());
            //array.add(rd.nextInt(10)+1);
        }

        if (isSorted) {

            Collections.sort(this.array);

            if (isReversed) {
            Collections.reverse(this.array);
            }

            if (isNearlySorted) {
                this.array.set(new Random().nextInt((array.size() - 0) + 0), rd.nextInt());
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
