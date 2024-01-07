
import java.util.Scanner;  
import java.lang.Math;  
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;  
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.HashMap;
 
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
    public static String addMod2(String bin1, String bin2, String bin3){ // Function to add rotated and shifted binary string 
        String bin = "";
        for(int x = 0 ; x<32 ; x++){ // traversal by formula
            if(((int)bin1.charAt(x) + (int)bin2.charAt(x) + (int)bin3.charAt(x))%2==1){ //if bit digits at n sum mod 2 is 1, 1 is appended
                bin+="1"; 
                continue;
            } 
            bin+="0"; //otherwise append 0
        }
        return bin;
    } 
    public static String addMod2to32(String bin1, String bin2, String bin3, String bin4){//Final function  
        String bin = "";
        for(int x = 0 ; x<32 ; x++){ // traversal by formula
            if(((int)bin1.charAt(x) + (int)bin2.charAt(x) + (int)bin3.charAt(x) + (int)bin4.charAt(x))%2==1){ //if bit digits at n sum mod 2 is 1, 1 is appended
                bin+="1"; 
                continue;
            } 
            bin+="0"; //otherwise append 0
        }
        return bin;
    }
    public static String sigma0(String bin){ //Here we are initializing sigma 0, right rotation 17 bits, then 19 bits, then shift 10 
        String bin1 = bin.substring(bin.length()-17) + bin.substring(0,bin.length()-17);  // right rotation of 17 done by appending the first 0 to the 17th to last binary string to the 17th to last binary string 
        String bin2 = bin.substring(bin.length()-19) + bin.substring(0,bin.length()-19); 
        String bin3 = bin.substring(bin.length()-10) + bin.substring(0,bin.length()-10);  
        bin3 = "0000000000" + bin3.substring(10); //right shift of 10 bits done by regular 10 bit rotation and then appending the 10th to last binary string to three 0s 
        return addMod2(bin1,bin2,bin3);
    } 
    public static String sigma1(String bin){ //Here we are initializing sigma 1, right rotation 7 bits, then 18 bits, then shift 3 
        String bin1 = bin.substring(bin.length()-7) + bin.substring(0,bin.length()-7);  // right rotation of 7 done by appending the first 0 to the seventh to last binary string to the seventh to last binary string
        String bin2 = bin.substring(bin.length()-18) + bin.substring(0,bin.length()-18); 
        String bin3 = bin.substring(bin.length()-3) + bin.substring(0,bin.length()-3); 
        bin3 = "000" + bin3.substring(3); //right shift of 3 bits done by regular 3 bit rotation and then appending the third to last binary string to three 0s 
        return addMod2(bin1,bin2,bin3);
    }  

    public static void main(String[] args){
        Scanner fileInput = new Scanner(System.in);  
        String test = fileInput.next(); // read in file
        String binary = ""; 

        for(int x = 0 ; x<test.length(); x++){  
            binary += charToBinary(test.charAt(x));  // for each character in file, get the binary string
        }   

        int binLength = binary.length();
        int padding = (binary.length()/512)*512 + 512; // Find nearest multiple of 512 bits  
        int block = padding/512; //Finding the amount of blocks
        int bitRows = padding/32;  // get the amount of rows the binary string can be organized  
        binary += "1";  // appending bit "1" to the end 
        String binOfbinLength = Integer.toBinaryString(binLength); // Get the binary of original bit length of file
        while(binary.length()< (padding- binOfbinLength.length())){
            binary+="0"; // append 0's until it is the multiple of 512 bits minus the binary string of the original length away 
        }   
        binary+=binOfbinLength; // append binary string in order to fufill 512 multiple    
        int row = block*16;
        String[] rows = new String[row];  //2:39 for N=1 blocks, there are only 16, 32 bit words
        for(int x = 0 ; x < bitRows ; x++){
            rows[x] = binary.substring(x*32,x*32+32);  //plug binary into block
        } 
        HashMap<Character,String> hashVals = new HashMap<>();  //Setting the initial hash value 
        ArrayList<Integer> primes1 = sieve_of_eratosthenes(8);  //Here we are using the Sieve of Eratosthenes algo to find first 8 prime numbers
        MathContext sqr = new MathContext(34); //Initializing percision 32(decimal) + 2 
        char ptr = 'a';
        for(int x = 0 ; x< 8; x++){  
            BigDecimal primeNum = new BigDecimal(primes1.get(x)); //declare each prime as a BigDecimal obj
            BigDecimal primeSqrd = sqrt(primeNum, sqr); //initialize primeSqrd to the output of a squared prime number
            primeSqrd = primeSqrd.subtract(BigDecimal.valueOf(primeSqrd.intValue()));  //taking only decimal portion of prime squared 
            hashVals.put((Character)ptr++, decToHexa(primeSqrd));  
        }   
        //onto constants, first 32 bits of the fractional parts of the cube roots of the first sixty-four prime numbers 
        String prime64[] = new String[]{ //64 different keys
            "428a2f98", "71374491", "b5c0fbcf", "e9b5dba5", "3956c25b", "59f111f1", "923f82a4", "ab1c5ed5",
            "d807aa98", "12835b01", "243185be", "550c7dc3", "72be5d74", "80deb1fe", "9bdc06a7", "c19bf174",
            "e49b69c1", "efbe4786", "0fc19dc6", "240ca1cc", "2de92c6f", "4a7484aa", "5cb0a9dc", "76f988da",
            "983e5152", "a831c66d", "b00327c8", "bf597fc7", "c6e00bf3", "d5a79147", "06ca6351", "14292967",
            "27b70a85", "2e1b2138", "4d2c6dfc", "53380d13", "650a7354", "766a0abb", "81c2c92e", "92722c85",
            "a2bfe8a1", "a81a664b", "c24b8b70", "c76c51a3", "d192e819", "d6990624", "f40e3585", "106aa070",
            "19a4c116", "1e376c08", "2748774c", "34b0bcb5", "391c0cb3", "4ed8aa4a", "5b9cca4f", "682e6ff3", 
            "748f82ee", "78a5636f", "84c87814", "8cc70208", "90befffa", "a4506ceb", "bef9a3f7", "c67178f2"};  
        //Preparing message schedule 
        String[] message = Arrays.copyOf(rows, block*64);  
        for(int x = 16 ;x< message.length; x++){
            message[x] = addMod2to32(sigma0(message[x-2]), message[x-7], sigma1(message[x-15]), message[x-16]);        
        }    
        for(int x = 0; x<message.length; x++){
            System.out.println("Message at index " +x + " : " + message[x]);
        }
        //Message formula 
     
        fileInput.close();

    }  
}
    