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