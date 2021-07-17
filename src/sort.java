import java.util.ArrayList;

public class Sort implements RuntimeClock {

    private ArrayList<Number> array = new ArrayList<>();
    private int loop_interval;

    public Sort(ArrayList<Number> array, int loop_interval) {
        this.array = array;
        this.loop_interval = loop_interval;
    }


    private double bubblesort_TotalRuntime, interchangesort_TotalRuntime, selectionsort_TotalRuntime, insertionsort_TotalRuntime;

    private ArrayList<Number> insertionsort_getLoopTime = new ArrayList<>();
    private ArrayList<Number> selectionsort_getLoopTime = new ArrayList<>();
    private ArrayList<Number> interchangesort_getLoopTime = new ArrayList<>();
    private ArrayList<Number> bubblesort_getLoopTime = new ArrayList<>();

    // return milisecond
    public double nanoToMili(long startTimes, long endTimes) {
        return (double) (endTimes - startTimes) / 1000000;
    }
+
    /**
     * Insertion Sort
     */
    public ArrayList<Number> insertionSort() {
        ArrayList<Number> list = new ArrayList<>(this.array);
        int size = list.size();

        if (size == 0) {
            return list;
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            // start
            int j = i;
            Number current_item = list.get(i);

            while (j > 0 && (current_item.doubleValue() - list.get(j - 1).doubleValue()) < 0) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, current_item);
            // end

            if (i % loop_interval == 0) {
                long stop_each_time = System.nanoTime();
                insertionsort_getLoopTime.add(nanoToMili(startTime, stop_each_time));
            }

        }
        long stopTime = System.nanoTime();
        insertionsort_TotalRuntime = nanoToMili(startTime, stopTime);
        return list;
    }

    /**
     * Insertion Sort
     */
    public ArrayList<Number> bubbleSort() {
        ArrayList<Number> list = new ArrayList<>(array);
        int size = list.size();

        if (size == 0) {
            return list;
        }

        long startTime = System.nanoTime();
        for (int i = 1; i < size; i++) {
            for (int j = (size - 1); j >= i; j--) {

                if (list.get(j - 1).doubleValue() - list.get(j).doubleValue() > 0) {
                    Number tmp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, tmp);
                }

            }
            if (i % loop_interval == 0) {
                long stop_each_time = System.nanoTime();
                bubblesort_getLoopTime.add(nanoToMili(startTime, stop_each_time));
            }

        }
        long stopTime = System.nanoTime();
        bubblesort_TotalRuntime = nanoToMili(startTime, stopTime);
        return list;
    }

    /**
     * Insertion Sort
     * @param list
     */
    public ArrayList<Number> selectionSort() {
        ArrayList<Number> list = new ArrayList<>(array);

        int size = list.size();

        if (size == 0) {
            return list;
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if ((list.get(minIndex).doubleValue() - list.get(j).doubleValue()) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Number tmp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, tmp);
            }
            if (i % loop_interval == 0) {
                long stop_each_time = System.nanoTime();
                selectionsort_getLoopTime.add(nanoToMili(startTime, stop_each_time));
            }

        }
        long stopTime = System.nanoTime();
        selectionsort_TotalRuntime = nanoToMili(startTime, stopTime);
        return list;
    }

    /**
     * Insertion Sort
     * @param list
     */
    public ArrayList<Number> interChangeSort() {
        ArrayList<Number> list = new ArrayList<>(array);

        int size = list.size();

        if (size == 0) {
            return list;
        }

        long startTime = System.nanoTime();

        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                if ((list.get(i).doubleValue() - list.get(j).doubleValue()) > 0) {
                    Number tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
            if (i % loop_interval == 0) {
                long stop_each_time = System.nanoTime();
                interchangesort_getLoopTime.add(nanoToMili(startTime, stop_each_time));
            }
        }
        long stopTime = System.nanoTime();
        interchangesort_TotalRuntime = nanoToMili(startTime, stopTime);
        return list;
    }

    // return runtime and looptimes here:
    @Override
    public double bubblesort_getTotalRuntime() {
        return bubblesort_TotalRuntime;
    }

    @Override
    public double interchangesort_getTotalRuntime() {
        return insertionsort_TotalRuntime;
    }

    @Override
    public double insertionsort_getTotalRuntime() {
        return insertionsort_TotalRuntime;
    }

    @Override
    public double selectionsort_getTotalRuntime() {
        return selectionsort_TotalRuntime;
    }

    @Override
    public ArrayList<Number> bubblesort_getLoopTime() {
        return bubblesort_getLoopTime;
    }

    @Override
    public ArrayList<Number> insertionsort_getLoopTime() {
        return insertionsort_getLoopTime;
    }

    @Override
    public ArrayList<Number> interchangesort_getLoopTime() {
        return interchangesort_getLoopTime;
    }

    @Override
    public ArrayList<Number> selectionsort_getLoopTime() {
        return selectionsort_getLoopTime;
    }
}
