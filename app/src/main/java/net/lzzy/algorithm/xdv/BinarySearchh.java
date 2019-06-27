package net.lzzy.algorithm.xdv;

/**
 * @author lzzy_gxy on 2019/6/22.
 * Description:
 */
public class BinarySearchh <T extends Comparable<? super T>>extends BaseSearch<T>{
   BinarySearchh(T[] items) {
        super(items);
    }
    @Override
    public int search(T key) {
       long start=System.currentTimeMillis();
       int left=0;
       int right=items.length-1;
       while (left<=right){
           int mid=(left+right)/2;
           int comp=compare(key,items[mid]);
           if (comp==0){
               setDuration(System.currentTimeMillis()-start);
          return mid;
           }else if (comp>0){
               left=mid+1;
           }else {
               right=mid-1;
           }
       }
        setDuration(System.currentTimeMillis()-start);
        return 0;
    }


}
