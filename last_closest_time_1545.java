/* 
1545. Last Closest Time

Given a string representing the time"12:34"(This is a legal input data), return the most recent time within the first 24 hours.If the input is illegal, return -1.
Example

For example:

Given time = "00:00" 
Return "23:59"

Notice

1.The given String represents a time of 24 hours
2.The string contains only numeric characters and ":"
3. The length of string is 5
*/ 

public class Solution {
    /**
     * @param time: 
     * @return: return a string represent time
     */
    public String lastTime(String time) {
        // Write your code here 
        
        /* Validate input */ 
        if (time == null || time.length() != 5) {
            return "-1"; 
        } 
        
        String[] time_str = time.split(":"); 
        int[] times = new int[2]; 
        if (time_str.length != 2 || ! isValid(time_str, times)) {
            return "-1"; 
        } 
        
        /* Find out the last time without duplicate numbers */ 
        int hour = times[0]; 
        int minute = times[1]; 
        
        StringBuilder res = new StringBuilder();
        if (minute == 0) {
            hour = (hour == 0) ? 23 : hour - 1; 
        }
        minute = (minute == 0) ? 59 : minute - 1; 

        res = intToStr(hour, minute);  
        
        return res.toString();         
    } 
    
    private boolean isValid(String[] time_str, int time[]) {
        try{
            time[0] = Integer.parseInt(time_str[0]); 
            time[1] = Integer.parseInt(time_str[1]); 
            
            if (time[0] < 0 || time[0] > 23 || time[1] < 0 || time[1] > 59) {
                return false; 
            } 
            
            return true; 
        } catch (Exception e){
            return false; 
        }
    } 
    
    private StringBuilder intToStr(int hour, int minute) { 
        StringBuilder res = new StringBuilder(); 
        
        if (hour < 10) { 
            res.append("0"); 
        } 
        res.append(hour); 
        res.append(":"); 
    
        if (minute < 10) {
            res.append("0"); 
        } 
        res.append(minute);  
        
        return res; 
    } 
} 
