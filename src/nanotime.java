package Java.BTL_ThuatToan.src;

interface RuntimeClock {
    long nano_startTime = System.nanoTime();
    long nano_endTime = System.nanoTime();
    long getRuntime ();
}
