/**
 * 
 */

/**
 * @author tianxiangzhang
 *
 */
import java.util.*;
class AscendStack {
	public Stack<Integer> sortStach(Stack<Integer> s){
		Stack<Integer> newstack=new Stack<Integer>();
		while(!s.isEmpty()){
			int temp=s.pop();
			while(!newstack.isEmpty()&&newstack.peek()>temp){
				s.push(newstack.pop());
			}
			newstack.push(temp);
		}
		return newstack;
	}

}
