package trabalho01.src.questao08;

import java.io.File;

/*
 * rodar e buildar da origem das pastas
 * 1. javac trabalho01\src\questao08\Q8.java   
 * 2. java trabalho01.src.questao08.Q8 "caminho" "nomeArquivo.tipo" 
*/
public class Q8 {
    public static void main(String[] args){
      
        File input = new File(args[0]);
        String search  = args[1];
        explore(input, search);
    }

	public static void explore(File file, String search) {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                explore(f, search);
            }
        }else{
            String name = file.getName();
           
            if(name.equals(search)){
                System.out.println("O nome procurado (" + search + ") e nome encontrado (" + name +") sao iguais");
            } 
        }

    }   
}