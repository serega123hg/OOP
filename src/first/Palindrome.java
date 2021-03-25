package first;

public class Palindrome {
    public static void main(String[] args)
    {
        for (int i = 0; i < args.length; i++)
        {
            String s = args[i];
            isPalindrome(s);
        }
    }
    //Переворачиваем строку
    public static String reverseString(String s) {
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i --)
        {
            s1 += s.charAt(i);
        }
        return s1;
    }

    //Сравниваем оригинальную строку и перевернутую
    public static boolean isPalindrome(String s) {
        if (s.equals(reverseString(s))) {
            System.out.println(s + " - is palindrom");
            return true;
        }
        else {
            System.out.println(s + " - nope");
            return false;
        }
    }
}