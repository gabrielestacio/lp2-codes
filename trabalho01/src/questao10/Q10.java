/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 10
	
	FUNÇÕES IMPORTADAS E UTILIZADAS:
		Tree.levelOrderStack(): Arquivo Tree.java, ln. 248
*/

package trabalho01.src.questao10;

import trabalho01.Tree;

public class Q10{
	//Método main
	public static void main(String[] args){
		Tree tree = new Tree(); //Cria uma nova árvore
		
		tree.levelOrderStack(); //Chamada do método de implementação do algoritmo indicado
	}
}

/*
	Complexidade:
		public static void main(String[] args){
			Tree tree = new Tree();			   -> 1
		
			tree.levelOrderStack();			   -> 1
		}

		public void levelOrderStack(){
			Stack<Node> P = new Stack<Node>(); -> 1
			Node R = root;					   -> 1
			while(!P.isEmpty()){			   -> n+1
				while(R != null){			   -> (n+1)*n
					P.add(R.right);			   -> 1*n
					P.add(R);				   -> 1*n
					R = R.left;				   -> 1*n
				}
				Node T = P.pop();			   -> 1*n
				R = T;						   -> 1*n
				Node F = R.right;			   -> 1*n
				if((F != null) && (F == P.peek())){  -> 1*n
					Node temp = P.pop();	   
					P.add(R);				   
					R = temp;				   
				}
				else{						   -> 1*n
					System.out.println(R);	   
					R = null;				   
				}
			}
		}
	
		= 1+1+1+1+(n+1)+(n+1)*n+n+n+n+n+n+n+n+n
		= n²+10n+5
		
		n²+10n+5 < 5n², c = 5 -> O(n²) é verdade;
		n²+10n+5 < n², c = 1 -> Ω(n²) é verdade;
		Portanto, a complexidade é Θ(n²).
	
	Percurso:
		Pós-ordem, pois o percurso é: o nó da direita é adicionado primeiro, depois o nó "de cima",
		i.e., o nó pai do nó da direita, e, por último, o nó da esquerda.
		Após isso, O ciclo se reinicia: o nó a direita da esquerda anterior, após ele, o nó pai, e,
		por fim, o próximo nó a esquerda. E assim, o algoritmo segue esse percurso até que todos os
		nós da árvore estejam na pilha.
*/