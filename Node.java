//package LP2;

public class Node{
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public boolean isLeaf(){
		return left == null && right == null;
	}
	
	public boolean hasRight(){
		return right != null;
	}
	
	public boolean hasLeft(){
		return left != null;
	}
	
	public void setChilds(Node _left, Node _right){
		this.left = _left;
		this.right = _right;
	}
	
	public String toString(){
		return Integer.toString(value);
	}
}