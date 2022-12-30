package tool;

public class CheckString {
    public static boolean checkPhoneLength(String numberStr){
        return numberStr.length() == 10 ||
                numberStr.length() == 11;
    }
    
    public static boolean checkAllNumber(String numberStr){
        for(int i = 0; i < numberStr.length(); i++){
            if(numberStr.charAt(i) < '0' || numberStr.charAt(i) > '9')
                return false;
        }
        return true;
    }
}
