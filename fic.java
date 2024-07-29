import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*; 
import java.util.Scanner;
import java.util.List;  
import java.io.PrintWriter;
 /*
  * NOTE!!! 
  1. User provies filename/filepath 
  2. Access specific file 
  3. Read content and hash 
  4. Compare to previously stored hash 
  5. Integrity check
  */
public class fic {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);    
        System.out.println("Please enter the file path (or type 'EXIT' to quit or 'CLEAR' to clear stored hash): ");  
        String filePath = scanner.nextLine();  //Accept file path from user 
        while(!filePath.equals("EXIT")){ 
            if(filePath.equals("CLEAR")){
                new PrintWriter("/Users/toadli/FICP/storedHash.txt").close(); 
                System.out.println("Stored hash is cleared!");
                System.out.println("Please enter the file path (or type 'EXIT' to quit or 'CLEAR' to clear stored hash): ");  
                filePath = scanner.nextLine();    
            } 
            else{
                try{ //check whether file path can be hashed and calculate hash 
                List<String> lines = Files.readAllLines(Paths.get(filePath)); //Utilize list as a way to hold each line
                StringBuilder content = new StringBuilder(); //String builder class to help with holding content
                for(String line : lines){ //For each line within the list, append onto content
                    content.append(line);
                }
                String hash = sha_256.SHA(content.toString());  //hash all of the content
                System.out.println("Hash Result: " + hash);  
                String storedHash = Files.readString(Paths.get("/Users/toadli/FICP/storedHash.txt")); //Read string from external file
                if(storedHash.isEmpty()){ //If empty, update external file
                    System.out.println("No stored hash found. Storing calculated hash right now."); 
                    Files.writeString(Paths.get("/Users/toadli/FICP/storedHash.txt"),hash); //Place hash within empty external file
                } 
                else{
                    if(storedHash.equals(hash)){
                        System.out.println("File integrity is maintained. Matched hashes."); 
                    } 
                    else{//Changes have been made to the code
                        System.out.println("File integrity failed. Hashes do not match.");
                    }
                }
            }   
            
            catch(Exception e){ //Handle exceptions like file not found
                System.err.println("Error: " + e.getMessage());
            }
            finally{  
                System.out.println("Please enter the file path (or type 'EXIT' to quit or 'CLEAR' to clear stored hash): ");  
                filePath = scanner.nextLine();    
            } 
        }
        }  
        scanner.close(); //Close scanner 
    }
}
