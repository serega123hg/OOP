package tasks;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class three {

    public static void main(String[] args) {
        HashMap<String, Integer> population = new HashMap<>();
        population.put("Nice", 942208);
        population.put("Abu Dhabi", 1482816);
        population.put("Vatican City", 572);

        System.out.println(millionsRounding(population));
    }


    //1 Учитывая массив городов и населения, верните массив, в котором все население округлено до ближайшего миллиона


    public static HashMap<String, Integer>millionsRounding(HashMap<String, Integer> population) {
        HashMap<String, Integer> population1 = new HashMap<String, Integer>();
        Set<String> keys = population.keySet();
        for (String p: keys) {
            population1.put(p, (int)Math.round((double) population.get(p)  / 1000000) * 1000000);
        }

        return population1;
    }

    //2.	Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны найти другие 2 стороны (верните самую длинную сторону, сторону средней длины).
    public static List<Double> otherSides(int a) {
        double b = a * 2;
        double squareC = b * b - a * a;
        double c = Math.sqrt(squareC);
        List<Double> list = new ArrayList<>();
        list.add(b);
        list.add(c);
        return list;
    }
    // камень ножницы бумага
    public static String rps(String a, String b) {
        if (a.equals(b))
            return "TIE";
        switch (a) {
            case "rock":
                if (b.equals("paper")) {
                    return "Player2 win!";
                } else {
                    return "Player1 win";
                }
            case "paper":
                if (b.equals("scissors")) {
                    return "Player2 win!";
                } else {
                    return "Player1 win";
                }
            case "scissors":
                if (b.equals("rock")) {
                    return "Player2 win!";
                } else {
                    return "Player1 win";
                }
        }
        return null;
    }
    //массив целых чисел, суммирует четные и нечетные числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел.
    public static int warOfNumbers(List<Integer> arr) {
        final int[] evenSum = {0};
        final int[] oddSum = {0};
        arr.stream().forEach(num -> {
            if (num % 2 == 0) evenSum[0] += num;
            else oddSum[0] += num;
        });
        return evenSum[0] - oddSum[0];
    }

    //Все буквы в нижнем регистре должны быть прописными, и наоборот.
    public static String reverseCase(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    //Конкатенирует inator до конца, если слово заканчивается согласным, в противном случае вместо него конкатенирует  -inator
    //Добавляет длину слова исходного слова в конец, снабженный '000'
    public static String inatorInator(String str) {
        if (str.matches(".*[aeiou]$")) {
            return str + "-inator " + str.length() + "000";
        } else
            return str + "inator " + str.length() + "000";
    }

    // 7.	Напишите функцию, которая принимает три измерения кирпича: высоту(a), ширину(b) и глубину(c)
    // и возвращает true, если этот кирпич может поместиться в отверстие с шириной(w) и высотой(h).
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return a * b <= w * h || a * c <= w * h || b * c <= w * h;
    }

    // 8.	Напишите функцию, которая принимает топливо (литры), расход топлива (литры/100 км), пассажиров,
    // кондиционер (логическое значение) и возвращает максимальное расстояние, которое может проехать автомобиль.
    //топливо-это количество литров топлива в топливном баке.
    //Расход топлива-это базовый расход топлива на 100 км (только с водителем внутри).
    //Каждый дополнительный пассажир увеличивает базовый расход топлива на 5%.
    //Если кондиционер включен, то его общий (не базовый) расход топлива увеличивается на 10%
    public static double totalDistance(double litres, double price, double passes, boolean cond) {
        double multiple = 1;
        if (cond) multiple *= 1.1;
        double passesMult = 1;
        for (int i = 0; i < passes; i++) {
            passesMult += 0.05;
        }
        return (litres / (price * multiple * passesMult)) * 100;
    }
    // 9.Создайте функцию, которая принимает массив чисел и возвращает среднее значение (average) всех этих чисел.
    public static double mean(List<Integer> arr) {
        double sum = arr.stream().mapToInt(Integer::intValue).sum();
        return sum / arr.size();
    }
    // 10.	Создайте функцию, которая принимает число в качестве входных данных и возвращает true,
    // если сумма его цифр имеет ту же четность, что и все число. В противном случае верните false.
    public static boolean parityAnalysis(int num) {
        int sum = 0;
        int num_copy = num;
        while (num_copy != 0) {
            sum += num_copy % 10;
            num_copy /= 10;
        }
        return sum % 2 == num % 2;
    }

}


