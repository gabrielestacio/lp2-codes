/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 4
*/

package trabalho01.src.questao04;

public class Q4{
	//Variável que recebe o resultado em cada nova soma do somatório
	public static double total = 0;
	
	//Método que calcula o primeiro somatório da fórmula. Executa do último elemento da lista até o primeiro.
	public double firstSum(String[] seq, int tam, double total){
		if(tam == 0){ //Se a lista já foi toda percorrida...
			return (1.0/seq.length)*total; //...retorna o produto do valor total do somatório com a fração passada na fórmula
		}
		else{ //Se não...
			total += Math.pow(Double.parseDouble(seq[tam-1]), 2); //...faz o quadrado do elemento atual da lista e adiciona o resultado ao total...
			return firstSum(seq, tam-1, total); //...retorna a execução do método para o elemento anterior da lista, passando também o total já calculado até o momento
		}
	}
	
	//Método que calcula o segundo somatório da fórmula. Executa do último elemento da lista até o primeiro.
	public double secondSum(String[] seq, int tam, double total){
		if(tam == 0){ //Se a lista já foi toda percorrida...
			return Math.pow(((1.0/seq.length)*total), 2); //...retorna o quadrado do produto do valor total do somatório com a função passada na fórmula  
		}
		else{ //Se não...
			total += Double.parseDouble(seq[tam-1]); //...adiciona o elemento atual a soma ao resultado total...
			return secondSum(seq, tam-1, total); //...retorna a execução do método para o elemento anterior da lista, passando também o total já caluclado até o momento
		}
	}
	
/*
	A diferença desse tipo de recursão para o das questões anteriores é que a primeira execução não depende da última.
	Como o valor total já calculado é passado como parâmetro, o programa não precisa percorrer a lista executando e
	pausando as execuções para depois retornar com as respostas. Quando a execução do método sobre um elemento acontece,
	ela termina e não volta mais. Assim, quando chega na última execução recursiva, o método já retorna o valor calculado.
*/	

	//Método main
	public static void main(String[] args){
		double total_final;
		Q4 calculo = new Q4();

		//Cálculo da raiz quadrada da subtração do retorno dos dois métodos, o que termina a "modelagem" da fórmula
		total_final = Math.sqrt(calculo.firstSum(args, args.length, 0) - calculo.secondSum(args, args.length, 0));
		
		//Impressão do resultado final
		System.out.println("Resultado: " + total_final);
	}
}