/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 3
 */

package trabalho01.src.questao03;

public class Q3{
	//Método não-estático que calcula a média de uma sequência de forma recursiva. Ele começa calculando do último elemento até o primeiro.
	public double media(String[] seq, int tam){
		if(tam == 0){ //Se a lista já foi toda percorrida...
			return 0; //...retorna 0
		}
		else if(tam == seq.length){ //Se estiver na primeira execução, i.e., no último elemento...
			return (Double.parseDouble(seq[tam-1]) + media(seq, tam-1))/seq.length; //...retorna a soma de todos os elementos dividida pela quantidade de elementos.
		}
		else{ //Se não estiver na primeira execução, i.e., qualquer elemento diferente do último...
			return Double.parseDouble(seq[tam-1]) + media(seq, tam-1); //...retorna a soma deste elemento com o elemento anterior
		}
	}

/*
	A divisão ocorre na "primeira execução" porque ela, mesmo sendo a primeira, não termina
	sua execução até que a última execução, i.e., quando o método retornar 0, execute completamente.
	Por exemplo, numa lista [1, 2, 3], com 3 elementos, o método será executado para 3, que é o
	último elemento, mas ao chegar ao return, ele "pausará" e ficará esperando pelo retorno de si
	mesmo quando executado pra 2, que, por sua vez, ficará esperando pelo retorno de si mesmo quando
	executado para 1, que, por sua vez, ficará esperando pelo retorno de si mesmo quando executado para
	o próximo elemento. Porém, como não há próximo elemento, o retorno será 0. Recebendo este 0, 1 pode
	terminar sua soma e retornar para 2, que, terminando sua soma, retorna para 3, que, terminando sua
	soma, calcula a média, já que não há mais nenhum elemento após ele.
*/
	
	//Método main
	public static void main(String[] args){
		double mean;
		Q3 calculo = new Q3();
		
		//Chamada não-estática do método, cálculo da média e impressão do resultado na tela
		mean = calculo.media(args, args.length);
		System.out.println("Média: " + mean);
	}
}