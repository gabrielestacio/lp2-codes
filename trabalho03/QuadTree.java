import java.util.linkedlist;

public class QuadTree implements Element{
	private Node root;
	private Node temp;
	private int answer;
	
	protected Node getRoot(){
		return root;
	}
	
	protected void setRoot(Node root){
		this.root = root;
	}
	
	//Para a questão a)
	
	//Calcula a altura da árvore
	public int height(){
		return height(root, 0);
	}
	
	private int height(Node node, int level){
		if(node == null){
			return level;
		}
		return Math.max(Math.max(height(node.left, level + 1), height(node.middle_left, level + 1)), Math.max(height(node.right, level + 1), height(node.middle_right, level + 1)));
	}
	
	//Calcula o nível de um nó específico
	public int level(int value){
		return level(root, value, 0);
	}
	
	private int level(Node node, int value, int level){
		if(node.value = value)
			return level;
		return Math.max(Math.max(height(node.left, level + 1), height(node.middle_left, level + 1)), Math.max(height(node.right, level + 1), height(node.middle_right, level + 1)));
	}
	
	public boolean insert(value){
		return insert(root, value)
	}
	
	//precisa tratar os casos onde não tem vaga antes dos dois últimos níveis
	public boolean insert(Node node, int value){
		if(node == null) //se esse for o lugar onde o nó vai ser inserido...
			node = new Node(value); //...insere
			return true;
		else{ //se não for...
			answer = node.hasNull();
			if(answer != 0){ //...se o nó não tem todos os quatro filhos (essa função hasNull tá em Node.java)
				switch(answer){
					case 1: //caso falte o da esquerda...
						if((level(node.value) != height()) && (level(node.value) != height() - 1)){
							return insert(node.left, value);
						}
						else
							return insert(node.middle_left, value);
						break;
					case 2:
						if((level(node.value) != height()) && (level(node.value) != height() - 1)){
							return insert(node.middle_left, value);
						}
						else
							return insert(node.middle_right, value);
						break;
					case 3:
						if((level(node.value) != height()) && (level(node.value) != height() - 1)){
							return insert(node.middle_right, value);
						}
						else
							return insert(node.right, value);
						break;
					case 4:
						if((level(node.value) != height()) && (level(node.value) != height() - 1)){
							return insert(node.right, value);
						}
						else
							return insert(node.left, value);
						break;
					default:
						break;
				}
			}
			else{
				return insert(node.left, value);
			}
		}
	}
	
	private boolean insert(Node node, int value){
		
	}
}