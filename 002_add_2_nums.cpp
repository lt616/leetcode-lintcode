#include <iostream> 
#include <vector> 

using namespace std; 

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
}; 

int main() {
	int array_1[] = {2, 4, 3}; 
	int array_2[] = {5, 6, 4}; 

	ListNode l1_s = ListNode(array_1[0]); 
	ListNode l2_s = ListNode(array_2[0]); 

	ListNode *temp = &l1_s; 
	for (int i = 1;i < sizeof(array_1); i ++) {
		ListNode next = ListNode(array_1[i]); 
		temp->next = &next; 
		temp = temp->next; 
	} 

	temp = &l2_s; 
	for (int i = 1;i < sizeof(array_2); i ++) {
		ListNode next = ListNode(array_2[i]); 
		temp->next = &next; 
		temp = temp->next; 
	} 

	ListNode *l1 = &l1_s; 
	ListNode *l2 = &l2_s; 

	/* O(n) */ 
	ListNode init_s = ListNode(0); 
	ListNode *init = &init_s; 
00
	while (l1 != NULL && l2 != NULL) { 

		n = l1->val + l2->val + u; 

		u = n / 10; 
		n = n % 10; 

		ListNode temp = ListNode(n); 
		cur->next = &temp; 
		cur = cur->next; 

		l1 = l1->next;
		l2 = l2->next; 
	} 

	// if (l1 == NULL && l2 != NULL) { 
	// 	while (l2 != NULL) {
	// 		n = l2->val + u; 
	// 		u = n / 10; 
	// 		n = n % 10; 

	// 		ListNode temp = ListNode(n); 
	// 		cur->next = &temp; 
	// 		cur = cur->next; 

	// 		l2 = l2->next; 
	// 	}

	// } else if (l2 == NULL && l1 != NULL) {
	// 	while (l1 != NULL) { 
	// 		n = l1->val + u; 
	// 		u = n / 10; 
	// 		n = n % 10; 

	// 		ListNode temp = ListNode(n); 
	// 		cur->next = &temp; 
	// 		cur = cur->next; 

	// 		l1 = l1->next; 
	// 	}
	// } 

	if (u == 1) { 
		ListNode temp = ListNode(u); 
		cur->next = &temp; 
		cur = cur->next; 
	}

	cur->next = NULL; 

	while (init != NULL) {
		cout << init->val << endl; 
		init = init->next;
	}

	return 0; 
}
 
