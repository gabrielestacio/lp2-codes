/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 9
	
	FUNÇÕES IMPORTADAS E UTILIZADAS:
		TreeN.levelOrder(): Arquivo TreeN.java, ln. 23
*/

package trabalho01.src.questao09;

import trabalho01.TreeN;

public class Q9 {
    public static void main(String[] args) {
        TreeN treen = new TreeN(6);

        treen.levelOrder();
    }
}
