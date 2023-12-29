
import java.util.Scanner;  
import java.lang.Math;  
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext; 

public class fic{

    public static String charToBinary(char input){
        int ascii = (int)input; // Turn character into an ascii
        String binaryRepresentation = Integer.toBinaryString(ascii); //Sets ascii to binary 
        while(binaryRepresentation.length()<8){ // put it into standard binary by adding 0's to the front of each binary string
            binaryRepresentation = "0"+binaryRepresentation;
        }
        return binaryRepresentation;
    }  
    public static BigDecimal sqrt(BigDecimal number, MathContext mc) { // Newton-Raphson Method to obtain square root to the mc percision
        BigDecimal initialGuess = number.divide(BigDecimal.valueOf(2), mc); // could be any reasonble guess but can affect convergence speed 
        BigDecimal result = initialGuess;
        for (int i = 0; i < 10; i++) { // Adjust the number of iterations for accuracy
            result = (result.add(number.divide(result,mc))).divide(BigDecimal.valueOf(2), mc); //implementation of Newton Equation
        }
        return result;
    }
    public static String intToHexa(BigInteger input){ 
        
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
        int[] prime = {2,3,5,7,11,13,17,19};  //Setting the initial hash value with the first 32 decimal values  
        MathContext sqr = new MathContext(34); //Initializing percision 32(decimal) + 2
        for(int x = 0 ; x< hashVals.length; x++){   
            BigDecimal primeNum = new BigDecimal(prime[x]); //declare each prime as a BigDecimal obj
            BigDecimal primeSqrd = sqrt(primeNum, sqr); //initialize primeSqrd to the output of a squared prime number
            String str = primeSqrd.toString(); 
            str = str.substring(2,str.length()); //retrieve only the 32 decimal point values 
            BigInteger primeInt = new BigInteger(str); //overflow must be put as Big Integer class in order to perform int to hexadecimal
            System.out.println(primeInt);
            str = intToHexa(primeInt); //convert decimal to hexadecimal value

        } 




        // fileInput.close();

    } 
    
}