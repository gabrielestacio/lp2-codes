public class Q2{

	public static double media(String[] seq, int tam){
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
		
		mean = media(args, args.length);
		
		System.out.println("Média: " + mean);
	}
}