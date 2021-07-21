/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE FORNECIDA PELO PROFESSOR QUE DEFINE O TIPO NODE
 */

package trabalho02;

public class Node {

	protected int value;

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
