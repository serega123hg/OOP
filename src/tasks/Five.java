package tasks;
import javax.print.attribute.DateTimeSyntax;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class Five {
    public static void main(String[] args) {
        System.out.println("TASK1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("TASK2");
        System.out.println("NO");
        System.out.println("TASK3");
        System.out.println(digitCount(4666));
        System.out.println(digitCount(544));
        System.out.println(digitCount(121317));
        System.out.println("TASK4");
        String array1[] = {"cat", "create", "sat"};
        System.out.println(totalPoints(array1, "caster"));
        String array2[] = {"trance", "recant"};
        System.out.println(totalPoints(array2, "recant"));
        String array3[] = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(array3, "tossed"));
        System.out.println("TASK5");
        int array4[] = {1, 2, 3, 5, 6, 7, 8, 9};
        int array5[] = {1, 2, 3, 10, 11, 15};
        int array6[] = {5, 4, 2, 1};
        System.out.println(longestRun(array4));
        System.out.println(longestRun(array5));
        System.out.println(longestRun(array6));
        System.out.println("TASK6");
        String arr[] = {"50%", "40%"};
        System.out.println(takeDownAverage(arr));
        System.out.println("TASK7");
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(rearrange("the4 t3o man5 Happ1iest of6 no7 birt2hday steel8!"));
        System.out.println(rearrange("is2 Thi1s T4est 3a"));
        System.out.println(rearrange("4of Fo1r pe6ople g3ood th5e the2"));
        System.out.println("TASK8");
        System.out.println(maxPossible(523,76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));
        System.out.println("TASK9");
        timeDifferance("Los Angeles","July 21, 1983 23:01", "Beijing");
        System.out.println("TASK10");
        System.out.println(isNew(5));
        System.out.println(isNew(122));
        System.out.println(isNew(509));
        System.out.println(isNew(50));
        System.out.println(isNew(896));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }
//Создайте функцию, которая возвращает true, если две строки имеют один и тот же буквенный шаблон, и false в противном случае
    public static boolean sameLetterPattern(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length() - 1; i++) {
            if (Math.abs(s1.charAt(i) - s1.charAt(i + 1)) != Math.abs(s2.charAt(i) - s2.charAt(i + 1)))
                return false;
        }
        return true;
    }

    public static void two() {
    }
//Создайте функцию, которая принимает координаты паука и мухи и возвращает кратчайший путь для паука, чтобы добраться до мухи.
    public static String spiderVsFly(final String spider, final String fly){
        String radials = "ABCDEFGH";
        char sr = spider.charAt(0), sl = spider.charAt(1), fr = fly.charAt(0), fl = fly.charAt(1);
        char midRing = Math.abs(sr - fr) <= 2 || 6 <= Math.abs(sr - fr) ? (char)Math.min(sl,fl) : '0';
        String answer = ""+sr+sl+"-";
        while (sl > midRing) answer += --sl == '0' ? "A0-" : ""+ sr + sl + "-";
        while (sl <= fl && midRing != '0') {
            if (sr == fr) break;
            if (6 <= Math.abs(sr -fr)) {
                if (sr > fr) { sr++; if (sr == 'I') sr = 'A';
                }else{ sr--; if (sr == '@') sr = 'H';}
            }
            else{
                if (sr < fr) sr++; else sr--;
            }
            answer += "" + sr + sl + "-";
        }
        while (sl++ < fl) answer += "" + fr + sl + "-";
        return answer.substring(0,answer.length()-1);
    }
//Создайте функцию, которая будет рекурсивно подсчитывать количество цифр числа.
// Преобразование числа в строку не допускается, поэтому подход является рекурсивным
    public static int digitCount(int digit) {
        if (digit < 10)
            return 1;
        else
            return 1 + digitCount(digit / 10);
    }
//Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-буквенное
// слово и возвращает общее количество очков, набранных игроком в определенном раунде
    public static int totalPoints(String[] array, String word) {
        int mainCount = 0;
        List<Character> checkList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            checkList.add(word.charAt(i));
        }

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            char character[] = array[i].toCharArray();
            List<Character> copy = new ArrayList<Character>(checkList);

            for (int q = 0; q < character.length; q++) {
                if (copy.contains(character[q])) {
                    count++;
                    copy.remove(copy.indexOf(character[q]));
                } else
                    count = 0;
            }
            copy.removeAll(copy);
            if (count == 3)
                mainCount += 1;
            else if (count == 4)
                mainCount += 2;
            else if (count == 5)
                mainCount += 3;
            else if (count == 6 && copy.isEmpty())
                mainCount += 54;
            else
                mainCount += 0;
        }

        return mainCount;
    }
// Создайте функцию, которая принимает массив чисел и возвращает длину самого длинного последовательного запуска.
    public static int longestRun(int array[]) {
        int maxCount = 1, count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1] - 1) {
                count++;
                if (maxCount < count)
                    maxCount = count;
            } else
                count = 1;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1] + 1) {
                count++;
                if (maxCount < count)
                    maxCount = count;
            } else
                count = 1;
        }

        return maxCount;
    }
