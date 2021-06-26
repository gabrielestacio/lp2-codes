/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 10

	FUNÇÕES IMPORTADAS E UTILIZADAS:
		Tree.add(int valor): Arquivo Tree.java, ln. 151
		Tree.equals(Object obj): Arquivo Tree.java, ln. 232
*/

package trabalho01.src.questao07;

import trabalho01.Tree;

public class Q7{
	//Método main
	public static void main(String[] args){
		//Cria duas árvores diferentes
		Tree tree = new Tree();
		Tree arvore = new Tree();
		
		if(args.length != 0 && args.length > 1){ //Se alguns valores foram passados por parâmetro para serem adicionados nas árvores...
			//...adiciona metade dos valores passados numa árvore e a outra metade na outra
			for(int i = 0; i < (args.length/2); i++)
				arvore.add(Integer.parseInt(args[i]));				
			for(int i = (args.length/2); i < args.length; i++)
				tree.add(Integer.parseInt(args[i]));
		}
		else if(args.length != 0 && args.length == 1) //Se apenas um valor foi passado por parâmetro para ser adicionado na árvore...)
			//...adiciona esse valor em numa das árvores
			arvore.add(Integer.parseInt(args[0]));				
		
		//Se as árvores forem iguais, imprime TRUE, e, caso contrário, imprime FALSE
		if(tree.equals(arvore))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
	}
}