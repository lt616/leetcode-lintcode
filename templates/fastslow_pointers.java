private ListNode detectLinkedListCycle(ListNode start) {
    ListNode fast = start.next, slow = start; 
    
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return null; 
        } 
        
        slow = slow.next; 
        fast = fast.next.next; 
    } 
    
    /* Now fast is cycle_len - 1 more steps than slow */ 
    fast = fast.next; 
    slow = start; 
    while (slow != fast) {
        slow = slow.next; 
        fast = fast.next; 
    } 
    
    return fast; 
} 
