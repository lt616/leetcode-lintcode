class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;
        
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                int[] result = new int[2];
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
            
            if (sum < target)
                start ++;
            else
                end --;
        }
        
        return null;
    }
}