package practice_final;

public class Gugudan {
	private int left;
	private int right;
	
	public Gugudan(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public int multiple() {
		return left*right;
	}

	@Override
	public String toString() {
		return "Gugudan [left=" + left + ", right=" + right + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + left * right;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gugudan other = (Gugudan) obj;
		if (left*right != other.left * other.right)
			return false;
		return true;
	}
	
	

}
