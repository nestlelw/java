/*
 * 3.2  How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element? Push, pop 
 * and min should all operate in O(1) time.
 */
public class Stack2 extends Stack {
	private Stack minStack;
	Stack2(){
		super();
		minStack =  new Stack();
	}
	
	@Override
	public Object pop(){
		if (minStack.peek() == super.peek()){
			minStack.pop();
		}
		return super.pop();
	}
	@Override
	public void push(Object item){
		super.push(item);
		if (minStack.isEmpty()) {			
			minStack.push(item);
		} else if(((Integer)item).intValue() <((Integer) minStack.peek()).intValue()){
			minStack.push(item);
		}
	}
	
	public Object min(){
		if (minStack.isEmpty()){
			return super.peek();
		} else {
			return minStack.peek();
		}
	}
}
