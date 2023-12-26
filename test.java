
import java.util.Scanner;
public class test { 
    public static void main(String[] args){ 
        Scanner test = new Scanner(System.in); 
        int binLength = test.nextInt();
        int padding = (binLength/512)*512 + 512; 
        System.out.println(padding);
        test.close();
    }

}
