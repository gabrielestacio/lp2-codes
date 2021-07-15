/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 05
 */

package trabalho02;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class Q5 extends BinarySearchTree{
    private List<int> values = new ArrayList<int>();
	
	//Método que percorre a árvore verificando se um valor já foi inserido
	public boolean search(int value){
		search(root, value); 
	}
	
	//Método que percorre a árvore verificando se um valor já foi inserido
	private boolean search(Node node, int value){
		//Se o valor do nó for diferente do valor passado...
		if(node.value != value){
			//...se o nó passado tem filho à esquerda...
			if(node.hasLeft()){
				//...se o nó passado também tem filho à direita...
				if(node.hasRight()){
					//...se o valor não foi encontrado na sub-árvore esquerda do nó...
					if(node.search(node.left, value))
						return search(node.right, value); //...procurar na sub-árvore direita
					//...se o valor foi encontrado na sub-árvore esquerda...
					else
						return false; //...o valor já existe na árvore
				}
				//...se o nó passado só tem filho à esquerda...
				else{ 
					return search(node.left, value); //...procurar só na sub-árvore esquerda
				}
			}
			//...se o nó passado só tem filho à direita...
			else if(node.hasRight()){
				return search(node.right, value); //...procurar na sub-árvore direita
			}
			//...se o nó passado é folha...
			else{
				return true; //...o valor não foi encontrado na árvore
			}
		}
		//Se o valor do nó for igual ao do valor passado...
		else
			return false; //...o valor já existe na árvore
	}
	
	//Reescrita da função insert privada da classe BinarySearchTree.
	@Override
	private boolean insert(Node node, int value){
		//Se o valor passado for maior que o valor do nó...
		if(value > node.value){
			//...se o nó já tiver filho na direita...
			if(node.hasRight())
				return insert(node.right, value); //...a comparação vai ser refeita, agora com o nó da direita
			//...se não tiver filho na direita...
			else{
				//...verifica se já existe um nó com esse valor...
				if(search(node, value)){
					node.right = new Node(value); //caso não exista, o nó com o tal valor é adicionado como filho da direita do nó passado...					
					return true; //o nó foi adicionado
				}
				else
					return false;
			}	
		}		
		//Se o valor passado for menor que o valor do nó...
		else if(value < node.value){
			//...se o nó já tiver filho na esquerda...
			if(node.hasLeft())
				return insert(node.left, value); //...a comparação vai ser refeita, agora com o nó da esquerda
			//...se não tiver filho na esquerda...
			else{
				//...verifica se já existe um nó com esse valor...
				if(search(node, value)){
					node.left = new Node(value); //caso não exista, o nó com o tal valor é adicionado como filho da esquerda do nó passado...
					return true; //o nó foi adicionado
				}
				else
					return false;
			}
		}
		//Se o valor passado for igual ao valor do nó...
		else
			return false; //...valor já existe na árvore
		
		return true;
	}
	
	//Método que fará a ordenação dos valores da árvore
	public int[] order(){
		order(root);
		
		//Conversão de ArrayList para um array simples
		int[] valores = new int[values.size()]; 
		values.toArray(valores);
		
		return valores; //Retorna o array ordenado
    }

	//Método que fará a ordenação dos valores da árvore
    private void order(Node node){
		//Percorre a árvore no trajeto in-order, que adicionará os valores no ArrrayList já ordenados. Esta é uma característica do in-order das árvores binárias de busca 
		if(node != null){
			order(node.left);
			values.add(node.value);
			order(node.right);
		}
    }
}