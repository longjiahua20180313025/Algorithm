package net.lzzy.algorithm.xdv;
/**
 * @author lzzy_gxy on 2019/6/22.
 * Description:
 */
public class SearchFactory {
    public static <T extends Comparable<? super T>> BaseSearch<T> getInstance(int key,T[] items){
        BaseSearch<T> search;
        switch (key){
            case 0:
                search =new DirectSearch<>(items);
                break;
            case 1:
                search=new BinarySearchh<>(items);
                break;
            default:
                return null;
        }
        return search;
    }
    public static String[]getSortNames(){
        return new String[]{"选择排序","直接选择排序","希尔排序"};
    }
}
