// https://leetcode.com/problems/merge-intervals/description/

class Solution {
    public int[][] merge(int[][] nums) {
        int n =  nums.length, i, j;
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(nums, (i1, i2) -> i1[0] - i2[0]);
        for(i=0; i<n; i++){
            for(j=i+1; j<n; j++){
                if(nums[j][0] <= nums[i][1] && nums[i][1] <= nums[j][1]
                    || nums[i][0] <= nums[j][0] && nums[j][0] <= nums[i][1]
                ){
                    nums[j][0] = Math.min(nums[i][0],nums[j][0]);
                    nums[j][1] = Math.max(nums[i][1],nums[j][1]);
                    i = j;
                }
                else break;
            }
            list.add(nums[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
