/*2.1
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/

/*
GIVEN: a LinkList lst
EFFECT: a LinkList without duplicates
EXAMPLES:
lst: [1] -> [2] -> [1]
removeDuplicates(lst);
results: lst: [1] -> [2]
*/
public class ps2_1 {
	public static void removeDuplicates(LinkList lst){
		LinkList.Node cmpLeft = lst.head;
		while(cmpLeft!=null){
			LinkList.Node cmpRight = cmpLeft.next;
			LinkList.Node preCmpRight = cmpLeft;
			while(cmpRight!=null){
				if (cmpLeft.data == cmpRight.data){
					preCmpRight = cmpRight.next;
					lst.length--;
				} else {
					preCmpRight = cmpRight;
				}
				cmpRight = cmpRight.next;
			}
			cmpLeft = cmpLeft.next;
		}
	}
	public static void removeDuplicates2(LinkList lst){
		if (lst.head == null) return;
		boolean isExisted[] = new boolean[256];
		for (int i=0; i<256; i++)
			isExisted[i] = false;
		isExisted[lst.head.data] = true;
		
		LinkList.Node p = lst.head.next;
		LinkList.Node pre = lst.head;
		while(p!=null){
			if (isExisted[p.data] == true) {
				pre.next = p.next;
				lst.length--;
			} else {
				isExisted[p.data] = true;
				pre = p;
			} 
			p = p.next;
		}
	}
}


