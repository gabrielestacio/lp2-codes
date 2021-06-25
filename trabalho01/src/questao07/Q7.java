package trabalho01.src.questao07;
import trabalho01.Tree;

public class Q7{
	public static void main(String[] args){
		Tree tree = new Tree();
		Tree arvore = new Tree();
		
		if(args.length != 0){
			arvore.add(Integer.parseInt(args[0]));
			tree.add(Integer.parseInt(args[1]));
		}

		if(tree.equals(arvore)){
			System.out.println("TRUE");
		}
		else{
			System.out.println("FALSE");
		}
	}
}