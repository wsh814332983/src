import java.util.*;
/**
 * @author tianxiangzhang
 *3.5 MyQueu;
 */
public class MyQueue<T> {
	private Stack<T> newIn,oldCome;
    public MyQueue(){
    	newIn=new Stack<T>();
    	oldCome=new Stack<T>();
    }
    public int size(){
    	return newIn.size()+oldCome.size();
    }
    public void add(T value){
    	newIn.push(value);
    }
    private void shiftStack(Stack<T> newstack,Stack<T> old){
    	if(old.isEmpty()){
    		while(!newstack.isEmpty()){
    			old.push(newstack.pop());
    		}
    	}
    	
    		
    	}
    public T peek(){
    	shiftStack(newIn, oldCome);
    	return oldCome.peek();
    }
    public T remove(){
    	 shiftStack(newIn,oldCome);
    	 return oldCome.pop();
    }
}
