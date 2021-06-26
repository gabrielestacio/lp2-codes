/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE O TIPO NODE, QUE SERÁ USADO, PRINCIPALMENTE, NA CLASSE TREE
 */
 
package trabalho01;

public class Node {

	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setChilds(Node left, Node right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return Integer.toString(value);
	}
	
}

