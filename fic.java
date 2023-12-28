
import java.util.Scanner;  
import java.lang.Math;  
import java.math.BigDecimal;

public class fic{

    public static String charToBinary(char input){
        int ascii = (int)input; // Turn character into an ascii
        String binaryRepresentation = Integer.toBinaryString(ascii); //Sets ascii to binary 
        while(binaryRepresentation.length()<8){ // put it into standard binary by adding 0's to the front of each binary string
            binaryRepresentation = "0"+binaryRepresentation;
        }
        return binaryRepresentation;
    } 
    public static String binToHexa(String input){ 
        // for(int x = 0 ; x<input.length(); x+=3){
        //     System.out.println(input.substring(x,x+4));
        // }
        return "";
    }
    public static void main(String[] args){
        // Scanner fileInput = new Scanner(System.in);  
        // String test = fileInput.next(); // read in file
        // String binary = ""; 

        // for(int x = 0 ; x<test.length(); x++){  
        //     binary += charToBinary(test.charAt(x));  // for each character in file, get the binary string
        // }   

        // int binLength = binary.length();
        // int padding = (binary.length()/512)*512 + 512; // Find nearest multiple of 512 bits 
        // int bitRows = padding/32;  // get the amount of rows the binary string can be organized  
        // binary += "1";  // appending bit "1" to the end 

        // String binOfbinLength = Integer.toBinaryString(binLength); // Get the binary of original bit length of file
        // System.out.println(binOfbinLength);  

        // while(binary.length()< (padding- binOfbinLength.length())){
        //     binary+="0"; // append 0's until it is the multiple of 512 bits minus the binary string of the original length away 
        // }   
        // binary+=binOfbinLength; // append binary string in order to fufill 512 multiple  

        // System.out.println(binary);  
        // System.out.println(binLength);

        // System.out.println(binary.length());   
        // String[] rows = new String[16];  //2:39 for N=1 blocks, there are only 16, 32 bit words
        // for(int x = 0 ; x < bitRows ; x++){
        //     rows[x] = binary.substring(x*32,x*32+32);  //plug binary into block
        //     System.out.println(rows[x]);
        // } 
        String[] hashVals = new String[8];  
        int[] prime = {2,3,5,7,11,13,17,19};  //Setting the initial hash value with the first 32 decimal bits 
        for(int x = 0 ; x< hashVals.length; x++){   
            // double primeSqrd=  Math.sqrt(prime[x])- (int)Math.sqrt(prime[x]) ;  
            // String bruh = (String.format("%.28f", primeSqrd)).substring(2, 26);  
            // Long test = Long.parseLong(bruh);  
            // String primeBin = (Long.toBinaryString(test)).substring(32); //cut to 32 bit binary string   
            BigDecimal test = new BigDecimal("123");
            // double primeSqrd = Math.sqrt(prime[x]);
            

            // System.out.println("SQRT of prime number " + prime[x] + " = " + primeSqrd);  
            // binToHexa(primeBin);
        } 




        // fileInput.close();

    } 
    
}