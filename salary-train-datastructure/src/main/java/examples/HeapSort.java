package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/12/4
 * @description:
 **/
public class HeapSort extends AbstractArrSort {

    @Override
    public void doSort(int[] arr) {
        buildMaxHeap(arr, arr.length);
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int)Math.floor(len / 2); i >=0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right  < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
