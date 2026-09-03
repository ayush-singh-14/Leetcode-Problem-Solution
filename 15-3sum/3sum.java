class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int n1 = nums[i];
            int target = -n1;

            twoSum(nums, i + 1, nums.length - 1, target);
        }

        return ans;
    }

    public void twoSum(int[] nums, int low, int high, int target) {

        while (low < high) {

            int sum = nums[low] + nums[high];

            if (sum > target) {
                high--;
            }

            else if (sum < target) {
                low++;
            }

            else {

                List<Integer> list = new ArrayList<>();

                list.add(-target);
                list.add(nums[low]);
                list.add(nums[high]);

                ans.add(list);

                low++;
                high--;

                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }

                while (low < high && nums[high] == nums[high + 1]) {
                    high--;
                }
            }
        }
    }
}