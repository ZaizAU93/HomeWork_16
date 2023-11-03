import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    public static void main(String[] args) {

        String inputText = "Произвольный текст с номером документа 1423-1512-51, емейлом teachmeskills@gmail.com и номером телефона +(29)123456789.";

        String email = findEmail(inputText);
        String documentNumber = findDocumentNumber(inputText);
        String phoneNumber = findPhoneNumber(inputText);



        System.out.println("email: " + email);
        System.out.println("document number: " + documentNumber);
        System.out.println("phone number: " + phoneNumber);
    }

    public static String findEmail(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }

        return "";
    }

    public static String findDocumentNumber(String text) {
        Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{2}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }

        return "";
    }

    public static String findPhoneNumber(String text) {
        Pattern pattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }

        return "";
    }
}
