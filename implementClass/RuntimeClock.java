package visualizer.sort;


import java.util.ArrayList;

public interface RuntimeClock {
    double mergesort_getTotalRuntime ();
    double bubblesort_getTotalRuntime ();
    double interchangesort_getTotalRuntime ();
    double selectionsort_getTotalRuntime ();
    double insertionsort_getTotalRuntime ();

}
