package net.lzzy.algorithm.xdv;

/**
 * @author lzzy_gxy on 2019/6/15.
 * Description:
 */
public  abstract class BaseSort<T extends Comparable<?super T>> {
    T[] items;
  long duration;
    private int compareCount;
    private int swapCount;
    int moveStep;
     BaseSort(T[] items) {
        this.items = items;
        compareCount = 0;
        duration=0;
        swapCount = 0;
        moveStep = 0;
    }

    boolean bigger(T a, T b) {
        compareCount++;
        return a.compareTo(b) > 0;
    }

    void swap(int i, int j){
        T num=(T)items[i];
        items[i] = items[j];
        items[j] = num;
        swapCount++;
    }

   public abstract void sort();
    public void sortwithtime(){
        long start=System.currentTimeMillis();
        sortwithtime();
        duration=System.currentTimeMillis()-start;

  }

    public long getDuration () {
        return duration;
    }

    public int getCompareCount () {
        return compareCount;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public int getMoveStep() {
        return moveStep;
    }

    public String getResult(){
        String display=" ";
        for (T i:items) {
            display=display.concat(i+",");
        }
            display=display.substring(0,display.length()-1);
            return display;
    }
}

