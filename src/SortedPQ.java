public class SortedPQ <E> {
    private E[] sortedArray;
    private static long currentTime;

    public static void incrementCurrentTime() { currentTime++; }

    public static long getCurrentTime() { return currentTime; }
}