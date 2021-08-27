import java.util.Random;

public class Node {

	protected int value;
	
	protected Node dad;
	protected int cost;
	protected double prob;

	public Node left;
	public Node middle_left;
	public Node middle_right;
	public Node right;

	public Node(int value) {
		Random generator = new Random();
		this.value = value;
		this.dad = null;
		this.cost = generator.nextInt(10) + 1;
		this.prob = generator.nextDouble()/100;
	}
	
	public Node(int value, Node dad){
		Random generator = new Random();
		this.value = value;
		this.dad = dad;
		this.cost = generator.nextInt(10) + 1;
		this.prob = generator.nextDouble()/100;
	}

	public boolean isLeaf() {
		return left == null && right == null && middle_left == null && middle_right == null;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}
	
	public boolean hasMiddleLeft(){
		return middle_left != null;
	}
	
	public boolean hasMiddleRight(){
		return middle_right != null;
	}
	
	public int hasNull(){
		if(!hasLeft())
			return 1;
		else if(!hasMiddleLeft())
			return 2;
		else if(!hasMiddleRight())
			return 3;
		else if(!hasRight())
			return 4;
		else
			return 0;
	}

	public void setChilds(Node left, Node right, Node middle_left, Node middle_right) {
		this.left = left;
		this.right = right;
		this.middle_left = middle_left;
		this.middle_right = middle_right;
	}
	
	public String toString() {
		return Integer.toString(value);
	}
}
