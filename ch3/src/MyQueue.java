/* 
 * 3.5 Implement a MyQueue class which implements a queue using two stacks.
 */
public class MyQueue implements QueueInterface{
	Stack in;
	Stack out;
	
	public MyQueue() {
		in = new Stack();
		out = new Stack();
	}

	public Object dequeue() {
		if (out.isEmpty()){
			while(!in.isEmpty()){
				Object item = in.pop();
				out.push(item);
			}
		}
		return out.pop();
	}

	@Override
	public void enqueue(Object item) {
		in.push(item);		
	}

	@Override
	public boolean isEmpty() {
		return (in.isEmpty() && out.isEmpty());
	}

	@Override
	public Object getFront() {
		if (out.isEmpty()){
			while(!in.isEmpty()){
				Object item = in.pop();
				out.push(item);
			}
		}
		return out.peek();
	}

	@Override
	public void clear() {
		in = null;
		out = null;
	}

}