public class MaskedPhoneNumber {

    static String maskPhoneNumber(String phone) {

 
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check whether all characters are digits
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFour = phone.substring(phone.length() - 4);

    
        StringBuilder result = new StringBuilder("XXXXXX");


        result.insert(result.length(), "-");

        result.append(lastFour);

        return result.toString();
    }

    public static void main(String[] args) {

        String phone = "9876543210";

        String result =
            maskPhoneNumber(phone);

        System.out.println(result);
    }
}