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