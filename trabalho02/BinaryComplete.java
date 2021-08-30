/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE O TIPO ARVORE BINARIA COMPLETA, UTILIZADO NA QUESTÃO 1.
 */

package trabalho02;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class BinaryComplete extends BinarySearchTree{


    public Node root;

    
    protected void setRoot(NodeC root) {
		this.root = root;
	}

    @Override
    public boolean insert(int value) {
        if (root == null) {
            root = new NodeC(value);
            ((NodeC)root).parent = null;
            return true;
        } else {
            return insert(root, value);
        }
    }

	public void print_levelorder() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(root);
	  
		while(q.size()>0) {
			Node n = q.remove();
		  if(n != null) {
			System.out.println(n.value);
			Node test = n.value + n.left.value > n.value + n.right.value ?  n.right : n.left;
			q.add(test);
			q.add(test.left);
			q.add(test.right);
			q.remove(test);
			
		  }
		}
	  }

    private boolean insert(Node node, int value) {
        LinkedList<Node> list = new LinkedList<Node>(); // criação da lista 
		list.addLast(root); // adicionando a raiz
		while (!list.isEmpty()) { // fazer ate nao ser vazia
			Node current = list.removeFirst(); //remove o primeiro da lista pra ser raiz
			if (!current.hasLeft()){ // verifica se a raiz atual tem esquerda
                current.left = new NodeC(value); // cria um nodeC na arvore
                ((NodeC)current.left).parent = current; // faz um cast pra poder armazenar a raiz atual como pai
               
                return true;	//adicionou
            }
            else{
             
                list.addLast(current.left); // armazena o nó atual na lista para ser pego como raiz
            }
            if (!current.hasRight()){// verifica se a raiz atual tem direita
                current.right = new NodeC(value); // cria um nodeC na arvore
                ((NodeC)current.right).parent = current;// faz um cast pra poder armazenar a raiz atual como pai
               
                return true; // adicionou
            }
            else{
                list.addLast(current.right); // armazena o nó atual na lista para ser pego como raiz
            }
		}
        return false; // nao adicionou
    }


    public boolean remove(int value) {
		return remove(root,  value);
	}

	private boolean remove(Node node, int value) {
		if(node == null) {
			return false;
		} 

		LinkedList<Node> linkedList = new LinkedList<Node>(); //criação da lista ligada 
		LinkedList<Node> allNodes = new LinkedList<Node>(); // criação de uma outra lista ligada pra armazenar todos os nos
		linkedList.add(node); // armazenando as raizes
		Node lastNode = new Node(0); //criação de um nó para pegar o ultimo nó
		while (linkedList.size() > 0) {
			lastNode = linkedList.pop(); 
			allNodes.add(lastNode); //armazenar cada nó e guardar todos
			if(lastNode.hasLeft()){
				linkedList.add(lastNode.left); //guardar o no da esquerda para adicionar no allnodes
			}
			if(lastNode.hasRight()){
				linkedList.add(lastNode.right); //guardar o no da direita para adicionar no allnodes
			}
		
		}
		boolean wasRemoved = false;
		for (Node currentNode : allNodes) {
			if(currentNode.value == value) {
				
				

				//uma copia node.value do ultimo node da lista AllNodes é feita no node.value que queremos remover,
				//assim nao alterando o left, right e o parent
				currentNode.value = allNodes.getLast().value; 
				//((NodeC)currentNode).parent = ((NodeC)temp).parent;

				
				wasRemoved = true;
			}
		}
		if(!wasRemoved){
			return false;
		}
		// atualização do ultimo valor para nulo, para assim ele sair da arvore
		
		for (Node currentNode : allNodes) {
			if(currentNode.hasLeft()){
				if(currentNode.left == lastNode) { // se o node é o que alocamos em um novo canto
					currentNode.left = null; // retiramos ele da arvore e assim o deixando na nova posição
				}
			}
			if(currentNode.hasRight()){
				if(currentNode.right == lastNode) { // se o node é o que alocamos em um novo canto
					currentNode.right = null; // retiramos ele da arvore e assim o deixando na nova posição
				}
			}
		}
		return true;
	}

	public boolean search(int value) {
		return search(root,  value);
	}

	private boolean search(Node node, int value) {
		if(node == null) {
			return false;
		} 

		LinkedList<Node> linkedList = new LinkedList<Node>(); //criação da lista ligada 
		LinkedList<Node> allNodes = new LinkedList<Node>(); // criação de uma outra lista ligada pra armazenar todos os nos
		linkedList.add(node); // armazenando as raizes
		Node lastNode = new Node(0); //criação de um nó para pegar o ultimo nó
		while (linkedList.size() > 0) {
			lastNode = linkedList.pop(); 
			allNodes.add(lastNode); //armazenar cada nó e guardar todos
			if(lastNode.hasLeft()){
				linkedList.add(lastNode.left); //guardar o no da esquerda para adicionar no allnodes
			}
			if(lastNode.hasRight()){
				linkedList.add(lastNode.right); //guardar o no da direita para adicionar no allnodes
			}
		
		}
		boolean wasFound= false;
		for (Node currentNode : allNodes) {
			if(currentNode.value == value) { // verifica se em cada valor do allnodes possui o que eu quero
		
				System.out.println(" O valor foi encontrado: " + currentNode.value + " Pai: " + ((NodeC)currentNode).parent);
			
				wasFound = true;
			}
		}
		if(wasFound == false){
			System.out.println("Valor informado nao encontrado na arvore");
			return false;
		}
		return true;
	}

	@Override
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

}
   
