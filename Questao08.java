import java.io.File;

public class Questao08 {
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
