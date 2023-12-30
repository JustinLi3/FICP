import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext; 
public class test_2 { 
    public static String intToHexa(BigInteger input){  
        String hexa = "";
        while(input.intValue()!=0){  //Here we are running until input is divided by 16 until 0  
            String remainder = (input.mod(BigInteger.valueOf(16))).toString();
            switch(remainder){  //My implementation of a string to hex, where we ignore single digit values
                case "10": 
                    remainder = "A"; 
                    break; 
                case "11":
                    remainder = "B"; 
                    break; 
                case "12": 
                    remainder = "C"; 
                    break; 
                case "13": 
                    remainder = "D"; 
                    break; 
                case "14": 
                    remainder = "E"; 
                    break; 
                case "15":
                    remainder = "F"; 
                    break;                 
            }
            hexa = remainder + hexa; //Remainders are pushed onto the string forwards
            input = input.divide(BigInteger.valueOf(16));  //input number is divded by hexa and repeated in the process  
        } 
        return hexa; 
    } 
    public static void main(String[] args){
        BigInteger test = new BigInteger("238947129384192834123471283479123847981234981234"); 
        String result = intToHexa(test); 
        System.out.println(result); //print out hexa
    }
}
