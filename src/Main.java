import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //��������:
    //1. �������� ����� ������� ������ ������� ��� ����� �� ������:
    //�Today my 17th lesson. I�m the best 1! Find me in inst: @teachmeskills�.
    //2. �������� ����� ������� ������ �������� ������ ����� �� ���� & � ������ �� 1
    //�������.
    //3. �������� ����� ������� ������ ������� ����� � ������ �� 1 �������.
    //4. �������� ����� ������� ���������� true ���� ������ ����� ��� �null�.
    //5. � ������ �Hello \n world \n !!!� �������� \n �� �� ��������� ������ Pattern � Matcher.
    //6. � ������ ����� ������!! ���� ����� ���� ����� � � ������ ������� � TeachMeSkills!�
    //����� ��� � ������� �������� � ������� �� �����!
    public static void main(String[] args) {
        String str = "Today my 17th lesson. I�m the best 1! Find me in inst: @teachmeskills";
        String str1 = "Hello \n world \n !!!";
        String str2 = "���� ������!! ���� ����� ���� ����� � � ������ Bill Gates ������� � TeachMeSkills!";
        //1
        System.out.println(numbers(str));
        //2
        System.out.println(replacChar(str));
        //3
        System.out.println(inst(str));
        //4
        System.out.println(isNullString("null")); // true
        System.out.println(isNullString("Null")); // false
        System.out.println(isNullString("NULL")); // false
        System.out.println(isNullString("string")); // false
        // 5
        System.out.println(replacCharN(str1));
        //6
        System.out.println(firstNameLastName(str2));

        //���� 2. �������� �������
        //������ 1:
        //������� � ������� �� ������ ������� ������������ ������ � ���������� ���
        //������������. ������������� ����� ������� ����� �� 2 �� 6 ��������, ���������
        //������ �� ��������� ����, ��� �����.

        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ������: ");
        String input = scanner.nextLine();
        System.out.println(abbreviation(input));


        //������ *:
        //��������� �� ���� �������� ������������ �����. � ���� ������ ����� ���� �����
        //���������(���� ��� ���������), ����� � ����� ��������. ����� ��������� � �������:
        //xxxx-xxxx-xx, ��� x - ��� ����� �����; ����� �������� � �������: +(xx)xxxxxxx. ��������
        //����� ��������� �� ��� ����������, �.�. ��������, ����� �� ��������� �����
        //��������, ��� ������. ���������� ����� ��� ���������� � ������� � ������� �
        //�������:
        //email: teachmeskills@gmail.com
        //document number: 1423-1512-51
        //� �.�


    }

    public static String numbers(String str) {
        Pattern pattern = Pattern.compile("\\d");

        Matcher mat = pattern.matcher(str);
        System.out.println("��� ����� ������ " + str);
        String result = "";
        while (mat.find()) {
            result += mat.group() + " ";
        }

        return result;
    }

    public static String replacChar(String str) {
        String regex = "[a-zA-Z]";
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher1 = pattern1.matcher(str);
        return matcher1.replaceAll("&");
    }

    public static String inst(String str) {
        String regex3 = "\\s[@][a-zA-Z0-9]*([\\s,\'\"\r\n]|$)";
        Pattern pat3 = Pattern.compile(regex3);
        Matcher mat3 = pat3.matcher(str);

        if (mat3.find()) {
            return mat3.group();
        } else {
            return "���������� �� �������";
        }

    }

    public static boolean isNullString(String str) {
        Pattern pattern = Pattern.compile("^null$");
        return pattern.matcher(str).matches();
    }

    public static String replacCharN(String str) {
        String patternString = "\n";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        String result = matcher.replaceAll("");
        return result;
    }

    public static String firstNameLastName(String str) {
        String regex = "\\p{Lu}\\p{L}*\\s+\\p{Lu}\\p{L}*";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);

        if (mat.find()) {
            return mat.group();
        } else {
            return "���������� �� �������";
        }

    }


    public static String abbreviation(String str) {
        String regex = "\\b[A-Z]{2,6}\\b";
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher = pattern1.matcher(str);
        String result = "";

        while (matcher.find()) {
            result += (matcher.group())+ " ";

        }

        if (!result.equals("")){
            return result;
        } else {
            return "���������� �� �������";
        }
    }
}