public class test2 { 
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
     public static void main(String[] args){
       System.out.println((fullAdder("01011011111000001100110100011001", "00110101100001110010011100101011")));

     }
} 
