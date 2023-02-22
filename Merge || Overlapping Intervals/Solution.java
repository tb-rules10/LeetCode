// https://leetcode.com/problems/merge-intervals/description/

class Solution {
    public int[][] merge(int[][] nums) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(nums, (i1, i2) -> i1[0] - i2[0]);
        int[] newRange = nums[0];
        list.add(newRange);
        for(int[]range: nums){
            if(range[0]<=newRange[1]){
                newRange[1] = Math.max(range[1],newRange[1]);
            }
            else{
                newRange = range;
                list.add(newRange);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
