public class test3 { 
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
    public static void main (String[] args){
        String test = "1111100011110000010111110111100111111110000011000000111110000111011011010010011000110110100010111101000100101100000010001110111100110001011000010111000000111001101011100011000100000100110000110100111100100010110110111001110000001010111111010011101111011001"; 
        System.out.println(binToHexa(test));
    }
}
