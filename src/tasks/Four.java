package tasks;

import java.util.*;

public class Four {

    //Создайте функцию, которая принимает массив чисел и возвращает "Бум!",
    // если в массиве появляется цифра 7. В противном случае верните "в массиве нет 7".
    public static String sevenBoom(List<Integer> arr) {
        if (arr.contains(7)) {
            return "Boom!";
        } else {
            return "There is no 7";
        }
    }
    //Создайте функцию, которая определяет, могут ли элементы в массиве
    //   быть переупорядочены, чтобы сформировать последовательный список чисел,
    //   где каждое число появляется ровно один раз.
    public static boolean cons(List<Integer> arr) {
        Collections.sort(arr);
        for (int i = 0; i < arr.size() - 1; ++i) {
            if (arr.get(i + 1) - arr.get(i) > 1 || Collections.frequency(arr, arr.get(i)) > 1)
                return false;
        }
        return true;
    }

    // поменять местами каждую пару
    public static String unmix(String str) {
        String res = "";
        for (int i = 0; i < str.length() - 1; i += 2) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            res = res + b + a;
        }
        return res;
    }
    //Создать функцию, которая преобразует предложения, заканчивающиеся
    // несколькими вопросительными знаками ?
    // или восклицательными знаками ! в предложение,
    // заканчивающееся только одним, без изменения пунктуации в середине предложений.
    public static String noYelling(String str) {
        if (str.charAt(str.length() - 1) == '?') {
            while (str.charAt(str.length() - 1) == '?') {
                str = str.substring(0, str.length() - 1);
            }
            str += "?";
        }
        else if (str.charAt(str.length() - 1) == '!') {
            while (str.charAt(str.length() - 1) == '!') {
                str = str.substring(0, str.length() - 1);
            }
            str += "!";
        }
        return str;
    }
    //Создайте функцию, которая заменяет все x в строке следующими способами:
    //Замените все x на "cks", ЕСЛИ ТОЛЬКО:
    //Слово начинается с "x", поэтому замените его на "z".
    //Слово-это просто буква "х", поэтому замените ее на " cks ".
    public static String xPronounce(String text) {
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].length() > 1 && arr[i].startsWith("x")) {
                arr[i] = "z" + arr[i].substring(1);
            } else if (arr[i].equals("x"))
                arr[i] = "cks";
        }
        return String.join(" ", arr);
    }
    //	Учитывая массив целых чисел, верните наибольший разрыв между отсортированными элементами массива.
    public static int largestGap(List<Integer> arr) {
        Collections.sort(arr);
        int gap = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) > gap)
                gap = arr.get(i + 1) - arr.get(i);
        }
        return gap;
    }
    // вызов обратного кодирования
    public static int raz (int a) {
        String num = String.valueOf(a);
        int a1 = a;
        int a2 = 0;
        int aa=1;
        int result[] = new int[num.length()];
        for (int i = num.length()-1; i >= 0; i--) {
            result[i] = a1 % 10;
            a1 /= 10;
        }
        Arrays.sort(result);
        for (int i = num.length()-1; i >= 0; i--) {
            a2 += result[i] * aa;
            aa = aa*10;
        }
        return a-a2;
    }
    //Создайте функцию, которая принимает предложение в качестве входных данных
    // и возвращает наиболее распространенную последнюю гласную в предложении в виде одной символьной строки
    public static String commonLastVowel(String str) {
        String[] arr = str.toLowerCase().split(" ");
        Hashtable<Character, Integer> table = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            char lastChar = arr[i].charAt(arr[i].length() - 1);
            if (lastChar == 'a' || lastChar == 'e' || lastChar == 'i' || lastChar == 'o' || lastChar == 'u') {
                try {
                    table.put(lastChar, table.get(lastChar) + 1);
                } catch (Exception e) {
                    table.put(lastChar, 1);
                }
            }
        }
        int max = Collections.max(table.values());
        String ch = "";
        Iterator it = table.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry) it.next();
            if (pair.getValue() == max) {
                ch = Character.toString(pair.getKey());
                break;
            }
            it.remove();
        }
        return ch;
    }
// сложить числа неправильно
    public static int memeSum(int a, int b) {
        String max;
        String min;
        String sum;
        if (a > b) {
            max = String.valueOf(a);
            min = String.valueOf(b);
        } else {
            min = String.valueOf(a);
            max = String.valueOf(b);
        }
        sum = "";
        if (max.length() != min.length()) {
            String other = max.substring(0, max.length() - min.length());
            sum = other;
            max = max.substring(other.length());
        }
        for (int i = 0; i < max.length(); i++) {
            sum = sum + (Integer.parseInt(String.valueOf(max.charAt(i))) + Integer.parseInt(String.valueOf(min.charAt(i))));
        }
        return Integer.parseInt(sum);
    }
    //Создайте функцию, которая удалит все повторяющиеся символы в слове,
    // переданном этой функции. Не просто последовательные символы,
    // а символы, повторяющиеся в любом месте строки
    public static String unrepeated(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (!res.contains(String.valueOf(str.charAt(i)))) {
                res += str.charAt(i);
            }
        }
        return res;
    }
}
