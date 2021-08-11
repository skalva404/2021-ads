package kalva.learnings.ads.cyclicsort;

public class CyclicSort {

    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && i != nums[i]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 6, 4, 3, 1, 5, 0};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{1, 5, 6, 4, 3, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
