package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/12/4
 * @description:
 **/
public class MergeSort  extends AbstractArrSort {

    @Override
    public void doSort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);

        merge(arr, mid, left, right);
    }

    private void merge(int[] arr, int mid, int left, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid+1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j++];
            } else {
                tmp[k++] = arr[i++];
            }
        }
         while (i<=mid ) {
             tmp[k++] = arr[i++];
         }
         while (j<=right) {
             tmp[k++] = arr[j++];
         }

         //copy to original arr
        for (int m = 0; m < tmp.length; m++) {
            arr[left+m] = tmp[m];
        }
    }
}
