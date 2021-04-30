package prob5;

public class MyStack<T> {
	private int size;
	private int idx;
	private T[] mystack;
	
	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		this.size = size;
		mystack = (T[])new Object[size];
		idx = -1;
	}
	public boolean isEmpty() {
		boolean result = false;
		if(idx == -1) {
			result = true;
		}
		return result;
	}
	public void push(String value) {
		idx++;
		if(idx>=size) {
			resize(size+1);
		}
		mystack[idx] = (T) value;
	}
	public T pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException();
		}
		T tmp = mystack[idx];
		idx--;
		resize(size-1);
		return tmp;
		
	}

	@SuppressWarnings("unchecked")
	public void resize(int size) {
		T[] tmp = (T[])new Object[size];
		int min_size = size < this.size ? size : this.size;
		for(int i=0;i<min_size;i++) {
			tmp[i] = mystack[i];
		}
		this.size = size;
		mystack = tmp;
	}
}