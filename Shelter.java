/**
 * 
 */

/**
 * @author tianxiangzhang
 *3.7
 */
import java.util.*;
public class Shelter {
	LinkedList<Cat> cat=new LinkedList<Cat>();
	LinkedList<Dog> dog=new LinkedList<Dog>();
	private int order=0;
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog){
			dog.addLast((Dog)a);
		}
		if(a instanceof Cat){
			cat.addLast((Cat)a);
		}
	}
	public int size() {
		return dog.size() + cat.size();
	}
	public Animal denqueueAny(){
		if(dog.size()==0){
			return denqueueCat();
		}
		else if(cat.size()==0){
			return denqueueDog();
		}
		Dog newdog=dog.peek();
		Cat newcat=cat.peek();
		if(newdog.isOlderThan(newcat)){
			return denqueueDog();
		}else {
			return denqueueCat();
		}
		
	}
public Dog denqueueDog(){
		
		return dog.poll();
}
public Cat denqueueCat(){
	return cat.poll();
}
}

	
 abstract class Animal{
	 public abstract String name(); 
	private int order;
	protected String name;
	public Animal(String n){
		this.name=n;
	}
	public void setOrder(int order){
		this.order=order;
	}
	public int getOrder(){
		return this.order;
	}
	public boolean isOlderThan(Animal a){
		if(this.order<a.order){
			return true;
		}else return false;
	}
	
		
}
 


class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
	public String name() {
		return "Cat: " + name;
	}
}

class Dog extends Animal{
	public Dog(String n){
		super(n);
	}
	public String name() {
		return "Dog: " + name;
	}
}

