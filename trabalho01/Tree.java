/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;


import java.util.LinkedList;

public class Tree {

	public Node root;
	public String output;
	public int count, sum;

	public Tree(){	
		count = 0;
		sum = 0;

        // matricula: 20201234567

		Node node1 = new Node(2);
		Node node2 = new Node(0);
		Node node3 = new Node(2);
		Node node4 = new Node(0);
		Node node5 = new Node(1);
		Node node6 = new Node(2);
        Node node7 = new Node(3);
		Node node8 = new Node(4);
		Node node9 = new Node(5);
		Node node10 = new Node(6);
        Node node11 = new Node(7);
		
		root = node6;
		
		node6.setChilds(node4, node10);
		node4.setChilds(node2, node5);
        node10.setChilds(node8, node11);
        node2.setChilds(node1, node3);
		node8.setChilds(node7, node9);
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
		LinkedList<Node> queue = new LinkedList<Node>();
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

	public int height(){
		return height(root);
	}
	
	private int height(Node node){
		if(node == null){
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public int size(){
		return size(root);
	}

	private int size(Node node){
		if(node == null){
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}
	public String toString() {
		return printFormated();
	}


	public void add(int valor){
		Node no = new Node(valor);
		if(root == null){
			this.root = no;
		}
		else{
			Node atual = this.root;
			while(true){
				if(no.value < atual.value){
					if(atual.left != null){
						atual = atual.left;
					}
					else{
						atual.left = no;
						break;
					}
				}
				else{
					if(atual.right != null){
						atual = atual.right;
					}
					else{
						atual.right = no;
						break;
					}
				}
			}
		}
	}
	
	//Questão 7
	public void nodeCount(Node atual){
		if(atual != null){
			nodeCount(atual.left);
			count += 1;
			nodeCount(atual.right);
		}
	}
	
	public void treeSum(Node atual){
		if(atual != null){
			treeSum(atual.left);
			sum += atual.value;
			treeSum(atual.right);
		}
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(this == obj){
			return true;
		}
		
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		
		Tree tree = (Tree)obj;
		
		this.nodeCount(root);
		tree.nodeCount(tree.root);
		this.treeSum(root);
		tree.treeSum(tree.root);
		
		return ((this.sum == tree.sum) && (this.count == tree.count) && (this.root.value == tree.root.value));
	}
	
	public String printFormated() {
		return printFormated(root, "", 1);
	}

	/*
	Sequência de escape  Descrição
		\n               Nova linha. Posiciona o cursor de tela no início da próxima linha
		\t               Tabulação horizontal. Move o cursor de tela para a próxima parada de tabulação.
		\r               Posiciona o cursor da tela no início da linha atual - não avança para a próxima linha. Qualquer saída de caracteres gerada depois de algum retorno já gerado é sobrescrito os caracteres anteriores gerados na linha atual.
		\\               Barras invertidas. Utilizada para imprimir um caractere de barra invertida.
		\”               Aspas duplas. Utilizada para imprimir um caractere de aspas duplas. Exemplo, System.out.println(“\”aspas\””); exibe “aspas”*/

	private static String printFormated(Node root, String tab, int level) {
		if (root != null) {

			String nodeRight = printFormated(root.right, tab + "\t", level + 1);
			String nodeAtual = (tab +  " " + Integer.toString(root.value)+  " (Level:" + Integer.toString(level) +  ") \n");
			String nodeLeft = printFormated(root.left, tab + "\t", level + 1);

			return nodeRight + nodeAtual + nodeLeft;
		}
		return "";
	}
	
}