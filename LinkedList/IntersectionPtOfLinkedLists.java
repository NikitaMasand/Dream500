class Intersect
{
	int intersectPoint(Node headA, Node headB)
	{
        int alength = findLength(headA);
        int blength = findLength(headB);
        Node biggerList = null;
        Node smallerList = null;
        if(alength > blength){
            biggerList = headA;
            smallerList = headB;
        }
        else{
            biggerList = headB;
            smallerList = headA;
        }
        int diff = Math.abs(alength-blength);
        while(diff-- >0){
            biggerList = biggerList.next;
        }
        while(biggerList.next!=null && biggerList.next!=smallerList.next){
            biggerList=biggerList.next;
            smallerList=smallerList.next;
        }
        return biggerList.next==null? -1:biggerList.next.data;
        
	}
	
	int findLength(Node node){
	    if(node==null)
	        return 0;
	   
	   int length = 0;
	   while(node.next!=null){
	       length++;
	       node = node.next;
	   }
	   return length;
	}
	 
}
