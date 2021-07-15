interface RuntimeClock {
    long bubblesort_getRuntime ();
    long interchangesort_getRuntime ();
    long selectionsort_getRuntime ();

    long bubblesort_getLoopsTimes ();
    long interchangesort_getLoopTimes ();
    long selectionsort_getLoopTimes ();
}
