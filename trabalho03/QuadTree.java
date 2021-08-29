import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class QuadTree{
	private Node root;
	private int answer;
	private int cost;
	private List<Integer> costs = new ArrayList<Integer>();
	private List<Node> objectives = new ArrayList<Node>();
	
	public QuadTree(){
	}
	
	protected Node getRoot(){
		return root;
	}
	
	protected void setRoot(Node root){
		this.root = root;
	}
	
	//Questão a)
	
	/*
	Esses dois métodos são desnecessários até agora
	
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
	}*/
	
	public boolean insert(int value){
		return insert(root, value);
	}
	
	private boolean insert(Node node, int value){
		if(node != null){ //se o nó não for nulo. aplicável principalmente para os casos onde a árvore não está vazia
			answer = node.hasNull(); //verifica se alguma subárvore do nó está vazia
			if((answer != 0) && (answer < 5)){ //caso alguma delas esteja...
				switch(answer){
					case 1: //caso a subárvore da esquerda esteja vazia...
						node.left = new Node(value, node);
						break;
					case 2: //caso a subárvore da centro esquerda esteja vazia...
						node.middle_left = new Node(value, node);
						break;
					case 3: //caso a subárvore da centro direita esteja vazia...
						node.middle_right = new Node(value, node);
						break;
					case 4: //caso a subárvore da direita esteja vazia...
						node.right = new Node(value, node);
						break;
					default:
						break;
				}
				return true;
			}
			else if(answer == 0){ //caso nenhuma esteja vazia...
				if((node != root) && (!node.isLeaf())){ //caso o nó não seja raiz (não possui irmãos), nem folha (todas as subárvores estão vazias, então automaticamente eu insiro na esquerda, para obedecer a ordem de inserção da esquerda pra direita)
					if(node == node.dad.left){ //se o nó for filho da esquerda
						//verifica se algum dos seus irmãos tem subárvore vazia. se tiver, passa pra ele.
						if(node.dad.middle_left.hasNull() != 0)
							return insert(node.dad.middle_left, value);
						else if(node.dad.middle_right.hasNull() != 0)
							return insert(node.dad.middle_right, value);
						else if(node.dad.right.hasNull() != 0)
							return insert(node.dad.right, value);
						//se não tiver, passa pro próximo nível, começando pela esquerda
						else
							return insert(node.left, value);
					}
					else if(node == node.dad.middle_left){ //se o nó for filho da centro esquerda
						//verifica se algum dos seus irmãos tem subárvore vazia. se tiver, passa pra ele.
						if(node.dad.left.hasNull() != 0)
							return insert(node.dad.left, value);
						else if(node.dad.middle_right.hasNull() != 0)
							return insert(node.dad.middle_right, value);
						else if(node.dad.right.hasNull() != 0)
							return insert(node.dad.right, value);
						//se não tiver, passa pro próximo nível, começando pela esquerda
						else
							return insert(node.left, value);
					}
					else if(node == node.dad.middle_right){ //se o nó for filho da centro direita
						//verifica se algum dos seus irmãos tem subárvore vazia. se tiver, passa pra ele.
						if(node.dad.left.hasNull() != 0)
							return insert(node.dad.left, value);
						else if(node.dad.middle_left.hasNull() != 0)
							return insert(node.dad.middle_left, value);
						else if(node.dad.right.hasNull() != 0)
							return insert(node.dad.right, value);
						//se não tiver, passa pro próximo nível, começando pela esquerda
						else
							return insert(node.left, value);
					}
					else if(node == node.dad.right){ //se o nó for filho da direita
						//verifica se algum dos seus irmãos tem subárvore vazia. se tiver, passa pra ele.
						if(node.dad.left.hasNull() != 0)
							return insert(node.dad.left, value);
						else if(node.dad.middle_left.hasNull() != 0)
							return insert(node.dad.middle_left, value);
						else if(node.dad.middle_right.hasNull() != 0)
							return insert(node.dad.middle_right, value);
						//se não tiver, passa pro próximo nível, começando pela esquerda
						else
							return insert(node.left, value);
					}
					else{ //caso aconteça alguma anomalia
						return false;
					}
				}
				else //caso o nó seja raiz e/ou folha
					return insert(node.left, value);
					/*
						no caso de ser raiz e folha simultaneamente, ou ser apenas folha, como suas subarvores estão vazias, passo para a esquerda para que o novo nó seja inserido lá
						no caso de ser apenas raiz, passo para a esquerda para que o nível abaixo seja verificado a partir da esquerda, para obedecer a ordem de inserção
					*/
			}	
		}
		else{ //se o nó for nulo. aplicável principalmente para os casos onde a árvore está vazia
			node = new Node(value);
			return true;
		}
		
		return false; //caso aconteça alguma anomalia
	}
	
	//Questão b)
	
	protected void randomize(){
		Random generator = new Random();
		
		for(int i = 0; i < 1500; i++){
			insert(generator.nextInt());
		}
	}
	
	//Questão c)
	
	public void preOrder(){
		preOrder(root);
	}
	
	private void preOrder(Node node){
		if(node != null){
			cost += node.cost;
			if(node.isObjective()){
				costs.add(cost);
				objectives.add(node);
			}
			else{
				preOrder(node.left);
				preOrder(node.middle_left);
				preOrder(node.middle_right);
				preOrder(node.right);
			}	
		}
	}
	
	protected Node lessCost(){
		int cheaper = costs.get(0);
		Node obj = objectives.get(0);
		
		for(int i = 1; i < objectives.size(); i++){
			if(costs.get(i) < cheaper){
				obj = objectives.get(i);
				cheaper = costs.get(i);
			}
		}
		return obj;
	}
	
	//Questão d)
	
	public void levelRun(){
		levelRun(root);
	}
	
	private void levelRun(Node node){
		System.out.println(node.value);
		if(!node.isObjective()){
			if(node.dad == null)
				levelRun(node.left);
			else{
				if(node == node.dad.left)
					levelRun(node.dad.middle_left);
				else if(node == node.dad.middle_left)
					levelRun(node.dad.middle_right);
				else if(node == node.dad.middle_right)
					levelRun(node.dad.right);
				else if(node == node.dad.right)
					levelRun(node.left);
			}
		}
	}
	
	//Questão e)
	
}