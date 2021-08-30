/*
	TRABALHO 03 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DO TIPO ARVORE QUATERNARIA
 */

package trabalho03;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class QuadTree{
	private Node root;
	private int answer;
	private int cost;
	
	private Comparator<Element> cmp = new CompareByCost();
	private PriorityQueue<Element> heap = new PriorityQueue<>(cmp);
	
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
	
	//Insere os 1500 elementos randômicos
	public void randomize(){
		Random generator = new Random();
		
		for(int i = 0; i < 1500; i++){
			insert(generator.nextInt(5000));
		}
	}
	
	//Questão c)
	
	public Node way(){
		preOrder(root);
		return lessCost();
	}
	
	//Realiza o percurso em pré-ordem
	private void preOrder(Node node){
		if(root != null){ //se a árvore não for vazia	
			if(node != null){ //se o nó não for nulo
				cost += node.cost; //acumulador que acumula o custo até achar um objetivo
				if(node.isObjective()){ //se o nó for objetivo
					costs.add(cost); //adiciona a soma do custo à lista de custos
					cost = 0; //zera o acumulador de custos
					objectives.add(node); //adiciona o nó à lista de objetivos
				}
				
				preOrder(node.left);
				preOrder(node.middle_left);
				preOrder(node.middle_right);
				preOrder(node.right);
			}
		}
	}

	//Determina o objetivo com menor acumulo de custos no trajeto
	private Node lessCost(){
		int cheaper = costs.get(0);
		Node obj = objectives.get(0);
		
		//percorre as listas de objetivos e custos em busca do objetivo de menor custo
		for(int i = 1; i < objectives.size(); i++){
			if(costs.get(i) < cheaper){
				obj = objectives.get(i);
				cheaper = costs.get(i);
			}
		}
		return obj;
	}
	
	//Questão d)
	
	//Realiza o percurso da árvore por níveis até encontrar o primeiro objetivo
	public void levelRun(){
		System.out.print("Trajeto até o primeiro objetivo: ");
		levelRun(root);
		System.out.print("\n");
	}
	
	private void levelRun(Node node){
		System.out.print(node + " ");
		if(!node.isObjective() || node != null){ //se o nó não é vazio e nem é objetivo
			if(node.dad == null){ //se o nó não tem pai, isto é, é raiz
				levelRun(node.left); //desce para o próximo nível pela esquerda
			}
			else{ //se tiver pai
				if(node == node.dad.left) //se for filho da esquerda, passa para o irmão da centro esquerda
					levelRun(node.dad.middle_left);
				else if(node == node.dad.middle_left) //se for filho da centro esquerda, passa para o irmão da centro direita
					levelRun(node.dad.middle_right);
				else if(node == node.dad.middle_right) //se for filho da centro direita, passa para o irmão da direita
					levelRun(node.dad.right);
				else if(node == node.dad.right) //se for filho da direita, desce para o próximo nível pela esquerda
					levelRun(node.dad.left.left);
			}
		}
	}
	
	//Questão e)
	
	//Percurso em ordem
	public void inOrder() {
		inOrder(root);
	}
	
	//Percurso em ordem
	private void inOrder(Node root) {
		if (root != null) {

			preOrder(root.left);
			preOrder(root.middle_left);
			System.out.print(root + " ");
			preOrder(root.middle_right);
			preOrder(root.right);
			inOrder(root.left);
			
		
		}
	}

	public void levelRunByLessCost(){
		System.out.print("Explorando o nó com menor soma de custos parciais: ");
		levelRunByLessCost(root);
		System.out.print("\n");
	}

	private void levelRunByLessCost(Node node){
		System.out.print(node + " ");
		heap.clear();
		
		if((!node.isObjective()) || (node != null)){
			if(node.dad == null)
				levelRunByLessCost(node.left);
			else{
				if (!node.isLeaf()) {
					node.cost = node.dad.cost + node.cost;
					node.left.cost = node.left.dad.cost + node.left.cost;
					node.right.cost = node.right.dad.cost + node.right.cost;
					node.middle_left.cost = node.middle_left.dad.cost + node.middle_left.cost;
					node.middle_right.cost = node.middle_right.dad.cost + node.middle_right.cost;
					heap.add(node);
					heap.add(node.left);
					heap.add(node.right);
					heap.add(node.middle_left);
					heap.add(node.middle_right);
	
					levelRunByLessCost(((Node)heap.peek()).left);
					levelRunByLessCost(((Node)heap.peek()).middle_left);
					levelRunByLessCost(((Node)heap.peek()).middle_right);
					levelRunByLessCost(((Node)heap.peek()).right);
				}
			}
		}
	}	
}	

class CompareByCost implements Comparator<Element> {
	@Override
    public int compare(Element obj, Element obj2){
		Integer a = ((Node)obj).cost; 
		Integer b = ((Node)obj2).cost;

		return a.compareTo(b);
	}
}