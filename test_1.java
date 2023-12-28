import java.math.BigDecimal;
import java.math.MathContext;

public class test_1 {
    public static void main(String[] args) {
        int primeNumber = 2; //example of prime number
        BigDecimal prime = new BigDecimal(primeNumber); // Convert prime number to BigDecimal
        MathContext mc = new MathContext(34); // Set precision to 32 decimal places
        BigDecimal sqrt = sqrt(prime, mc); // Calculate square root using function made
        System.out.println(sqrt); 
    }
    // Function to calculate square root using Newton-Raphson Equation
    public static BigDecimal sqrt(BigDecimal number, MathContext mc) {
        BigDecimal initialGuess = number.divide(BigDecimal.valueOf(2), mc); // could be any reasonble guess but can affect convergence speed 
        BigDecimal result = initialGuess;

        for (int i = 0; i < 10; i++) { // Adjust the number of iterations for accuracy
            result = (result.add(number.divide(result,mc))).divide(BigDecimal.valueOf(2), mc); //implementation of Newton Equation
        }

        return result;
    }
}