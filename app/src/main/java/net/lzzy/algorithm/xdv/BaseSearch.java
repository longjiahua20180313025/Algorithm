package net.lzzy.algorithm.xdv;

/**
 * @author lzzy_gxy on 2019/6/22.
 * Description:
 */
public abstract class BaseSearch <T extends Comparable<?super T>> {
    T[] items;
    private long duration;
    private int compareCount;
    private int swapCount;
    BaseSearch(T[] items) {
        this.items = items;
        compareCount = 0;
        swapCount = 0;
    }


    boolean equal(T a, T b) {
        compareCount++;
        return a.compareTo(b) == 0;
    }

    int compare(T a, T b) {
        compareCount++;
        return a.compareTo(b);
    }
    void setDuration(long l) {
    }

    BaseSearch() {
    }
    public abstract int search(T key);
    public long getDuration() {
        return duration;
    }
    public void getDuration(long duration) {
        this.duration = duration;
    }
    public int getCompareCount() {
        return compareCount;
    }
    public void getCompareCount(int compareCount) {
        this.compareCount = compareCount;
    }
        public int getSwapCount() {
            return swapCount;
        }
    public void getSwapCount(int swapCount) {
        this.swapCount = swapCount;
    }
     }
