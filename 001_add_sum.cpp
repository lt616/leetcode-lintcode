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









