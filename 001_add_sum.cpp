/* Solution 01: first-time */
#include <iostream> 
#include <vector> 
#include <map> 
#include <iterator> 
#include <unordered_map> 
#include <assert.h>  

using namespace std; 

/* 
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/ 

int main() {

	static const int arr[] = {0, 4, 3, 0}; 
	vector<int> nums (arr, arr + sizeof(arr) / sizeof(arr[0]));  
	int target = 0; 

	/* hashmap O(n) */ 

	/* Read input array into hashmap */ 
	// unordered_map containers are faster than map containers to access individual elements by their key, 
	// although they are generally less efficient for range iteration through a subset of their elements.
	unordered_map<int, int> uo_map; 

	for (int i = nums.size() - 1;i >= 0; i --) 
		uo_map.insert(make_pair(nums[i], i));  

	/* Check each number, if there is another number which can be used to reach target num */ 
	int n, i; 
	unordered_map<int, int> :: iterator it; 
	unordered_map<int, int> :: iterator it_end = uo_map.end(); 

	for (i = 0;i < nums.size();i ++) { 
		cout << i << endl; 
		int n = target - nums[i]; 

		cout << uo_map.count(n) << endl; 

		if (uo_map.count(n) > 0) { 
			it = uo_map.find(n);
			if (it->second != i) break; 
		}
	} 

	assert(i != nums.size()); 

	vector<int> res; 
	res.push_back(i); 
	res.push_back(it->second); 

	cout << res[0] << res[1] << endl; 

	return 0; 
}



/* Solution 02: Second time */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
        
        int overflow = 0;
        ListNode start = new ListNode(-1);
        ListNode pre = start;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + overflow;
            overflow = sum / 10;
            ListNode current = new ListNode(sum % 10);
            pre.next = current;
            pre = current;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int sum = l1.val + overflow;
            overflow = sum / 10;
            ListNode current = new ListNode(sum % 10);
            pre.next = current;
            pre = current;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + overflow;
            overflow = sum / 10;
            ListNode current = new ListNode(sum % 10);
            pre.next = current;
            pre = current;
            l2 = l2.next;
        }
        
        if (overflow == 1) {
            ListNode current = new ListNode(overflow);
            pre.next = current;
        }
        
        return start.next;
    }
}


/* Solution 03: Improved version */ 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
        
        int overflow = 0;
        ListNode start = new ListNode(-1);
        ListNode pre = start;
        while (l1 != null || l2 != null) {
            int l1Value = (l1 != null) ? l1.val : 0;
            int l2Value = (l2 != null) ? l2.val : 0;
            int sum = l1Value + l2Value + overflow;
            overflow = sum / 10;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        
        if (overflow == 1) {
            pre.next = new ListNode(overflow);
        }
        
        return start.next;
    }
}







