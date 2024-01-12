import java.nio.file.Files; 
import java.nio.file.Path; 

import java.util.Scanner;
public class fic {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Please enter the file path: ");
        String filePath = scanner.nextLine();  //Accept file path from user
        try{ //check whether file path can be hashed and calculate hash
            String hash = sha_256.SHA(filePath); 
            System.out.println("Hash Result: " + hash);  
            String storedHash = ""; 
            if(storedHash.isEmpty()){
                System.out.println("No stored hash found. Storing calculated hash right now."); 
                storedHash = hash;
            } 
            else{
                if(storedHash.equals(hash)){
                    System.out.println("File integrity is maintained. Matched hashes."); 
                } 
                else{
                    System.out.println("File integrity failed. Hashes do not match.");
                }
            }
        }   
        catch(Exception e){ //Handle exceptions like file not found
            System.err.println("Error: " + e.getMessage());
        }
        finally{
            scanner.close(); //Close scanner

        }
    }
}
