import java.nio.file.Files; 
import java.nio.file.Path; 

import java.util.Scanner;
public class fic {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Please enter the file path: ");
        String filePath = scanner.nextLine();  
        try{
            String hash = sha_256.SHA(filePath); 
            System.out.println("Hash Result: " + hash); 
        }  
        finally{
            scanner.close();

        }
        String hash = sha_256.SHA(filePath); 
        System.out.println("Hash Result :" +  hash); 
    }
}
