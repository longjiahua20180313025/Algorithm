package net.lzzy.algorithm.xdv;

import android.content.ClipData;
import android.widget.AdapterView;

/**
 * @author lzzy_gxy on 2019/6/15.
 * Description:
 */
public class DirectSort<T extends Comparable<?super T>>extends BaseSort<T> {

    public DirectSort(T[] items) {
        super(items);
    }

    @Override
    public void sort() {
        for (int i = 0; i < items.length - 1; i++) {
            int ninpos = i;
            for (int j = i + 1; j < items.length; j++) {
                if (bigger(items[ninpos], items[j])) {
                    ninpos = j;
                    moveStep++;
                }
            }
            swap(ninpos, i);
        }
    }
}
