package net.lzzy.algorithm.xdv;

/**
 * @author lzzy_gxy on 2019/6/15.
 * Description:
 */
public class InsertSort <T extends Comparable<?super T>>extends BaseSort<T> {
    private T[] items;

    public InsertSort(T[] items) {
        super(items);
    }
    @Override
    public void sort() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < items.length; i++) {
            int j = i-1;
                if (bigger(items[i],items[j])) {
                    continue;
                }
                T tmp=items[i];
                while (j>=0&& bigger(items[j],tmp)){
                    items[j+1]=items[j];
                    j--;
                }
                items[j+1]=tmp;
        }
        duration = System.currentTimeMillis() - start;
    }

}