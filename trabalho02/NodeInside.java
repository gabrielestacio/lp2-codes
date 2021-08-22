/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE O TIPO NODEINSIDE, UTILIZADO NA QUESTÃO 6.
 */

package trabalho02;

public class NodeInside implements ExpressionNode{
    char op;
    ExpressionNode right;
    ExpressionNode left;
    
    public NodeInside(char value) {
		this.op = value;
	}

    @Override
    public void setChilds(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}

}