import java.util.ArrayList;

public class Sort implements RuntimeClock {

    private ArrayList<Number> default_list = new ArrayList<>();
    private int time_each;

    public Sort(ArrayList<Number> array, int time_each) {
        this.default_list = array;
        this.time_each = time_each;
    }


    private double bubblesort_getRuntime, interchangesort_getRuntime, selectionsort_getRuntime, insertionsort_getRuntime;

    private ArrayList<Number> insertionsort_each_getLoopTimes = new ArrayList<>();
    private ArrayList<Number> selectionsort_each_getLoopTimes = new ArrayList<>();
    private ArrayList<Number> interchangesort_each_getLoopTimes = new ArrayList<>();
    private ArrayList<Number> bubblesort_each_getLoopTimes = new ArrayList<>();

    // return minisecond
    public double getTime(long startTimes, long endTimes) {
        return (double) (endTimes - startTimes) / 1000000000;
    }

    /**
     * Insertion Sort
     *
     * @param <T>
     * @param list
     */
    public ArrayList<Number> insertionSort() {
        ArrayList<Number> list = new ArrayList<>(default_list);
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

            if (i % time_each == 0) {
                long stop_each_time = System.nanoTime();
                insertionsort_each_getLoopTimes.add(getTime(startTime, stop_each_time));
            }

        }
        long stopTime = System.nanoTime();
        insertionsort_getRuntime = getTime(startTime, stopTime);
        return list;
    }

    /**
     * Insertion Sort
     * 
     * @param <T>
     * @param list
     */
    public ArrayList<Number> bubbleSort() {
        ArrayList<Number> list = new ArrayList<>(default_list);
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
            if (i % time_each == 0) {
                long stop_each_time = System.nanoTime();
                bubblesort_each_getLoopTimes.add(getTime(startTime, stop_each_time));
            }

        }
        long stopTime = System.nanoTime();
        bubblesort_getRuntime = getTime(startTime, stopTime);
        return list;
    }

    /**
     * Insertion Sort
     * 
     * @param <T>
     * @param list
     */
    public ArrayList<Number> selectionSort() {
        ArrayList<Number> list = new ArrayList<>(default_list);

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
            if (i % time_each == 0) {
                long stop_each_time = System.nanoTime();
                selectionsort_each_getLoopTimes.add(getTime(startTime, stop_each_time));
            }

        }
        long stopTime = System.nanoTime();
        selectionsort_getRuntime = getTime(startTime, stopTime);
        return list;
    }

    /**
     * Insertion Sort
     * 
     * @param <T>
     * @param list
     */
    public ArrayList<Number> interChangeSort() {
        ArrayList<Number> list = new ArrayList<>(default_list);

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
            if (i % time_each == 0) {
                long stop_each_time = System.nanoTime();
                interchangesort_each_getLoopTimes.add(getTime(startTime, stop_each_time));
            }
        }
        long stopTime = System.nanoTime();
        interchangesort_getRuntime = getTime(startTime, stopTime);
        return list;
    }

    public static void main(String[] args) {
        RandomArray rd = new RandomArray(5);

        Sort sort = new Sort(rd.getArray(), 1);

        System.out.println("------------insertionsort---------------");

        System.out.println(sort.default_list);
        sort.insertionSort();
        System.out.println(sort.insertionSort());
        System.out.println("Rum time: " + sort.insertionsort_getRuntime);
        System.out.println("List time: " + sort.insertionsort_each_getLoopTimes);

        System.out.println("------------bubblesort---------------");
        System.out.println(sort.default_list);
        sort.bubbleSort();
        System.out.println(sort.bubbleSort());
        System.out.println("Rum time: " + sort.bubblesort_getRuntime);
        System.out.println("List time: " + sort.bubblesort_each_getLoopTimes);

        System.out.println("-----------SELECTION---------------");
        // System.out.println(rd.getArray());
        System.out.println(sort.default_list);
        sort.selectionSort();
        System.out.println(sort.selectionSort());
        System.out.println("Rum time: " + sort.selectionsort_getRuntime);
        System.out.println("List time: " + sort.selectionsort_each_getLoopTimes);

        System.out.println("-----------InterChange---------------");
        // System.out.println(rd.getArray());
        System.out.println(sort.default_list);
        sort.selectionSort();
        System.out.println(sort.interChangeSort());
        System.out.println("Rum time: " + sort.interchangesort_getRuntime);
        System.out.println("List time: " + sort.interchangesort_each_getLoopTimes);

    }

    // return runtime and looptimes here:
    @Override
    public double bubblesort_getRuntime() {
        return bubblesort_getRuntime;
    }

    @Override
    public double interchangesort_getRuntime() {
        return insertionsort_getRuntime;
    }

    @Override
    public double insertionsort_getRuntime() {
        return insertionsort_getRuntime;
    }

    @Override
    public double selectionsort_getRuntime() {
        return selectionsort_getRuntime;
    }

    @Override
    public ArrayList<Number> bubblesort_getLoopsTimes() {
        return bubblesort_each_getLoopTimes;
    }

    @Override
    public ArrayList<Number> insertionsort_getLoopTimes() {
        return insertionsort_each_getLoopTimes;
    }

    @Override
    public ArrayList<Number> interchangesort_getLoopTimes() {
        // TODO Auto-generated method stub
        return interchangesort_each_getLoopTimes;
    }

    @Override
    public ArrayList<Number> selectionsort_getLoopTimes() {
        return selectionsort_each_getLoopTimes;
    }

}
