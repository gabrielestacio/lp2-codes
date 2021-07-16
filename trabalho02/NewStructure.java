/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE O TIPO NEWSTRUCTURE.
 */

package trabalho02;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class NewStructure extends BinarySearchTree{
    private List<int> values = new ArrayList<int>();
	
	//Construtor
	public NewStructure(int[] values){
		if(values[0] != null){
			this.setRoot(values[0]);
			for(int i = 1; i < values.size(); i++){
				this.insert(values[i]);
			}
		}	
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