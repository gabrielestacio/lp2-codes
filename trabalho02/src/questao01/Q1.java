package trabalho02.src.questao01;

import trabalho02.BinaryComplete;

public class Q1 {
    public static void main(String[] args) {
        BinaryComplete teste = new BinaryComplete();

        teste.insert(5);
        teste.insert(8);
        teste.insert(2);
        teste.insert(20);
        teste.insert(1);
        teste.insert(19);
        teste.insert(6);
        teste.insert(21);

        System.out.println(teste);
        teste.remove(8);
        System.out.println(teste);

        teste.search(2);
     
    }
    
}
