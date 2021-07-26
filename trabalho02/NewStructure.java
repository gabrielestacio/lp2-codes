/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE O TIPO NEWSTRUCTURE, UTILIZADO NA QUESTÃO 5.
 */

package trabalho02;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class NewStructure extends BinarySearchTree{
    private List<Integer> values = new ArrayList<Integer>();
	
	//Construtor
	public NewStructure(int[] values){
		if(values.length != 0){
			Node root = new Node(values[0]);
			this.setRoot(root);
			for(int i = 1; i < values.length; i++){
				insert(values[i]);
			}
		}	
	}
	
	//Método que fará a ordenação dos valores da árvore
	public int[] order(){
		order(getRoot());
		
		//Conversão de ArrayList para um array simples
		Object[] objects = values.toArray(); 
		int[] valores = new int[objects.length];
		
		for(int i = 0; i < objects.length; i++){
			valores[i] = (int)objects[i];
		}
		
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