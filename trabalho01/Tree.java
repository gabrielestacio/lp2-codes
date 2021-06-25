/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;


import java.util.LinkedList;
import java.util.Stack;

public class Tree {

	public Node root; //Nó raiz
	public int count, sum; //Count: conta a quantidade de nós da árvore; Sum: somatório do valor de todos os nós da árvore

	//Construtor
	public Tree(){	
		count = 0;
		sum = 0;

        //Questão 5
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

	//Percurso em pré-ordem
	public void preOrder() {
		preOrder(root);
	}

	//Percurso em pré-ordem
	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	//Percurso em ordem
	public void inOrder() {
		inOrder(root);
	}

	//Percurso em ordem
	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root);
			inOrder(root.right);
		}
	}

	//Percurso em pós-ordem
	public void posOrder() {
		posOrder(root);
	}

	//Percurso em pós-ordem
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
	
	//Questão 10
	//Método que implementa o algoritmo indicado
	public void levelOrderStack(){
		Stack<Node> P = new Stack<Node>(); //Cria nova pilha de nós
		Node R = root; //R recebe o nó raiz
		while(!P.isEmpty()){ //Enquanto a pilha não estiver vazia...
			while(R != null){ //...enquanto R existir...
				P.add(R.right); //...adicione o filho da direita de R em P
				P.add(R); //...adicione R em P
				R = R.left; //...atribua a R o seu filho da esquerda
			}
			
			Node T = P.pop(); //...atribua a T o nó cabeça removido de P
			R = T; //...atribua T a R
			Node F = R.right; //...atribua a F o filho da direita de R
			
			if((F != null) && (F == P.peek())){ //...se F existe e é o nó cabeça de P...
				Node temp = P.pop(); //...remova o nó cabeça F de P
				P.add(R); //...adicione R a P
				R = temp; //...atribua o nó F removido a R
			}
			else{ //...se não...
				System.out.println(R); //...imprima R
				R = null; //...atribua a R o valor nulo
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

	//Adiciona um novo nó na árvore
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
	
	//Percorre a árvore em ordem contando a quantidade de nós
	public void nodeCount(Node atual){
		if(atual != null){
			nodeCount(atual.left);
			count += 1;
			nodeCount(atual.right);
		}
	}
	
	//Percorre a árvore em ordem somando os valores dos nós
	public void treeSum(Node atual){
		if(atual != null){
			treeSum(atual.left);
			sum += atual.value;
			treeSum(atual.right);
		}
	}
	
	//Método equals sobrescrito
	@Override
	public boolean equals(Object obj){
		
		if(this == obj){
			return true;
		}
		
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		
		//Casting do objeto para o tipo árvore
		Tree tree = (Tree)obj;
		
		this.nodeCount(root); //Conta os nós do objeto atual
		tree.nodeCount(tree.root); //Conta os nós do objeto tree
		this.treeSum(root); //Soma os valores do objeto atual
		tree.treeSum(tree.root); //Soma os valores do objeto tree
		
		//Retorna se a soma dos valores das árvores e a quantidade de nós são iguais ou não
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
		\"               Aspas duplas. Utilizada para imprimir um caractere de aspas duplas. Exemplo, System.out.println("\"aspas\""); exibe "aspas"
	*/

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