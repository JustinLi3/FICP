import java.util.Scanner;
public class fic {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in); 
        String inputFile = scanner.next(); 
        String hash = sha_256.SHA(inputFile); 
        System.out.println("Hash Result :" +  hash); 
        scanner.close();
    }
}
