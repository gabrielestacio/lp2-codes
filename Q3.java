public class Q3{

	public double media(String[] seq, int tam){
		if(tam == 0){
			return 0;
		}
		else if(tam == seq.length){
			return (Double.parseDouble(seq[tam-1]) + media(seq, tam-1))/seq.length;
		}
		else{
			return Double.parseDouble(seq[tam-1]) + media(seq, tam-1);
		}
	}
	
	public static void main(String[] args){
		double mean;
		Q3 calculo = new Q3();
		
		mean = calculo.media(args, args.length);
		
		System.out.println("Média: " + mean);
	}
}