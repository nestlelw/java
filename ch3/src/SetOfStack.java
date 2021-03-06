import java.util.Vector;

public class SetOfStack extends Stack{
	private int threshold = 10;
	private Vector<Object[]> arrays;
	
	public SetOfStack() {
		top = -1;
		cap = 10;
		arrays = new Vector<Object[]>();
		arrays.add(new Object[threshold]);
	}
	
	@Override
	public void push(Object item){
		if(isFull()){
			arrays.add(new Object[threshold]);
			cap+=threshold;
		}
		top++;
		int arrayIndex = top/threshold;
		int index = top%threshold;
		arrays.get(arrayIndex)[index] = item;	
	}
	
	@Override
	public Object pop(){
		Object result = peek();
		if(result != null){
			setTopItem(null);
			top--;
		}
		return result;
	}
	
	@Override
	public Object peek(){
		if(isEmpty()) return null;
		return getTopItem();
	}
	
	public boolean isFull(){
		return top%threshold == threshold-1;
	}
	
	private Object getTopItem(){
		int arrayIndex = top/threshold;
		int index = top%threshold;
		return arrays.get(arrayIndex)[index];	 
	}
	
	private void setTopItem(Object item){
		int arrayIndex = top/threshold;
		int index = top%threshold;
		arrays.get(arrayIndex)[index] = item;
	}
	// for tests
	public Object get(int arrayIndex, int index){
		if (arrayIndex>= arrays.size() || index>= threshold) return null;
		return arrays.get(arrayIndex)[index];
	}
}
