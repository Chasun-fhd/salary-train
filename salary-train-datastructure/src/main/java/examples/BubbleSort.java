package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/12/4
 * @description:
 **/
public class BubbleSort extends AbstractArrSort {

    @Override
    public void doSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
