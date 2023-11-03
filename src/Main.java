import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //Практика:
    //1. Написать метод который сможет вернуть все цифры из строки:
    //“Today my 17th lesson. I’m the best 1! Find me in inst: @teachmeskills”.
    //2. Написать метод который сможет заменить КАЖДУЮ букву на знак & в строке из 1
    //задания.
    //3. Написать метод который сможет вернуть инсту в строке из 1 задания.
    //4. Написать метод который возвращает true если строка имеет вид “null”.
    //5. В строке “Hello \n world \n !!!” заменить \n на “” используя классы Pattern и Matcher.
    //6. В строке “Всем привет!! Меня зовут Билл Гейтс и я мечтаю учиться в TeachMeSkills!”
    //найти имя и фамилию человека и вывести на экран!
    public static void main(String[] args) {
        String str = "Today my 17th lesson. I’m the best 1! Find me in inst: @teachmeskills";
        String str1 = "Hello \n world \n !!!";
        String str2 = "Всем привет!! Меня зовут Билл Гейтс и я мечтаю Bill Gates учиться в TeachMeSkills!";
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

        //Блок 2. Домашнее задание
        //Задача 1:
        //Вывести в консоль из строки которую пользователь вводит с клавиатуры все
        //аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
        //только из прописных букв, без чисел.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String input = scanner.nextLine();
        System.out.println(abbreviation(input));


        //Задача *:
        //Программа на вход получает произвольный текст. В этом тексте может быть номер
        //документа(один или несколько), емейл и номер телефона. Номер документа в формате:
        //xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате: +(xx)xxxxxxx. Документ
        //может содержать не всю информацию, т.е. например, может не содержать номер
        //телефона, или другое. Необходимо найти эту информацию и вывести в консоль в
        //формате:
        //email: teachmeskills@gmail.com
        //document number: 1423-1512-51
        //и т.д


    }

    public static String numbers(String str) {
        Pattern pattern = Pattern.compile("\\d");

        Matcher mat = pattern.matcher(str);
        System.out.println("Все цифры строки " + str);
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
            return "Совпадений не найдено";
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
            return "Совпадений не найдено";
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
            return "Совпадений не найдено";
        }
    }
}