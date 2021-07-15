/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 05
 */

package trabalho02;

import java.util.LinkedList;

public class Q5 extends BinarySearchTree{
	private List<int> values = new ArrayList<int>(); //Lista de valores da árvore
	
	//Reescrita da função insert pública da classe BinarySearchTree. Só o que mudou é que o valor do nó raiz é armazenado na lista de valores
	@Override
	public boolean insert(int value) {
		//Se a árvore ainda não tem raiz...
		if (root == null) {
			root = new Node(value); //...o nó raiz é criado com o valor passado...
			values.add(value); //...e o seu valor é adicionado à lista de valores da árvore
			return true;
		}
		
		//Se a árvore já tem raiz...
		else{
			return insert(root, value); //...o nó vai ser inserido como nó filho da raiz
		}
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
				//...é verificado se o valor já foi adicionado à lista de valores, i.e., já está presente na árvore
				for(int i = 0; i < values.size(); i++){
					if(values[i] == value){
						return false; //caso já esteja
					}
				}
				node.right = new Node(value); //caso não esteja, o nó com o tal valor é adicionado como filho da direita do nó passado...
				values.add(value); //...e o seu valor é adicionado à lista de valores da árvore
			}	
		}
		
		//Se o valor passado for menor que o valor do nó...
		else if(value < node.value){
			//...se o nó já tiver filho na esquerda...
			if(node.hasLeft())
				return insert(node.left, value); //...a comparação vai ser refeita, agora com o nó da esquerda
			//...se não tiver filho na esquerda...
			else{
				//...é verificado se o valor já foi adicionado à lista de valores, i.e., já está presente na árvore
				for(int j = 0; j < values.size(); j++){
					if(values[j] == value){
						return false; //caso já esteja
					}
				}
				node.left = new Node(value); //caso não esteja, o nó com o tal valor é adicionado como filho da esquerda do nó passado...
				values.add(value); //...e o seu valor é adicionado à lista de valores da árvore
			}
		}
		
		//Se o valor passado for igual ao valor do nó...
		else
			return false; //...valor já existe na árvore
		
		return true;
	}
	
	//Método que fará a ordenação dos valores da árvore
	public int[] bubbleSort(){
		int valores[] = new int[values.size()];
		values.toArray(valores); //Conversão de ArrayList para Array
        return bubbleSort(valores);
    }

	//Método que fará a ordenação dos valores da árvore
    private int[] bubbleSort(int values[]){
        boolean order = true; //Verifica se houve uma ordenação no vetor, i.e., uma troca de posição
        int temp; //Variável auxiliar que vai armazenar o valor que irá mudar de posição
		
		//Enquando trocas forem feitas...
        while(order){
            order = false;
            
			//...percorra o vetor verificando se há a possibilidade de troca (o tamanho precisa ser -1, pois se não haverá um "estouro" do vetor, comparando o último elemento com algo que está fora do vetor)
			for (int i = 0; i < values.length - 1; i++){
				//Se o valor atual for maior que o próximo...
                if (values[i] > values[i + 1]){
                    temp = values[i]; //...temp vai receber o valor que será trocado...
                    values[i] = values[i + 1]; //...o valor menor passa uma posição para "trás"...
                    values[i + 1] = temp; //...o valor maior passa uma posição para "frente"...
                    
					order = true; //...uma troca foi feita
                }
            }
        }
		
		return values; //Retorna os valores num vetor ordenado
    }
}