package trabalho01.src.questao07;

import trabalho01.Tree;

public class Q7{
	//Método main
	public static void main(String[] args){
		//Cria duas árvores diferentes
		Tree tree = new Tree();
		Tree arvore = new Tree();
		
		if(args.length != 0){ //Se algum valor foi passado por parâmetro para ser adicionado nas árvores...
			//...adiciona os valores passados nas árvores
			arvore.add(Integer.parseInt(args[0]));
			tree.add(Integer.parseInt(args[1]));
		}

		//Se as árvores forem iguais, imprime TRUE, e, caso contrário, imprime FALSE
		if(tree.equals(arvore)){
			System.out.println("TRUE");
		}
		else{
			System.out.println("FALSE");
		}
	}
}