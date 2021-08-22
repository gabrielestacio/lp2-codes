/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE A CLASSE EXPRESSIONTREE, UTILIZADA NA QUESTÃO 6.
 */

package trabalho02;

/*
x * (((y+z) + (y*z)) * (z+y))

	   * 1
    x 2    *3
	   4+     +5
    6+   *7    8z 9y 
   10y 11z  12y 13z
*/

public class ExpressionTree implements Tree {

    public ExpressionNode root;
    int x = 0;
    int y = 0;
    int z = 0;


	public ExpressionTree(){	
	


        ExpressionNode node1 = new NodeInside('*');
        ExpressionNode node2 = new NodeLeaf(x);
        ExpressionNode node3 = new NodeInside('*');
		ExpressionNode node4 = new NodeInside('+');
        ExpressionNode node5 = new NodeInside('+');
        ExpressionNode node8 = new NodeLeaf(y);
        ExpressionNode node9 = new NodeLeaf(z);
        ExpressionNode node6 = new NodeInside('+');
        ExpressionNode node10 = new NodeLeaf(y);
        ExpressionNode node11 = new NodeLeaf(z);
        ExpressionNode node7 = new NodeInside('*');
        ExpressionNode node12 = new NodeLeaf(y);
        ExpressionNode node13 = new NodeLeaf(z);
        
		root = node1;
		
		root.setChilds(node2, node3);
		node3.setChilds(node4, node5);
        node4.setChilds(node6, node7);
        node6.setChilds(node10, node11);
        node7.setChilds(node12, node13);
        node5.setChilds(node8, node9);
	}


    @Override
    public boolean insert(int x) {
        return false;
    }

    @Override
    public boolean remove(int x) {
        return false;
    }

    @Override
    public boolean contains(int x) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public void getSucessor(int y) {
        
    }

    @Override
    public void getAntecessor(int y) {
        
    }

    @Override
    public boolean search(int y) {
        return false;
    }
    
}
