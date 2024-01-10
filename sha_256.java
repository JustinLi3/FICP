import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.MathContext;  
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.HashMap;
public class sha_256{
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
     public static String hexaTobin(String hexa){   //Due to inability to directly Parse as a Hexadecimal, we are going to change hexa to decimal into binary manually 
        String bin = "";
        BigInteger dec = BigInteger.valueOf(0);  // By the case of overflow, we must use Big Integer
        int exp = 0;  
        BigInteger num = BigInteger.valueOf(0); 
        BigInteger base = BigInteger.valueOf(16);
        for(int x = hexa.length()-1 ; x>=0; x--){ //Reverse traversal so that for every smallest to biggest digit bit, exp increases
            num = BigInteger.valueOf(Character.getNumericValue(hexa.charAt(x)));
            BigInteger prog = num.multiply(base.pow(exp)); //Here we get the value to be added
            dec = dec.add(prog);  // Corrected line: Assign the result back to 'dec' due to immutability
            exp++; //increment exponent
            hexa = hexa.substring(0,x); //shift upwards 
        } 
        while(dec.compareTo(BigInteger.valueOf(0))!=0){
            bin = (dec.mod(BigInteger.valueOf(2))).toString() + bin; //Decimal to binary through division
            dec = dec.divide(BigInteger.valueOf(2));
        } 
        while(bin.length()<32){
            bin = "0" +bin;
        }
        return bin;
    }  
    public static String Ch(String e, String f, String g){ //The choose function, using bits of e to tell us the inputs for f and g as output 
        String result = ""; 
        for(int x = 0; x< e.length(); x++){
            if(e.charAt(x) == '1'){ 
                result += f.charAt(x); 
                continue;
            } 
            result += g.charAt(x); 
        } 
        return result;
    } 
    public static String Maj(String a, String b, String c){ //Implementation of the Majority function, where the majority of bits is appended  
        String result = ""; 
        for(int x = 0 ; x < a.length(); x++){
            if((Character.getNumericValue(a.charAt(x)) + Character.getNumericValue(b.charAt(x)) + Character.getNumericValue(c.charAt(x)))>=2){
                result += "1";
            } 
            else{
                result += "0";
            } 
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
    public static String sigma(String bin, int firstRot, int secRot, int shift){ //Here we are initializing sigma, with a binary input and the various input digits for each bit rotation and shift 
        String bin1 = bin.substring(bin.length()-firstRot) + bin.substring(0,bin.length()-firstRot);  
        String bin2 = bin.substring(bin.length()-secRot) + bin.substring(0,bin.length()-secRot); 
        String bin3 = bin.substring(bin.length()-shift) + bin.substring(0,bin.length()-shift);  
        bin3 = "0".repeat(shift) + bin3.substring(shift); 
        return addMod2(bin1,bin2,bin3);
    }  
    public static String Csigma(String bin, int firstRot, int secRot, int thrRot){ //Here I initialized the second variation of sigma, which are a series of three bit rotations each with unique input values 
        String bin1 = bin.substring(bin.length()-firstRot) + bin.substring(0,bin.length()-firstRot);  
        String bin2 = bin.substring(bin.length()-secRot) + bin.substring(0,bin.length()-secRot); 
        String bin3 = bin.substring(bin.length()-thrRot) + bin.substring(0,bin.length()-thrRot);   
        String result = addMod2(bin1, bin2, bin3);
        return result;
    } 
    public static String fullAdder(String bin1, String bin2){  
        String result = ""; 
        int ci =0;
        for(int x = 31; x>=0; x--){ // reverse traversal to allow carry input to stack  
            int num = Character.getNumericValue(bin1.charAt(x)) + Character.getNumericValue(bin2.charAt(x)) + ci; //get current value 
            switch(num){ //if value 
                case 3:
                    result = "1" + result;   
                    ci = 1;
                    break; 
                case 2:  
                    result = "0" + result;
                    ci = 1;  
                    break;  
                case 1:  
                    result = "1" + result; 
                    ci = 0;  
                    break; 
                case 0: 
                    result = "0" + result;
                    ci = 0;   
                    break;
            } 
        } 
        return result;
    }  
    public static String binToHexa(String binary){
        StringBuilder hexResult = new StringBuilder(); //StringBuilder efficient for building/manipulating strings 
        for(int x = 0 ; x < binary.length() ; x +=4 ){ //Take chunks of the binary in blocks of four
            String bits = binary.substring(x, x+4); 
            int dec = Integer.parseInt(bits,2);  //Parse into decimal
            String hexDig = Integer.toHexString(dec); //Parse into hexa 
            hexResult.append(hexDig);
        } 
        return hexResult.toString(); //Convert StringBuilder into String
    }
    public static String SHA(String file){
        String binary = "";  
        for(int x = 0 ; x<file.length(); x++){  
            binary += charToBinary(file.charAt(x));  // for each character in file, get the binary string
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
        String k[] = new String[]{ //64 different keys
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
         //Message formula 
        for(int x = 16 ;x< message.length; x++){ 
            message[x] = fullAdder(fullAdder(fullAdder(sigma(message[x-2],17,19,10),message[x-7]), sigma(message[x-15],7,18,3)), message[x-16]);
        }    
        // Calculation of intermediate value within Hash  
        //First, T1 = h sigma1(e) + Ch(e,f,g) + ko + Wo 
        String h = hexaTobin(hashVals.get('h'));  // Retrieve binary representation for the hexadecimal of key h
        String e = hexaTobin(hashVals.get('e'));// Retrieve binary representation for the hexadecimal of key e 
        String f = hexaTobin(hashVals.get('f'));// Retrieve binary representation for the hexadecimal of key f
        String g = hexaTobin(hashVals.get('g'));// Retrieve binary representation for the hexadecimal of key g 
        String a = hexaTobin(hashVals.get('a'));// Retrieve binary representation for the hexadecimal of key a 
        String b = hexaTobin(hashVals.get('b'));// Retrieve binary representation for the hexadecimal of key b 
        String c = hexaTobin(hashVals.get('c'));// Retrieve binary representation for the hexadecimal of key c 
        String d = hexaTobin(hashVals.get('d'));// Retrieve binary representation for the hexadecimal of key d 
        String T1 = ""; 
        String T2 = "";

        for(int x = 0 ; x<64; x++){
        T1 = fullAdder(fullAdder(fullAdder(fullAdder(h, Csigma(e,6,11,25)), Ch(e,f,g)),hexaTobin(k[x])),message[x]); 
        T2 = fullAdder(Csigma(a,2,13,22),Maj(a,b,c)); 
        h = g; 
        g = f; 
        f = e;
        e = fullAdder(d, T1); 
        d = c; 
        c = b; 
        b = a; 
        a = fullAdder(T1,T2);
        }   
        a = fullAdder(a,hexaTobin(hashVals.get('a'))); 
        b = fullAdder(b,hexaTobin(hashVals.get('b'))); 
        c = fullAdder(c,hexaTobin(hashVals.get('c'))); 
        d = fullAdder(d,hexaTobin(hashVals.get('d'))); 
        e = fullAdder(e,hexaTobin(hashVals.get('e'))); 
        f = fullAdder(f,hexaTobin(hashVals.get('f'))); 
        g = fullAdder(g,hexaTobin(hashVals.get('g')));  
        h = fullAdder(h,hexaTobin(hashVals.get('h')));  //remastered hash values  
        String hash = a + b + c + d + e + f + g + h; 
        hash = binToHexa(hash);
        return hash;
    }  
}
    