package tasks;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class Two {
    public static void main(String[] args) {



        List listA = new Vector();
        listA.add(1);
        listA.add(2);
        listA.add(3);


       System.out.println("1: " + oppositeHouse(1,3));
       System.out.println("2: " + nameShuffle("Donald Trump"));
       System.out.println("3: " + discount(1500,50));
       System.out.println("4: " + differenceMaxMin(listA));
       System.out.println("5: " + equal(5,5, 6));
       System.out.println("6: " + reverse("Donald Trump"));
       System.out.println("7: " + programmers(50,25,10));
       System.out.println("8: " + getXO("xotrxodsox"));
       System.out.println("9: " + bomb("hellobombds"));
       System.out.println("10: " + sameAscii("AA", "B@"));
    }


    // 2/6
    // вывести номер дома на противоположной стороне
    public static int oppositeHouse(int a, int n) {
        return (n * 2 + 1) - a;
    }
    // поменять имя и фамилию
    public static String nameShuffle(String s) {
        String[] s1 = s.split(" ");
        return s1[1] +" "+  s1[0];
    }
    // возврат цену после скидки
    public static double discount(double price, double disc) {
        return price - price / 100 * disc;
    }
    // разн между наиб и наим числами
    public static int differenceMaxMin(List<Integer> a) {
        Collections.sort(a);
        return a.get(a.size() - 1) - a.get(0);
    }
    // количество целых чисел, имеющий одинаковое значение
    public static int equal(int a, int b, int c) {
        if ((a==b) && (b==c))
            return 3;
        else if (((a==b) && (b!=c) ) || ((b==c) && (a!=c)) || ((a==c) && (a!=b)) )
            return 2;
        else
            return 0;
    }
    // реверс строки
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    // разница между макс и мин
    public static int programmers(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }
    // одинаковое ли количество x и o
    public static boolean getXO(String str) {
        int kolx = 0;
        int kolo = 0;

        for (char ch : str.toCharArray()) {
            if (ch == 'x') {
                kolx++;
            };
            if (ch == 'o') {
                kolo++;
            };
        }
        return kolo == kolx;
    }
    // найти слово бомба
    public static String bomb(String str) {
        if (str.toLowerCase().contains("bomb"))
            return "DUCK!";
        else
            return "Relax, there is no bomb.";
    }
    // сумма значений ascii
    public static boolean sameAscii(String a, String b) {
        int Sum1 = 0;
        for (int i = 0; i < a.length(); i++) {
            Sum1 += (int) a.charAt(i);
        }
        int Sum2 = 0;
        for (int i = 0; i < b.length(); i++) {
            Sum2 += (int) b.charAt(i);
        }
        return Sum1 == Sum2;
    }
}
