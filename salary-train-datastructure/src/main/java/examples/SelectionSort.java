package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/12/4
 * @description:
 **/
public class SelectionSort extends AbstractArrSort {

    @Override
    public void doSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
    }
}
