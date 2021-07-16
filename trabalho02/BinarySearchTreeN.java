/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE A NOVA ÁRVORE DE BUSCA BINÁRIA PARA A QUESTÃO 2
 */

package trabalho02;

import java.util.LinkedList;

public class BinarySearchTreeN extends BinarySearchTree{
	private int count;
	private Node last;
	
	@Override
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
		found
		root = remove(root, value);
		return true;
	}

	@Override
	private Node remove(Node node, int value) {
		runThrough(value);
		
		if(count > 1){
			Node found = runThrough
		}
		else{
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
	}
	
	public void runThrough(int value){
		int tam = size()
		runThrough(root, value, tam);
	}
	
	private void runThrough(Node node, int value, int tam){
		while(tam > 0){
			if((node.hasLeft()) && (!node.hasRight())){
				if(value == node.value)
					last = node;
				
				node = node.left;
				tam--;
			}
			else if((node.hasLeft()) && (!node.hasRight())){
				
			}
			else if((node.hasLeft()) && (!node.hasRight())){
				
			}
			else{
				
			}
		}
		
		if(tam == 0){
			
		}
		else{
			
			if(value == node.value)
				last = node;
			
			if(node.hasLeft()){
				runThrough(node.left, value, tam - 1);
				if(node.hasRight())
					runThrough(node.right, value, tam - 1);
			}
			else if(root.hasRight())
				runThrough(node.right, value, tam - 1);
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
