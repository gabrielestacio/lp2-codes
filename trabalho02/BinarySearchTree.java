/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE FORNECIDA PELO PROFESSOR QUE DEFINE A ARVORE DE BUSCA BINARIA
 */

package trabalho02;

import java.text.BreakIterator;
import java.util.LinkedList;

public class BinarySearchTree implements Tree {

	private Node root;
	
	protected Node getRoot(){
		return root;
	}
	
	protected void setRoot(Node root) {
		this.root = root;
	}

	public boolean insert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		} else {
			return insert(root, value);
		}
	}

	private boolean insert(Node node, int value) {
		if (value > node.value) {
			if (node.hasRight()) {
				return insert(node.right, value);
			} else {
				node.right = new Node(value); // adicionar o parent
			}
		} else if (value < node.value) {
			if (node.hasLeft()) {
				return insert(node.left, value);
			} else {
				node.left = new Node(value); // adicionar o parent
			}
		} else {
			return false; // contains value
		}
		return true;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		if (node == null) {
			return false;
		} else {
			if (node.value == value) {
				return true;
			} else if (value > node.value) {
				return contains(node.right, value);
			} else if (value < node.value) {
				return contains(node.left, value);
			}
		}
		return false;
	}

	public boolean remove(int value) {
		root = remove(root, value);
		return true;
	}

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

	protected Node removeSuccessor(Node node) {
		if (!node.left.hasLeft()) {
			Node successor = node.left;
			node.left = successor.right;
			return successor;
		} else {
			return removeSuccessor(node.left);
		}
	}

	public int height() {
		return height(root, 0);
	}

	private int height(Node node, int level) {
		if (node == null) { // root
			return level;
		}
		return Math.max(height(node.left, level + 1), height(node.right, level + 1));
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root);
			inOrder(root.right);
		}
	}

	public void posOrder() {
		posOrder(root);
	}

	private void posOrder(Node root) {
		if (root != null) {
			posOrder(root.left);
			posOrder(root.right);
			System.out.print(root);
		}
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				System.out.println(current);
				queue.addLast(current.left);
				queue.addLast(current.right);
			}
		}
	}

	public String toString() {
		return toString(root, "", 0);
	}

	public String toString(Node current, String tabs, int level) {
		if (current == null) {
			return "";
		}
		String str = toString(current.right, tabs + "\t", level + 1);
		str += String.format("%s%s [Level:%d]\n", tabs, current, level + 1);
		str += toString(current.left, tabs + "\t", level + 1);
		return str;
	}

	private boolean equals(Node aNode, Node bNode) {
		if (aNode != null && bNode != null) {
			boolean left = equals(aNode.left, bNode.left);
			boolean right = equals(aNode.right, bNode.right);
			return aNode.value == bNode.value && left && right;
		} else {
			return aNode == null && bNode == null;
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof BinarySearchTree) {
			BinarySearchTree tree = (BinarySearchTree) obj;
			return equals(root, tree.root);
		} else {
			return super.equals(obj);
		}
	}
	
	//Questão 03
	public boolean check(){
		int h = height(root, 0); //Altura da árvore
		return check(root, h, 0);
	}
	
	private boolean check(Node node, int height, int level){
		//Se o nó atende os requisitos de uma árvore estritamente binária...
		if(node.hasLeft() == node.hasRight()){
			//...se esse nó for folha...
			if(node.isLeaf() == true){
				//...se o nível for diferente da altura - 1 (que seria o penúltimo nível) ou a altura - 2 (que seria o último nível)...
				if((level != (height - 1)) && (level != (height - 2))){
					return false;
				}
				//...se não...
				else{
					return true;					
				}
			}
			//...se esse nó não for folha;
			else{
				//...passa para a sub-árvore da esquerda e verifica se ela atende os requisitos para ser árvore binária completa...
				if(check(node.left, height, level + 1) == true){
					return check(node.right, height, level + 1); //...passa para a sub-árvore da direita caso a da esquerda atenda os requisitos pra ser árvore binária completa					
				}
				//...se a sub-árvore da esquerda não atender os requisitos para ser binário completa...
				else{
					return false;
				}
			}
		}
		//...se não é estritamente binária, não pode ser binária completa, então...
		else{
			return false;
		}
	}



	@Override
	public void getSucessor(int value) {
		getSucessor(root, value);
	}
	Node nodeParent = null;
	private void getSucessor(Node node, int value) {
		
		if(node.value == value){ // verificao para saber se o node.value é o valor q eu quero achar um sucessor
			if (node.right != null) { // procura na arvore a direita pois é sucessor
				Node child = node.right; // recebe o ramo da direita se nao for nulo	
				while(child.left != null){ // verifica a a arvore esquerda (do ramo da direita) procurando o menor dos maiores
					child = child.left;	
				}
				System.out.println(child);
			}else if(node.right == null){ // retorna o msm caso nao exista
				if(node.value < nodeParent.value){
					System.out.println(nodeParent);
					
				}else{
					System.out.println(node); 
				}
			
			}
		}else{
			nodeParent = node;
			if(node.value < value){ // se o node.valur for menor do que o numero que quero, entao o valor estará a direita
				getSucessor(node.right, value);
			}else if(node.value > value){ // se o node.valur for maior do que o numero que quero, entao o valor estará a esquerda
			getSucessor(node.left, value);
			}
		}
	}

	@Override
	public void getAntecessor(int value) {
		getAntecessor(root, value);
	}

	private void getAntecessor(Node node, int value) {
		if(node.value == value){ // verificao para saber se o node.value é o valor q eu quero achar um antecessor
			if (node.left != null) { // procura na arvore a esquerda pois é antecessor
				Node child = node.left;	// recebe o ramo da esquerda se nao for nulo	
				while(child.right != null){ // verifica a a arvore direita (do ramo da esquerda) procurando o maior dos menores
					child = child.right;	
				}
				System.out.println(child);
			}else if(node.left == null){ // retorna o msm caso nao exista
				System.out.println(node);
			}
		}else{
			if(node.value < value){ // se o node.valur for menor do que o numero que quero, entao o valor estará a direita
				getAntecessor(node.right, value);
			}else if(node.value > value){ // se o node.valur for maior do que o numero que quero, entao o valor estará a esquerda
				getAntecessor(node.left, value);
			}
		}
	}

	@Override
	public boolean search(int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
