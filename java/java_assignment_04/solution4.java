import java.util.Map;
public class solution4 {
    private static final Map<Boolean, String> passFail = Map.of(true, "Pass", false, "Fail");
    private static final Map<Integer, String> strengthStr = Map.of(0, "Weak", 1, "Weak", 2, "Medium", 3, "Medium", 4, "Strong");
    
    public static void main(String[] args) {
        passwordStrengthCheck("P@ssw0rd");
    }   
    public static void passwordStrengthCheck(String password){
        if(password == null)
            password = "";
        boolean length = false;
        boolean digit = false;
        boolean upper = false;
        boolean special = false;
        String specialChars = "!@#$%^&*";
        int strength = 0;
        if(password.length() >= 8){
            length = true;
            strength++;
        }
        for(int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(digit == false && c >= '0' && c <= '9'){
                strength++;
                digit = true;
            }
            if(upper == false && c >= 'A' && c <= 'Z'){
                upper = true;
                strength++;
            }
            if(special == false && specialChars.indexOf(c) >= 0){
                strength++;
                special = true;
            }
        }
        System.out.printf("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s", 
        passFail.get(length), passFail.get(digit), passFail.get(upper), passFail.get(special), strengthStr.get(strength));

    } 
}
