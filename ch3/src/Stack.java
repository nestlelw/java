
/*
 * implement a stack using array
 */

public class Stack implements StackInterface {
	private static final int DEFAULT_SIZE = 10;
	protected int top;
	protected int cap;
	protected Object[] objects;

	Stack(){
		top = -1;
		cap = DEFAULT_SIZE;
		objects = new Object[cap];
	}

	public Object pop(){
		if (isEmpty()) return null;
		Object result = objects[top];
		objects[top] = null;
		top--;
		return result;
	}
	public void push(Object item){
		if (isFull()){
			Object[] newObjects = new Object[cap*2];
			for (int i=0; i<cap; i++){
				newObjects[i] = objects[i];
			}
			objects = newObjects;
			cap *= 2;
		}
		top++;
		objects[top] = item;

	}
	public Object peek(){
		if (isEmpty()) return null;
		return objects[top];
	}
	public boolean isEmpty(){
		return top == -1;
	}
	private boolean isFull(){
		return (top+1) == cap;
	}
	// for tests
	public Object get(int index){
		if (index >= cap) return null;
		return objects[index];
	}
}


//import java.util.Vector;
//
//public class Stack implements StackInterface {
//	Vector objects;
//	int top;
//	
//	Stack(){
//		objects = new Vector(); // Vector Constructs an empty vector so that its internal data array has size 10 
//		top = -1;
//	}
//	
//	public Object pop(){
//		Object result = this.peek();
//		if (result != null) {
//			objects.remove(top);
//			top--;
//		} 
//		return result;
//	}
//	public void push(Object item){
//		this.objects.add(item);
//		this.top++;
//	}
//	public Object peek(){
//		if (this.isEmpty()) return null;
//		return objects.get(top);
//	}
//	public boolean isEmpty(){
//		return top == -1;
//	}
//}
