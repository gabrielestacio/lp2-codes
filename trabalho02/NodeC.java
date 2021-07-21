package trabalho02;

public class NodeC extends Node{

    public NodeC(int value) {
        super(value);
        
    }

    public Node parent; 
    /* para a herança funcionar nao basta usar o extends, para os metodos serem do mesmo tipo, mesmo sendo filho
    * é preciso usar a tipagem do pai nos atributos necessarios. 
    * Irá trazer o left e right pela herança sendo vistos como Node
    * e para serem usados em comparações e atribuições o parent tambem precisa ser visto como Node
    */
    
    @Override
    public String toString() {
		return Integer.toString(value);
	}
   
    
    
}
