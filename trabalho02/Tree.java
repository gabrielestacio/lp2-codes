/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE FORNECIDA PELO PROFESSOR QUE DEFINE O TIPO ARVORE
 */

package trabalho02;

public interface Tree {

	public boolean insert(int x);
	public boolean remove(int x);
	public boolean contains(int x);
	public int size();
	public int height();
	public void getSucessor(int y);
	public void getAntecessor(int y);
	public boolean search(int y);
}
