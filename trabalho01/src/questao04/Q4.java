//Não tenho certeza se tá certa a recursão em cauda

package trabalho01.src.questao04;

public class Q4{
	public static double total = 0;
	
	public double firstSum(String[] seq, int tam, double total){
		if(tam == 0){
			return (1.0/seq.length)*total;
		}
		else{
			total += Math.pow(Double.parseDouble(seq[tam-1]), 2);
			//System.out.println(total);
			return firstSum(seq, tam-1, total);
		}
	}
	
	public double secondSum(String[] seq, int tam, double total){
		if(tam == 0){
			return Math.pow(((1.0/seq.length)*total), 2);
		}
		else{
			total += Double.parseDouble(seq[tam-1]);
			//System.out.println(total);
			return secondSum(seq, tam-1, total);
		}
	}
	
	public static void main(String[] args){
		double total_final;
		Q4 calculo = new Q4();

		total_final = Math.sqrt(calculo.firstSum(args, args.length, 0) - calculo.secondSum(args, args.length, 0));
		System.out.println("Resultado: " + total_final);
	}
}