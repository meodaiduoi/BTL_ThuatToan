package visualizer.dataset;

public class test {
    public static void main(String[] args) {
        RandomArray a = new RandomArray(10, true, false, true);
        System.out.println(a.getArray());

        MultiRandomArray b = new MultiRandomArray();
        System.out.println(b.getArray());
    }
}
