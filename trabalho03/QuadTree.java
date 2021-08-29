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
	
	public boolean insert(int cost){
		return insert(root, cost);
	}
	
	private boolean insert(Node node, int cost){
		if(root != null){ //se o nó não for nulo. aplicável principalmente para os casos onde a árvore não está vazia
			answer = node.hasNull(); //verifica se alguma subárvore do nó está vazia
			if((answer != 0) && (answer < 5)){ //caso alguma delas esteja...
				switch(answer){
					case 1: //caso a subárvore da esquerda esteja vazia...
						node.left = new Node(cost, node);
						break;
					case 2: //caso a subárvore da centro esquerda esteja vazia...
						node.middle_left = new Node(cost, node);
						break;
					case 3: //caso a subárvore da centro direita esteja vazia...
						node.middle_right = new Node(cost, node);
						break;
					case 4: //caso a subárvore da direita esteja vazia...
						node.right = new Node(cost, node);
						break;
					default:
						break;
				}
				return true;
			}
			else if(answer == 0){ //caso nenhuma esteja vazia...
				if(node != root){ //caso o nó não seja raiz (não possui irmãos), nem folha (todas as subárvores estão vazias, então automaticamente eu insiro na esquerda, para obedecer a ordem de inserção da esquerda pra direita)
					if(node == node.dad.left){ //se o nó for filho da esquerda
						//verifica se algum dos seus irmãos tem subárvore vazia. se tiver, passa pra ele.
						if(node.dad.middle_left.hasNull() != 0)
							return insert(node.dad.middle_left, cost);
						else if(node.dad.middle_right.hasNull() != 0)
							return insert(node.dad.middle_right, cost);
						else if(node.dad.right.hasNull() != 0)
							return insert(node.dad.right, cost);
						//se não tiver, passa pro próximo nível, começando pela esquerda
						else
							return insert(node.left, cost);
					}
					else if(node == node.dad.middle_left){ //se o nó for filho da centro esquerda
						//verifica se algum dos seus irmãos tem subárvore vazia. se tiver, passa pra ele.
						if(node.dad.left.hasNull() != 0)
							return insert(node.dad.left, cost);
						else if(node.dad.middle_right.hasNull() != 0)
							return insert(node.dad.middle_right, cost);
						else if(node.dad.right.hasNull() != 0)
							return insert(node.dad.right, cost);
						//se não tiver, passa pro próximo nível, começando pela esquerda
						else
							return insert(node.dad.left.left, cost);
					}
					else if(node == node.dad.middle_right){ //se o nó for filho da centro direita
						//verifica se algum dos seus irmãos tem subárvore vazia. se tiver, passa pra ele.
						if(node.dad.left.hasNull() != 0)
							return insert(node.dad.left, cost);
						else if(node.dad.middle_left.hasNull() != 0)
							return insert(node.dad.middle_left, cost);
						else if(node.dad.right.hasNull() != 0)
							return insert(node.dad.right, cost);
						//se não tiver, passa pro próximo nível, começando pela esquerda
						else
							return insert(node.dad.left.left, cost);
					}
					else if(node == node.dad.right){ //se o nó for filho da direita
						//verifica se algum dos seus irmãos tem subárvore vazia. se tiver, passa pra ele.
						if(node.dad.left.hasNull() != 0)
							return insert(node.dad.left, cost);
						else if(node.dad.middle_left.hasNull() != 0)
							return insert(node.dad.middle_left, cost);
						else if(node.dad.middle_right.hasNull() != 0)
							return insert(node.dad.middle_right, cost);
						//se não tiver, passa pro próximo nível, começando pela esquerda
						else
							return insert(node.dad.left.left, cost);
					}
					else{ //caso aconteça alguma anomalia
						return false;
					}
				}
				else //caso o nó seja raiz, ou seja, não tem irmãos
					return insert(node.left, cost); //desce um nível, começando pela esquerda
			}	
		}
		else{ //se a raiz for nula, isto é, a árvore está vazia...
			node = new Node(cost);
			setRoot(node);
			return true;
		}
		
		return false; //caso aconteça alguma anomalia
	}
	
	//Questão b)
	
	public void randomize(){
		Random generator = new Random();
		
		for(int i = 0; i < 1500; i++){
			insert(generator.nextInt(5000));
		}
	}
	
	//Questão c)
	
	public Node way(){
		preOrder(root);
		for(int i = 0; i < costs.size(); i++){
			//System.out.println(costs.get(i) + " - " + objectives.get(i));
		}
		return lessCost();
	}
	
	private void preOrder(Node node){
		if(root != null){	
			if(node != null){
				cost += node.cost;
				if(node.isObjective()){
					costs.add(cost);
					cost = 0;
					objectives.add(node);
				}
				
				preOrder(node.left);
				preOrder(node.middle_left);
				preOrder(node.middle_right);
				preOrder(node.right);
			}
		}
	}
	
	private Node lessCost(){
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
		System.out.print("Trajeto até o primeiro objetivo: ");
		levelRun(root);
		System.out.print("\n");
	}
	
	private void levelRun(Node node){
		System.out.print(node.cost + " ");
		if(!node.isObjective()){
			if(node.dad == null){
				levelRun(node.left);
			}
			else{
				if(node == node.dad.left)
					levelRun(node.dad.middle_left);
				else if(node == node.dad.middle_left)
					levelRun(node.dad.middle_right);
				else if(node == node.dad.middle_right)
					levelRun(node.dad.right);
				else if(node == node.dad.right)
					levelRun(node.dad.left.left);
			}
		}
	}
	
	//Questão e)
	
}	