package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/12/4
 * @description:
 **/
public class QuickSort extends AbstractArrSort {

    @Override
    public void doSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivotIdx = partition(arr, left, right);
        System.out.println("pivotIdx:" + pivotIdx);
        quickSort(arr, left, pivotIdx-1);
        quickSort(arr, pivotIdx+1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        System.out.println("pivot:" + pivot);
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                if (i==j) i++;
                else {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    print(arr);
                }
            }
        }
        int tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
        return i;
    }
}
