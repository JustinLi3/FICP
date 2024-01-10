import java.math.BigInteger;
public class test { 
    public static String hexaTobin(String hexa){   //Due to inability to directly Parse as a Hexadecimal, we are going to change hexa to decimal into binary manually 
        BigInteger dec = BigInteger.valueOf(0);  // By the case of overflow, we must use Big Integer
        int exp = 0;  
        BigInteger num = BigInteger.valueOf(0); 
        BigInteger base = BigInteger.valueOf(16);
        for(int x = hexa.length()-1 ; x>=0; x--){
            num = BigInteger.valueOf(Character.getNumericValue(hexa.charAt(x)));
            BigInteger prog = num.multiply(base.pow(exp));
            dec = dec.add(prog);  // Corrected line: Assign the result back to 'dec' due to immutability
            exp++;
            hexa = hexa.substring(0,x); 
        }
        return dec.toString();
    } 
    public static void main (String[] args){
        String test ="9b05688c"; 
        test = hexaTobin(test); 
        System.out.println(test);
    }
}   
