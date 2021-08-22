/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE O TIPO NODELEAF, UTILIZADO NA QUESTÃO 6.
 */

package trabalho02;

public class NodeLeaf implements ExpressionNode{
    int valor;
    String rotulo;

    NodeLeaf(int value){
        this.valor = value;
    }

    @Override
    public void setChilds(ExpressionNode left, ExpressionNode right) {
	
	}

}