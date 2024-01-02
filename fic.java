
import java.util.Scanner;  
import java.lang.Math;  
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;  
import java.util.ArrayList;
 
public class fic{

    public static String charToBinary(char input){
        int ascii = (int)input; // Turn character into an ascii
        String binaryRepresentation = Integer.toBinaryString(ascii); //Sets ascii to binary 
        while(binaryRepresentation.length()<8){ // put it into standard binary by adding 0's to the front of each binary string
            binaryRepresentation = "0"+binaryRepresentation;
        }
        return binaryRepresentation;
    }   
    public static ArrayList<Integer> sieve_of_eratosthenes(int limit){
        ArrayList<Integer> primesChecked = new ArrayList<>();  
        primesChecked.add(2);
        int num = 3; 
    
        while(primesChecked.size()<8){  
            boolean test = true;
             for(int x = 0 ; x<primesChecked.size(); x++){
                if(num%(primesChecked.get(x))==0){ 
                    test = false;
                 } 
             }  
             if(test){
                primesChecked.add(num); 
             } 
             num++;
        } 
        return primesChecked;

    }
    public static BigDecimal sqrt(BigDecimal number, MathContext mc) { // Newton-Raphson Method to obtain square root to the mc percision
        BigDecimal initialGuess = number.divide(BigDecimal.valueOf(2), mc); // could be any reasonble guess but can affect convergence speed 
        BigDecimal result = initialGuess;
        for (int i = 0; i < 10; i++) { // Adjust the number of iterations for accuracy
            result = (result.add(number.divide(result,mc))).divide(BigDecimal.valueOf(2), mc); //implementation of Newton Equation 
        }
        return result;
    }
    public static String decToHexa(BigDecimal input){  
        String binary = "";
        while(binary.length()<32){ //Binary bits appended until 32 bits
            BigDecimal num = input.multiply(BigDecimal.valueOf(2)); //Here by a method to find binary through decimal, we multiply by base
            binary += (num.intValue()); //we only take the remaining whole number and append
            input = (input.multiply(BigDecimal.valueOf(2)).subtract(BigDecimal.valueOf(input.multiply(BigDecimal.valueOf(2)).intValue()))); //Here we set our input equal to that multiplied by two and subtracted by a whole number
        }    
        String result = "";
        for(int x = 0 ; x<32 ; x+=4){
            String number = Integer.toString(Integer.parseInt(binary.substring(x, x+4), 2)); //TEST obtaining only the first four binary bits, If you set radix equal to the same base, you get the original!!! 
            switch(number){
                case "10":
                    number = "a"; 
                    break; 
                case "11":
                    number = "b"; 
                    break; 
                case "12": 
                    number = "c"; 
                    break;  
                case "13": 
                    number = "d";  
                    break;
                case "14": 
                    number = "e"; 
                    break; 
                case "15": 
                    number = "f"; 
                    break;
            }
            result += number; 
        }
        return result;
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
        // int block = padding/512; //Finding the amount of blocks
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
        //int row = block*16;
        // String[] rows = new String[row];  //2:39 for N=1 blocks, there are only 16, 32 bit words
        // for(int x = 0 ; x < bitRows ; x++){
        //     rows[x] = binary.substring(x*32,x*32+32);  //plug binary into block
        //     System.out.println(rows[x]);
        // } 
        // String[] hashVals = new String[8];  //Setting the initial hash value 
        // ArrayList<Integer> primes1 = sieve_of_eratosthenes(8);  //Here we are using the Sieve of Eratosthenes algo to find first 8 prime numbers
        // MathContext sqr = new MathContext(34); //Initializing percision 32(decimal) + 2
        // for(int x = 0 ; x< hashVals.length; x++){  
        //     BigDecimal primeNum = new BigDecimal((primes1.get(x))); //declare each prime as a BigDecimal obj
        //     BigDecimal primeSqrd = sqrt(primeNum, sqr); //initialize primeSqrd to the output of a squared prime number
        //     primeSqrd = primeSqrd.subtract(BigDecimal.valueOf(primeSqrd.intValue()));  //taking only decimal portion of prime squared
        //     hashVals[x] = decToHexa(primeSqrd);   
        //     System.out.println(hashVals[x]);


        // }  
        //onto constants, first 32 bits of the fractional parts of the cube roots of the first sixty-four prime numbers 
        //In order to find the first sixty-four prime numbers, we are going to continue using the Sieve of Eratosthenes algorithm 

        




        // fileInput.close();

    // }  
}
    
}