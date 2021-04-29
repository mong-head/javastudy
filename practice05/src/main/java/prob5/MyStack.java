package prob5;

public class MyStack {
	private int size;
	private int idx;
	private String[] mystack;
	
	public MyStack(int size) {
		this.size = size;
		mystack = new String[size];
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
		mystack[idx] = value;
	}
	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException();
		}
		String tmp = mystack[idx];
		idx--;
		resize(size-1);
		return tmp;
		
	}
	public void resize(int size) {
		String[] tmp = new String[size];
		int min_size = size < this.size ? size : this.size;
		for(int i=0;i<min_size;i++) {
			tmp[i] = mystack[i];
		}
		this.size = size;
		mystack = tmp;
	}
}