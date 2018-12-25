package number;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/19 20:26
 * @Description:
 */
public class Demo {
    class ReturnType {
        int start;
        int end;

        public ReturnType(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public ReturnType binSearch(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new ReturnType(-1, -1);
        }
        //先二分找
        int seach = binSearch(nums, 0, nums.length - 1, target);
        if (seach == -1) {
            return new ReturnType(-1, -1);
        }
        //再在两边找
        int begin = 0;
        int end = seach - 1;
        int mid;
        while (begin < end) {
            if (nums[end] < target) {
                begin = end;
                break;
            }
            mid = (begin + end) / 2;
            if (mid != begin && target > nums[mid]) {
                begin = mid;
            } else {
                end = mid - 1;
            }
        }
        int x1 = begin + 1;
        if (begin == 0 && nums[0] == target) {
            x1 = 0;
        }
        begin = seach + 1;
        end = nums.length - 1;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (target < nums[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        if (end == nums.length - 1 && nums[end] == target) {
            end = nums.length;
        }
        return new ReturnType(x1, end - 1);
    }


    public int binSearch(int[] nums, int f, int l, int target) {
        if (f > l) {
            return -1;
        }
        if (nums[(l + f) / 2] == target) {
            return (l + f) / 2;
        } else if (nums[(l + f) / 2] < target) {
            return binSearch(nums, (l + f) / 2 + 1, l, target);
        } else {
            return binSearch(nums, f, (l + f) / 2 - 1, target);
        }
    }

}
