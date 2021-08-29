public class Q5{
	public static void main(String[] args){
		QuadTree tree = new QuadTree();
		
		tree = qA(tree, args);
		tree = qB(tree);
		qC(tree);
		qD(tree);
	}
	
	public static QuadTree qA(QuadTree tree, String[] args){
		for(int i = 0; i < args.length; i++){
			tree.insert(Integer.parseInt(args[i]));
		}
		
		return tree;
	}
	
	public static QuadTree qB(QuadTree tree){
		tree.randomize();
		
		return tree;
	}
	
	public static void qC(QuadTree tree){
		Node answer = tree.way();
		
		System.out.println("Menor custo: " + answer.cost + "\n");
	}
	
	public static void qD(QuadTree tree){
		tree.levelRun();
	}
}