import java.util.Random;

public class Node implements Element{

	protected int value;
	
	protected Node dad;
	protected int cost;
	protected double prob;
	protected Random generator = new Random();

	public Node left;
	public Node middle_left;
	public Node middle_right;
	public Node right;

	public Node(int value) {
		this.value = value;
		this.dad = null;
		this.cost = cost();
		this.prob = generator.nextDouble();
	}
	
	public Node(int value, Node dad){
		this.value = value;
		this.dad = dad;
		cost();
		this.prob = generator.nextDouble();
	}
	
	@Override
	public int cost(){
		return generator.nextInt(10) + 1;
	}
	
	@Override
	public boolean isObjective(){
		if(this.prob <= 0.01)
			return true;
		else
			return false;
	}
	
	@Override
	public int compareTo(Element obj){
		Node temp = (Node)obj;
		
		return value - temp.value;
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
