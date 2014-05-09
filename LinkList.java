import java.util.*;

class LinkList1 {
	public void nodedelete(LinkedListNode a){
		Hashtable<Integer, Boolean> table=new Hashtable();
		LinkedListNode previous=null;
		  while(a!=null){
			  if(table.containsKey(a.data)){
				  previous.next=a.next;
				  
			  }else{
				  table.put(a.data,true);
				  previous=a;
			  }
			a=a.next;  
		  }
	}

  public void nodedelete3(LinkedListNode head){
	  if(head==null) return;
	  LinkedListNode curr=head;
	  while(curr!=null){
		  LinkedListNode point=new LinkedListNode();
		  point=curr;
		  while(point.next!=null){
			  if(point.next.data==curr.data){
				  point.next=point.next.next;
			  }else{point=point.next;}
		  }
		  curr=curr.next;
	  }
		  
	 
  }
}
class LinkList2{
	public LinkedListNode findkth1(LinkedListNode head,int k){
		
		if(head==null||k<=0) return null;
		LinkedListNode first=head;
		LinkedListNode point=head;
		int count=1;
		while (first!=null){
			first=first.next;
			count++;
		}
		for(int i=1;i<count-k;i++){
			point=point.next;
		}System.out.print(point.data);
		return point;
	}	
}
class LinkList3{
	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}

}
class LinkList4{
	public LinkedListNode rearrge(LinkedListNode head,int x){
		
		LinkedListNode temp=new LinkedListNode();
		temp.data=x;
		LinkedListNode before=new LinkedListNode();
		LinkedListNode after=new LinkedListNode();
		while(head!=null){
			LinkedListNode h=head.next;
		if(head.data<temp.data){
			head.next=before;
			before=head;
			
		}else if(head.data>=temp.data){
			head.next=after;
			after=head;
		}
		head=h;}
		if(before==null){
			return after;
		}
      	LinkedListNode head2=before;
      	while(before.next!=null){
      		before=before.next;
      	}
      	before.next=after;
      	return head2;
      	
	}
}
class LinkList5{
	public LinkedListNode add(LinkedListNode node1,LinkedListNode node2,int currency){
		if(node1==null&&node2==null&&currency==0) {return null;}
		int value=currency;
		System.out.println("a"+value);
		if(node1!=null){
			value+=node1.data;
			
		}
		if(node2!=null){
			value=value+node2.data;
			System.out.println(value);
		}
		LinkedListNode newlist=new LinkedListNode();
		newlist.data=value%10;
		if(node1!=null||node2!=null){
		LinkedListNode temp=add(node1==null ? null : node1.next,
		                          node2!=null ? node2.next :null, 
		                            value>=10? 1:0);
		newlist.setNext(temp);}
		return newlist;
   }
     
	
	
	public LinkedListNode add2(LinkedListNode node1, LinkedListNode node2){
		if(node1==null&&node2==null){return null;}
		int length1=length(node1);
		int length2=length(node2);
		if(length1<length2){
			node1=expend(node1,length2-length1);
		}else if(length1>length2){
			node2=expend(node2,length1-length2);
		}
		patialsum sum=addway(node1,node2);
		if(sum.curr==0){
			return sum.help;
		}else { LinkedListNode res=insertbefore(sum.help,sum.curr);
		
			return res;}
		}
	
	
	
   public static int length(LinkedListNode a){
	   int count=1;
	   while(a!=null){
		   count++;
		   a=a.next;   
	   }
	   return count;
   }
   private static LinkedListNode expend(LinkedListNode node,int i){
	   LinkedListNode a=node;
	   while(i!=0){
		   LinkedListNode temp=new LinkedListNode();
		   temp.data=0;
		   a.prev=temp;
		   temp.next=a;
		  a=temp;
		   i--;
	   }
	   return a;
   }
   public static LinkedListNode insertbefore(LinkedListNode node,int data){
	   LinkedListNode temp=new LinkedListNode(data,null,null);
	   if(node!=null){
	   temp.next=node;
	   node.prev=temp;}
	   return temp;
   }
   public static patialsum  addway(LinkedListNode node1,LinkedListNode node2){
	   if(node1==null&&node2==null){
		   patialsum sum=new patialsum();
		   return sum;
	   }
	   patialsum sum=addway(node1.next,node2.next);
	   int var=sum.curr+node1.data+node2.data;
	   LinkedListNode first=insertbefore(sum.help,var%10);
	   sum.help=first;
	   sum.curr=var/10;
	   return sum;
   }
}
 class patialsum{
	LinkedListNode help=null;
	int curr=0;
} 
 class LinkList6{
	 public static LinkedListNode loopFind(LinkedListNode head){
		 LinkedListNode fast=head;
		 LinkedListNode slow=head;
		 if(fast==null||slow==null){return null;}
		 while(fast!=null&&fast.next!=null){
			 
			 fast=fast.next.next;
			 slow=slow.next;
			 if(fast==slow) break;
			 
		 }
		 if(fast==null||fast.next==null){return null;}
		 slow=head;
		 while(slow!=fast){
			 slow=slow.next;
			 fast=fast.next;
		 }
		 return fast;
	 }
 
 }
 class LinkList7{
	 public static boolean testPlindrome(LinkedListNode head){
		 LinkedListNode fast=head;
		 LinkedListNode slow=head;
		 Stack<Integer> stack=new Stack<Integer>();
		 while(fast!=null&&fast.next!=null){
			 stack.push(slow.data);
			 fast=fast.next.next;
			 slow=slow.next;
		 }
		 if(fast!=null){
			 slow=slow.next;
		 }
		 while (slow.next!=null){
			 
			 int var=stack.pop().intValue();
			 if(var!=slow.data){return false;}
			 else if(var==slow.data) {slow=slow.next;}
		 }
		 return true;
	 }
 }
 