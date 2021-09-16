package kalva.learnings.ads.cyclicsort;

public class MissingNumber {

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

    private static int findMissingNumber(int[] nums) {
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        MissingNumber.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        System.out.println(findMissingNumber(arr));

        arr = new int[]{2, 6, 4, 3, 1, 5, 0};
        MissingNumber.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        System.out.println(findMissingNumber(arr));

        arr = new int[]{1, 5, 6, 4, 3, 2};
        MissingNumber.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        System.out.println(findMissingNumber(arr));

        arr = new int[]{ 8, 3, 5, 2, 4, 6, 0, 1 };
        MissingNumber.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        System.out.println(findMissingNumber(arr));
    }
}
