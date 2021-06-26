/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 1
 */

package trabalho01.src.questao01;

public class Q1{
	//Método que calcula a média
	public static double media(String[] seq){
		double mean, sum = 0; 
		
		for(int i = 0; i < seq.length; i++){ //Laço que calcula a soma da lista de valores passada como argumento
			sum += Double.parseDouble(seq[i]); //Conversão dos elementos da lista de String para double
		}
		
		mean = sum/seq.length; //Cálculo da média: soma da lista dividida pelo quantidade de elementos da lista
		
		return mean; //Retorna a média
	}
	
	//Método que calcula o desvio padrão
	public static double dpadrao(String[] seq, double mean){
		double dp, acc = 0, frac;
		
		for(int i = 0; i < seq.length; i++){ //Laço que calcula o somatório do quadrado da subtração de cada elemento da lista pela média
			acc += Math.pow((Double.parseDouble(seq[i]) - mean), 2); //Conversão dos elementos da lista de String para double e cálculo da soma dos quadrados da subtração de cada elemento pela média
		}
	
		frac = 1.0/(seq.length - 1); //Fração que multiplica o somatório de acordo com a fórmula dada
		dp = Math.sqrt(frac*acc); //Raiz quadrada da multiplicação entre a fração e o valor final do somatório
				
		return dp; //Retorna o desvio padrão
	}
	
	//Método main
	public static void main(String[] args){
		double mean, dp;
		String result;
		
		mean = media(args);
		dp = dpadrao(args, mean);
		
		//Cálculo e impressão da média com quatro casas decimais
		result = String.format("%.4f", mean);
		System.out.println("Média: " + result);
		
		//Cálculo e impressão do desvio padrão com quatro casas decimais
		result = String.format("%.4f", dp);
		System.out.println("Desvio padrão: " + result);
	}
}