//Какой процент вы можете набрать на тесте, который в одиночку снижает средний балл по классу на 5%?
// Учитывая массив оценок ваших одноклассников, создайте функцию, которая возвращает ответ. Округлите до ближайшего процента
    public static String takeDownAverage(String array[]) {
        int percentage = 0, needPercentage = 0;
        for (int i = 0; i < array.length; i++) {
            percentage += Integer.parseInt(array[i].substring(0, array[i].length() - 1));
        }
        needPercentage = (percentage / array.length - 5) * (array.length + 1) - percentage;

        return Integer.toString(needPercentage) + "%";
    }
//Учитывая предложение с числами, представляющими расположение слова, встроенного в каждое слово,
// верните отсортированное предложение.
    public static String rearrange(String s) {
        String[] s1 = s.split(" ");
        String[] s2 = s.split(" ");
        String sHelp = "";
        for (int i = 0; i < s1.length; i++) {
            sHelp = s1[i];
            for (int j = 0; j < sHelp.length(); j++) {
                if (sHelp.charAt(j) >= 48 && sHelp.charAt(j) <= 57) {
                    int digit = sHelp.charAt(j) - '0';
                    sHelp = sHelp.substring(0, j) + sHelp.substring(j + 1);
                    s2[digit - 1] = sHelp;
                }
            }
        }
        sHelp = "";
        for (int i = 0; i < s2.length; i++) {
            sHelp += s2[i] + " ";
        }

        return sHelp;
    }
// 8.	Напишите функцию, которая делает первое число как можно больше, меняя его цифры на цифры во втором числе.
    public static int maxPossible(int a, int b) {
        ArrayList<Integer> digit1 = new ArrayList<>();
        ArrayList<Integer> digit2 = new ArrayList<>();

        while (a > 0) {
            digit1.add(a % 10);
            a /= 10;
        }
        while (b > 0) {
            digit2.add(b % 10);
            b /= 10;
        }
        if (digit1.size() > digit2.size())
            for (int i = 0; i < digit1.size() - digit2.size(); i++) {
                digit2.add(0);
            }
        Collections.reverse(digit1);
        Collections.sort(digit2);
        Collections.reverse(digit2);
        String result = "";
        for (Integer d : digit1) {
            if (d < digit2.get(0)) {
                result += Integer.toString(digit2.get(0));
                digit2.remove(0);
            }
            else
                result += Integer.toString(d);
        }

        return Integer.parseInt(result);
    }
// В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух разных городах. Вам дается строка cityA и
// связанная с ней строка timestamp (time in cityA) с датой, отформатированной в полной нотации США,
    public static void timeDifferance(String cityA, String today, String cityB) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy HH:mm", Locale.UK);
        Calendar calendar1 = Calendar.getInstance();
        try {
            calendar1.setTime(formatter.parse(today));
            Map<String, Double> map = new HashMap<>();
            map.put("Los Angeles", -8.0);
            map.put("New York",-5.0);
            map.put("Caracas", -4.3);
            map.put("Buenos Aires",-3.0);
            map.put("London",0.0);
            map.put("Rome", 1.0);
            map.put("Moscow",3.0);
            map.put("Tehran", 3.3);
            map.put("New Delhi",5.3);
            map.put("Beijing",8.0);
            map.put("Canberra",10.0);

            Double timeA = 0.0, timeB = 0.0, timeDiff = 0.0;
            for (Map.Entry<String,Double> pair : map.entrySet()) {
                if (pair.getKey() == cityA) {
                    timeA = pair.getValue();
                }
                if (pair.getKey() == cityB) {
                    timeB = pair.getValue();
                }
            }
            System.out.println(" ");
            System.out.println(timeA);
            System.out.println(" ");
            System.out.println(timeB);
            System.out.println(" ");
            if (timeA < 0 && timeB > 0 || timeA > 0 && timeB < 0) {
                timeDiff = Math.abs(timeA) + Math.abs(timeB);
            }
            else if (timeA > 0 && timeB > 0)
                timeDiff = Math.abs(timeA - timeB);
            else
                timeDiff = timeA - timeB;

            System.out.println(timeDiff);
            double d = timeDiff;
            int h = (int)d, m = 0;
            String res = Double.toString(d);
            if (h < 0) {
                m = -Integer.parseInt(res.substring(res.length() - 1));
            }
            else
                m = Integer.parseInt(res.substring(res.length() - 1));
            System.out.println(h);
            System.out.println(m);
            calendar1.add(Calendar.HOUR, h);
            calendar1.add(Calendar.MINUTE, m);
            System.out.println(formatter.format(calendar1.getTime()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
//Новое число-это число, которое не является перестановкой любого меньшего числа.
//Напишите функцию, которая принимает неотрицательное целое число и возвращает true,
// если целое число является новым числом, и false, если это не так.
    public static boolean isNew(int digit) {
        System.out.print(digit + " - ");
        ArrayList<Integer> list = new ArrayList<>();
        while (digit > 0) {
            list.add(digit % 10);
            digit /= 10;
        }
        Collections.reverse(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == 0) {
                return false;
            }
            if (list.get(i) < list.get(0)) {
                return false;
            }
        }
        return true;
    }
}
