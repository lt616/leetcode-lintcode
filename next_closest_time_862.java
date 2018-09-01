/* 
862. Next Closest Time

Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
Example

Given time = "19:34", return "19:39".

Explanation: 
The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.

Given time = "23:59", return "22:22".

Explanation: 
The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Can be optimised: validate time format when constructing them, early terminate. 
*/ 

class Pair {
    int hour; 
    int minute; 
    public Pair(int hour, int minute) {
        this.hour = hour; 
        this.minute = minute; 
    }
}

public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */ 
    
    long min_diff = Long.MAX_VALUE;
    String closest_time = ""; 
    
    public String nextClosestTime(String time) {
        // write your code here 
        
        Set<Character> nums_set = new HashSet(); 
        
        time = time.replace(":", "");  
        for (int i = 0;i < 4;i ++) {
            nums_set.add(time.charAt(i));  
        } 
        
        char[] nums = new char[nums_set.size()]; 
        int index = -1; 
        for (Character c : nums_set) {
            nums[++ index] = c; 
        } 
        
        /*String str1 = "0034"; 
        String str2 = "1939"; 
        
        Pair time1 = stringToTime(str1); 
        Pair time2 = stringToTime(str2); 
        
        long diff = calculateTime(time1, time2); 
        System.out.println(diff); */ 
        
        StringBuilder buffer = new StringBuilder(); 
        permuteDFS(nums, stringToTime(time), buffer); 
        
        StringBuilder res = new StringBuilder(); 
        res.append(closest_time.substring(0, 2)); 
        res.append(":"); 
        res.append(closest_time.substring(2, 4)); 
        
        return res.toString();  
    } 
    
    private void permuteDFS(char[] nums, Pair target, StringBuilder buffer) {
        if (buffer.length() == 4) { 
            
            String time_str = buffer.toString(); 
            Pair time = stringToTime(time_str); 
            if (! validateTime(time)) {
                return; 
            }

            long diff = calculateTime(time, target); 
            if (diff < min_diff) {
                min_diff = diff; 
                closest_time = time_str; 
            } 
            
            return; 
        } 
        
        for (int i = 0;i < nums.length;i ++) {
            buffer.append(nums[i]); 
            permuteDFS(nums, target, buffer); 
            buffer.deleteCharAt(buffer.length() - 1); 
        }
    } 
    
    private boolean validateTime(Pair time) {
        if (time.hour > 24) {
            return false; 
        } 
        
        if (time.minute > 59) {
            return false;
        } 
        
        return true; 
    }
    
    private Pair stringToTime(String str) {
        int hour = Integer.parseInt(str.substring(0, 2)); 
        int minute = Integer.parseInt(str.substring(2, 4)); 
        return new Pair(hour, minute); 
    }
    
    private long calculateTime(Pair time1, Pair time2) {
        int hour1 = time1.hour, hour2 = time2.hour; 
        int minute1 = time1.minute, minute2 = time2.minute; 
        
        if (hour1 == hour2 && minute1 == minute2) {
            return 24 * 60; 
        }
        
        int diff_min = (minute1 < minute2) ? (minute1 - minute2 + 60) : (minute1 - minute2); 
        if (minute1 < minute2) {
            hour1 --; 
        }
        
        int diff_hour = (hour1 < hour2) ? (hour1 - hour2 + 24) : (hour1 - hour2); 
        
        return (diff_hour * 60 + diff_min); 
    }
} 
