/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 05
 */
 
package trabalho02.src.questao05;

import trabalho02.NewStructure;

public class Q5{
    public static void main(String[] args){
		int[] values = new int[args.length];
		
		for(int i = 0; i < args.length; i++){
			values[i] = Integer.parseInt(args[i]);
		}
		
		NewStructure example = new NewStructure(values);
		
		values = example.order();
		System.out.println(values);
	}
}