/* 
600. Smallest Rectangle Enclosing Black Pixels

An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
Example

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]

and x = 0, y = 2,
Return 6.
*/ 

public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here 
        
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0; 
        } 
        
        int up_bound, bottom_bound; 
        int left_bound, right_bound; 
        
        int start, end; 
        
        /* find up_bound */ 
        start = 0; 
        end = x; 
        up_bound = findRowBound(image, start, end, false); 
        
        /* find bottom_bound */ 
        start = x; 
        end = image.length - 1; 
        bottom_bound = findRowBound(image, start, end, true); 
        
        /* find left_bound */ 
        start = 0; 
        end = y; 
        left_bound = findColumnBound(image, start, end, false); 
        
        /* find right_bound */ 
        start = y; 
        end = image[0].length - 1; 
        right_bound = findColumnBound(image, start, end, true); 
        
        return (bottom_bound - up_bound + 1) * (right_bound - left_bound + 1);  
    } 
    
    private int findRowBound(char[][] image, int start, int end, boolean reverse) { 
        int mid; 
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            
            if (check_black_row(image, mid)) {
                // if has black; 
                if (reverse) {
                    start = mid; 
                } else {
                    end = mid; 
                }
            } else { 
                if (reverse) {
                    end = mid; 
                } else {
                    start = mid; 
                } 
            }
        } 
        
        if (reverse) { 
            if (check_black_row(image, end)) {
                return end; 
            }  
            
            if (check_black_row(image, start)) {
                return start; 
            } 
        } else { 
            if (check_black_row(image, start)) {
                return start; 
            } 
            
            if (check_black_row(image, end)) {
                return end; 
            } 
        } 
        
        return -1;      // Should never happen 
    } 
    
    private int findColumnBound(char[][] image, int start, int end, boolean reverse) {
        int mid; 
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            
            if (check_black_column(image, mid)) {
                if (reverse) {
                    start = mid; 
                } else { 
                    end = mid; 
                } 
            } else {
                if (reverse) {
                    end = mid; 
                } else {
                    start = mid; 
                } 
            } 
        } 
        
        if (reverse) {
            if (check_black_column(image, end)) {
                return end; 
            }

            if (check_black_column(image, start)) {
                return start; 
            } 
        } else { 
            if (check_black_column(image, start)) {
                return start; 
            }             

            if (check_black_column(image, end)) {
                return end; 
            } 
        } 
        
        return -1;      // Should never happen 
    }
    
    private boolean check_black_row(char[][] image, int index) {
        for (int i = 0;i < image[0].length;i ++) {
            if (image[index][i] == '1') {
                return true; 
            } 
        } 
        
        return false; 
    } 
    
    private boolean check_black_column(char[][] image, int index) {
        for (int i = 0;i < image.length;i ++) {
            if (image[i][index] == '1') {
                return true; 
            } 
        } 
        
        return false; 
    }
    
    
} 
