package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/12/4
 * @description:
 **/
public class InsertionSort extends AbstractArrSort {

    @Override
    public void doSort(int[] arr) {
        for (int i =1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            if (j != i) {
                arr[j] = tmp;
            }
        }
    }
}
