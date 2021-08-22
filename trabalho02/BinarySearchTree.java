/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE FORNECIDA PELO PROFESSOR QUE DEFINE A ARVORE DE BUSCA BINARIA.
 */

package trabalho02;


import java.util.LinkedList;

public class BinarySearchTree implements Tree {

	private Node root;
	private Node repeat = null;
	
	protected Node getRoot(){
		return root;
	}
	
	protected void setRoot(Node root) {
		this.root = root;
	}
	
	//ATUALIZAÇÕES PRA QUESTÃO 2
	//********************************

	public boolean insert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		} else {
			return insert(root, value);
		}
	}

	private boolean insert(Node node, int value) {
		//Se o valor passado for maior que o do nó...
		if(value > node.value){
			//...se o nó tem filho à direita...
			if(node.hasRight())
				return insert(node.right, value);
			//...caso contrário...
			else
				node.right = new Node(value); //...cria um novo nó com o valor passado à direita
		}
		//Se o valor passado for menor que o do nó...
		else if(value < node.value){
			//...se o nó tem filho à esquerda...
			if(node.hasLeft())
				return insert(node.left, value);
			//...caso contrário...
			else
				node.left = new Node(value); //...cria um novo nó com o valor passado à esquerda
		}
		//Se o valor passado for igual ao do nó...
		else{
			//...se o nó tem filho à direita...
			if(node.hasRight())
				return insert(node.right, value);
			//...caso contrário...
			else
				node.right = new Node(node.value); //...cria um novo nó "cópia" com o valor passado à direita 
		}
		return true;
	}
	
	public boolean remove(int value){
		root = remove(root, value);
		return true;
	}

	private Node remove(Node node, int value){
		//Se o nó for nulo...
		if(node == null)
			return null;
		//Se o nó tiver o valor passado...
		else if(node.value == value){
			//...se o nó for folha...
			if(node.isLeaf())
				return null; //...ele vai ser excluído
			//...se o nó tem filho à esquerda e não tem à direita...
			else if(node.hasLeft() && !node.hasRight()){
				repeated(node, value);
				//...caso haja outro nó com valor igual nas sub-árvores...
				if(repeat != null)
					replace(node); //...ele irá substituir o nó passado
				//...caso não haja nenhum outro nó com valor igual nas sub-árvores...
				else
					return node.left; //...ele vai ser excluído sendo substituído pelo seu filho da esquerda				
			}
			//...se o nó tem filho à direita e não tem à esquerda...
			else if(node.hasRight() && !node.hasLeft()){
				repeated(node, value);
				//...caso haja outro nó com valor igual nas sub-árvores...
				if(repeat != null)
					replace(node); //...ele irá substituir o nó passado
				//...caso não haja nenhum outro nó com valor igual nas sub-árvores...
				else
					return node.right; //...ele vai ser excluído sendo substituído pelo seu filho da direita
			}
			//...se o nó tem filho à direita e à esquerda...
			else{
				repeated(node, value);
				//...caso haja outro nó com valor igual nas sub-árvores...
				if(repeat != null){
					replace(node); //...ele irá substituir o nó passado
				}
				//...caso não haja nenhum outro nó com valor igual nas sub-árvores...
				else{
					Node child = node.right;
					//...se o filho da direita não tem filho à esquerda...
					if(!child.hasLeft()){
						child.left = node.left; //...o filho à esquerda do pai será passado para a esquerda do filho da direita. Só então, o pai é excluído e o filho da direita assume seu lugar. 
						return child;
					}
					//...se o filho da direita tem filho à esquerda...
					else{
						Node successor = removeSuccessor(child); //...o nó de menor valor da sub-árvore da esquerda assumirá a posição do nó pai
						successor.left = node.left;
						successor.right = node.right;
						return successor;
					}
				}
			}
		}
		//Se o valor passado for maior que o do nó...
		else if(value > node.value){
			node.right = remove(node.right, value); //...a verificação vai ser refeita utilizando o nó da direita
			return node;
		}
		//Se o valor passado for menor que o do nó...
		else if(value < node.value){
			node.left = remove(node.left, value); //...a verificação vai ser refeita utilizando o nó da esquerda
			return node;
		}
		
		return node;
	}

	protected Node removeSuccessor(Node node) {
		if(!node.left.hasLeft()){
			Node successor = node.left;
			node.left = successor.right;
			return successor;
		}
		else{
			return removeSuccessor(node.left);
		}
	}
	
	//Verifica se existe repetição de um valor na árvore
	protected void repeated(Node node, int value){
		//Se encontrar uma repetição...
		if(node.value == value)
			repeat = node; //...repeat recebe esse nó repetido
		
		//Se o nó tem filho à direita...
		if(node.hasRight()){
			//...e não tem à esquerda...
			if(!node.hasLeft()){
				repeated(node.right, value); //...verifica se o nó da direita é a repetição
			}
			//...e tem à esquerda...
			else{
				repeated(node.right, value); //...verifica se o nó da direita é a repetição
				repeated(node.left, value); //...verifica se o nó da esquerda é a repetição
			}
		}
		//Se o nó só tem filho à esquerda...
		else if(node.hasLeft()){
				repeated(node.left, value); //...verifica se o nó da esquerda é a repetição
		}
		
		//Se o nó for folha, ele vai executar a verificação de igualdade e depois terminar a execução da função, já que o nó folha não tem filhos nem à direita nem à esquerda
	}

	//Faz as mudanças necessárias na estrutura para que um nó repetido assuma o lugar do nó original
	protected void replace(Node node){
		//Se o nó repetido for o filho da direita...
		if(repeat == node.right){
			//...se o nó também tem filho à esquerda...
			if(node.hasLeft()){
				//...se o repetido não tem filho à esquerda...
				if(!repeat.hasLeft()){
					//...as sub-árvore da direita do repetido são copiadas para o nó passado
					node.right = repeat.right;
				}
				//...caso contrário...
				else{
					Node temp = run(repeat, node.left.value); //...calcula o primeiro nó descendente do nó repetido que pode receber a sub-árvore esquerda do nó pai
					//Se o primeiro valor da sub-árvore esquerda for menor que o valor do nó disponível para recebê-la...
					if(node.left.value < temp.value)
						temp.left = node.left; //...o nó disponível recebe a sub-árvore esquerda como sua própria sub-árvore esquerda
					//Se o primeiro valor da sub-árvore esquerda for maior que o valor do nó disponível para recebê-la...
					else
						temp.right = node.left; //...o nó disponível recebe a sub-árvore esquerda como sua própria sub-árvore direita
					//As sub-árvores do nó repetido são copiadas para o nó passado
					node.right = repeat.right;
					node.left = repeat.left;
				}
			}
			//...se o nó repetido à direita for filho único...
			else
				//...as sub-árvore da direita e da esquerda do repetido são copiadas para o nó passado
				node.right = repeat.right;
				node.left = repeat.left;
		}
		
		//Como valores repetidos sempre são inseridos na sub-árvore direita, não é necessário verificar se o repetido é o filho da esquerda
		
		//Se o nó repetido não for filho direto...
		else{
			Node temp = split(node.right); //...recebe o último nó antes do nó repetido
			
			Node sub_left = run(repeat, node.left.value); //...calcula o primeiro nó descendente do nó repetido que pode receber a sub-árvore esquerda do nó pai
			
			//...se o primeiro valor da sub-árvore esquerda do nó pai for menor que o valor do nó disponível encontrado por run()...
			if(node.left.value < sub_left.value)
				sub_left.left = node.left; //...o nó disponível recebe a sub-árvore da esquerda do nó passado como sua própria sub-árvore esquerda
			//...caso contrário...
			else
				sub_left.right = node.left; //...o nó disponível recebe a sub-árvore da esquerda do nó passado como sua própria sub-árvore direita
			
			node.left = repeat; //Armazenação temporária do nó repetido e suas sub-árvores na sub-árvore esquerda do nó passado para manipulação da sub-árvore direita do nó passado
			
			sub_left = run(repeat, node.left.value); //Atualização do primeiro nó descendente do nó repetido que pode receber a sub-árvore esquerda do nó pai. Ela é necessária pois este primeiro nó disponível pode ter mudado após a inserção da sub-árvore esquerda do nó pai.
			
			//Exclusão do nó repetido da sub-árvore direita do nó passado
			if(temp.right == repeat)
				temp.right = null;
			else
				temp.left = null;
			
			Node sub_right = run(repeat, node.right.value); //...calcula o primeiro nó descendente do nó repetido que pode receber a sub-árvore direita do nó pai (apenas até o nó imediatamente anterior ao repetido)
			
			//...se o primeiro valor da sub-árvore direita do nó passado é maior que o valor do nó disponível encontrado à direita do repetido por run()...
			if(node.right.value > sub_right.value){
				sub_right.right = node.right; //...a sub-árvore direita do nó passado é incluída à direita do nó disponível na direita
			}
			//...se o primeiro valor da sub-árvore direita do nó passado é menor que o valor do nó disponível encontrado à esquerda do repetido por run()...
			else if(node.right.value < sub_left.value){
				sub_left.left = node.right; //...a sub-árvore direita do nó passado é incluída à esquerda do nó disponível na esquerda
			}
			//...se o primeiro valor da sub-árvore direita do nó passado é menor que o valor do nó disponível encontrado à direita e maior que o valor do nó disponível encontrado à esquerda do repetido por run()...
			else{
				sub_right.left = node.right; //...a sub-árvore direita do nó passado é incluída à esquerda do nó disponível na direita
			}
			
			//...as sub-árvore da direita e da esquerda do repetido são copiadas para o nó passado
			node.right = repeat.right;
			node.left = repeat.left;
		}
	}
	
	//Método que procura o primeiro nó disponível para receber outro nó. Verifica se um nó tem a esquerda vazia, caso o valor passado seja menor, ou a direita vazia, caso o valor passado seja maior.
	protected Node run(Node node, int value){
		if(node.hasRight()){
			if(node.hasLeft()){
				if(value < node.value)
					return run(node.left, value);
				else
					return run(node.right, value);
			}
			else{
				if(value < node.value)
					return node;
				else
					return run(node.right, value);
			}
		}
		else if(node.hasLeft()){
			if(value < node.value)
				return run(node.left, value);
			else
				return node;
		}
		else
			return node;
	}
	
	//Método que "separa" a sub-árvore da direita em duas partes: a parte que vai do nó especificado inicialmente até o pai do nó repetido, e a parte que vai do nó repetido e suas sub-árvores até o final
	protected Node split(Node node){
		if(node.value > repeat.value){
			if(node.left != repeat)
				return split(node.left);
			else
				return node;
		}
		else if(node.value < repeat.value){
			if(node.right != repeat)
				return split(node.right);
			else
				return node;
		}
		return null;
	}
	
	public int size(){
		return size(root);
	}

	private int size(Node node) {
		//Se o nó for nulo...
		if (node == null) {
			return 0; //...ele não entra na conta, pois não está na árvore
		}
		//caso contrário...
		return 1 + size(node.left) + size(node.right); //...retorna o nó atual mais a quantidade de nós à sua esquerda e a sua direita
	}
	
	//******************************
	
	//MÉTODO DA QUESTÃO 3
	//******************************
	
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
	
	//******************************

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


	public int height() {
		return height(root, 0);
	}

	private int height(Node node, int level) {
		if (node == null) { // root
			return level;
		}
		return Math.max(height(node.left, level + 1), height(node.right, level + 1));
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
