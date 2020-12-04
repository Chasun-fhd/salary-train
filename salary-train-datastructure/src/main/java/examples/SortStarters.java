package examples;

import java.util.Arrays;

/**
 * @author: haidong.feng
 * @createdAt: 2020/12/4
 * @description:
 **/
public class SortStarters {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{2,3,8,1,6,7,5,4};
        //new BubbleSort().sort(arr);
        //new InsertionSort().sort(arr);
        //new SelectionSort().sort(arr);
        //new MergeSort().sort(arr);
        //new QuickSort().sort(arr);
        arr = new HeapSort1().sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }


    public static class HeapSort1 {

        public int[] sort(int[] sourceArray) throws Exception {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

            int len = arr.length;

            buildMaxHeap(arr, len);

            for (int i = len - 1; i > 0; i--) {
                swap(arr, 0, i);
                len--;
                heapify(arr, 0, len);
            }
            return arr;
        }

        private void buildMaxHeap(int[] arr, int len) {
            for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
                heapify(arr, i, len);
            }
        }

        private void heapify(int[] arr, int i, int len) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < len && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < len && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != i) {
                swap(arr, i, largest);
                heapify(arr, largest, len);
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
