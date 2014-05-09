import java.util.*;
class Tower {
	private Stack<Integer> disk;
   private int index;
   public Tower(int i){
	   disk=new Stack<Integer>();
	   index=i;
   }
   public int getIndex(){
	   return index;
   }
   public void add(int v){
	   if(!disk.isEmpty()&&disk.peek()<=v){
		   System.out.print("placing error");
	   }
	   else {disk.push(v);}
   }
   public void moveTop(Tower d){
	   int top=disk.pop();
	   d.add(top);
	   System.out.println("Move disk"+top+"from"+getIndex()+"to"+d.getIndex());
   }
   public void moveTo(int n,Tower destination,Tower helper){
	   if(n>0){
		 moveTo(n-1,helper,destination);
		 moveTop(destination);
		 helper.moveTo(n-1,destination,this);
	   }
   }
}
