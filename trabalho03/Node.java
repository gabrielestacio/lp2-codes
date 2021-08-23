
package trabalho02;

public class Node {

	protected int value;

	public Node left;
	public Node middle_left;
	public Node middle_right;
	public Node right;

	public Node(int value) {
		this.value = value;
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
