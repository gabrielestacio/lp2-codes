/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE A NOVA ARVORE DE BUSCA BINARIA PARA A QUESTÃO 2
 */

package trabalho02;

import java.util.LinkedList;

public class BinarySearchTreeN extends BinarySearchTree{
	private int count;
	private Node last = null;
	private Node root = getRoot();
	
	//@Override
	private boolean insert(Node node, int value) {
		if(value > node.value){
			if(node.hasRight())
				return insert(node.right, value);
			else
				node.right = new Node(value);
		}
		else if(value < node.value){
			if(node.hasLeft())
				return insert(node.left, value);
			else
				node.left = new Node(value);
		}
		//Atualização da questão 02: Caso o valor passado seja igual ao do nó, é criada uma cópia do nó na sua sub-árvore da direita.
		else{
			if(node.hasRight())
				return insert(node.right, value);
			else
				node.right = node;
		}
		return true;
	}
	
	@Override
	public boolean remove(int value) {
		runThrough(value);
		
		if(last != null){
			remove(last, value);
		}
		else{
			root = remove(root, value);
		}
		return true;
	}

	//@Override
	private Node remove(Node node, int value) {
		if (node == null) {
			return null;
		} else if (node.value == value) {
			if (node.isLeaf()) {
				return null;
			} else if (node.hasLeft() && !node.hasRight()) {
				return node.left;
			} else if (node.hasRight() && !node.hasLeft()) {
				return node.right;
			} else {
				Node child = node.right;
				if (!child.hasLeft()) {
					child.left = node.left;
					return child;
				} else {
					Node successor = removeSuccessor(child);
					successor.left = node.left;
					successor.right = node.right;
					return successor;
				}
			}
		} else if (value > node.value) {
			node.right = remove(node.right, value);
			return node;
		} else if (value < node.value) {
			node.left = remove(node.left, value);
			return node;
		}
		return node;
	}
	
	public void runThrough(int value){
		runThrough(root, value);
	}
	
	private void runThrough(Node node, int value){
		if(value == node.value){
			last = node;
		}
		
		if(node.hasLeft()){
			runThrough(node.left, value);
			if(node.hasRight())
				runThrough(node.right, value);
		}
		else if(node.hasRight()){
			runThrough(node.right, value);
		}
	}

	//Não vi nada que barre a presença de nós repetidos...
	/*@Override
	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}*/
}
