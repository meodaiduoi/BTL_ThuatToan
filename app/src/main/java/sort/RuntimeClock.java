package sort;


import java.util.ArrayList;

interface RuntimeClock {
    double bubblesort_getTotalRuntime ();
    double interchangesort_getTotalRuntime ();
    double selectionsort_getTotalRuntime ();
    double insertionsort_getTotalRuntime ();

    ArrayList<Number> bubblesort_getLoopTime ();
    ArrayList<Number> interchangesort_getLoopTime ();
    ArrayList<Number> selectionsort_getLoopTime ();
    ArrayList<Number> insertionsort_getLoopTime ();

}
