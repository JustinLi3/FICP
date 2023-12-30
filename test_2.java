import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext; 
public class test_2 { 
    public static String intToHexa(BigInteger input){  
        String hexa = "";
        while(input.intValue()!=0){  //Here we are running until input is divided by 16 until 0
            hexa = input.mod(BigInteger.valueOf(16)) +""+ hexa; //Remainders are pushed onto the string forwards
            input = input.divide(BigInteger.valueOf(16));  //input number is divded by hexa and repeated in the process
        } 
        return hexa; 
    } 
    public static void main(String[] args){
        BigInteger test = new BigInteger("47382946"); 
        String result = intToHexa(test); 
        System.out.println(result); //print out hexa
    }
}
