import java.util.*;
import java.math.*;
class Stackandqueen {

}
//problem 1;
class StackDesign{
	int stackSize=100;
	int[] buffer=new int[stackSize*100];
	int point[]={-1,-1,-1};//track top element of stack;
	public void push(int stackNum,int val) throws Exception{
		if(point[stackNum]+1>=stackSize){
			throw new Exception("Out of Space");
		}
		point[stackNum]++;
		buffer[atPosition(stackNum)]=val;
	}
	public int atPosition(int stackNum){
		return stackNum*stackSize+point[stackNum];
	}
	public int pop(int stackNum) throws Exception{
		if(point[stackNum]<0){
			throw new Exception("empty stack");
		}
		int val=buffer[atPosition(stackNum)];
		buffer[atPosition(stackNum)]=0;
		point[stackNum]--;
		return val;
	}
	public int peek(int stackNum) throws Exception{
		if(point[stackNum]==-1){
			throw new Exception("empty stack");
		}
		int val=buffer[atPosition(stackNum)];
		return val;
	}
	public boolean isEmpty(int stackNum){
		return point[stackNum]==-1;
	}
}

//problem 2;
class minStack{
	public int value;
	public int min;
	public minStack(int v,int min){
		value=v;
		this.min=min;
	}
}
 class StackwithMin extends Stack<minStack>{
	 public void push(int value){
		 int newmin=Math.min(value, min());
		 super.push(new minStack(value,newmin));
	 }
	 private int min(){
		 if(this.isEmpty()){
			 return Integer.MAX_VALUE;
		 }else {return peek().min;}
	 }
 }
 
 class SetOfStack{
	 ArrayList<stack> stacks = new ArrayList<stack>();
	public int capacity;

	public SetOfStack(int capacity) { 
		this.capacity = capacity; 
	}

	public stack getLastStack() {
		if (stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}

	public void push(int v) {
		stack last = getLastStack();
		if (last != null && !last.isFull()) { // add to last
			last.push(v);
		} else { // must create new stack
			stack stack = new stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		stack last = getLastStack();
		int v = last.pop();
		if (last.size == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return v;
	}

	public int popAt(int index) {
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop) {
		stack stack = stacks.get(index);
		int removed_item;
		if (removeTop) removed_item = stack.pop();
		else removed_item = stack.removeBottom();
		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}

	public boolean isEmpty() {
		stack last = getLastStack();
		return last == null || last.isEmpty();
	}
}
 
 
 
 
 
 