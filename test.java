public class test { 
    public static String hexaTobin(String hexa){  
        int decimal = Integer.parseInt(hexa,16); //Parse as Hexadecimal
        String bin = Integer.toBinaryString(decimal); // Parse into Binary 
        while(bin.length()<32){
            bin = "0" + bin; //while not 32 bits, append 0's to the front
        }
        return bin;
    } 
    public static void main (String[] args){
        String test ="9b05688c"; 
        test = hexaTobin(test); 
        System.out.println(test);
    }
}   
