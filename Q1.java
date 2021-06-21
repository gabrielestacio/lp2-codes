public class Q1{
	
	public static double media(String[] seq){
		double mean, sum = 0;
		
		for(int i = 0; i < seq.length; i++){
			sum += Double.parseDouble(seq[i]);
		}
		
		mean = sum/seq.length;
		
		return mean;
	}
	
	public static double dpadrao(String[] seq, double mean){
		double dp, acc = 0, frac;
		
		for(int i = 0; i < seq.length; i++){
			acc += Math.pow((Double.parseDouble(seq[i]) - mean), 2);
		}
	
		frac = 1.0/(seq.length - 1);
		dp = Math.sqrt(frac*acc);
				
		return dp;
	}
	
	public static void main(String[] args){
		double mean, dp;
		String result;
		
		mean = media(args);
		dp = dpadrao(args, mean);
				
		result = String.format("%.4f", mean);
		System.out.println("Média: " + result);
		
		result = String.format("%.4f", dp);
		System.out.println("Desvio padrão: " + result);
	}
}