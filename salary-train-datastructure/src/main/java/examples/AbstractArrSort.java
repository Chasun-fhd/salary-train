package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/12/4
 * @description:
 **/
public abstract class AbstractArrSort implements ArrSort {

    public abstract void doSort(int[] arr);

    public void sort(int[] arr) {
        doSort(arr);
        print(arr);
    }

    @Override
    public void print(int[] arr) {
        System.out.println("----------------------");
        for (int e : arr) {
            System.out.print(e + ",");
        }
        System.out.println();
        System.out.println("----------------------");
    }
}
