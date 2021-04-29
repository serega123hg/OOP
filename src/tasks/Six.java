package tasks;

import java.math.BigInteger;
import java.util.*;
public class Six {
    //Напишите функцию, чтобы найти анаграмму второй строки, вложенную где-то в первую строку
    //Провека - состоит ли s только из символов target
    public static boolean isAnagram(final String s, final String target){

        if(s.length() != target.length()){
            return false;
        }

        //Копирование для расхода
        String S = s, T = target;

        for(int i = 0; i < s.length(); i++){

            //Если символ не содержиться в s, то s не анаграмма
            if(!T.contains("" + s.charAt(i))){
                return false;
            }

            //Вырезаем символ
            T = T.substring(0,T.indexOf(s.charAt(i))) + T.substring(T.indexOf(s.charAt(i)) + 1);
            S = S.substring(0,S.indexOf(s.charAt(i))) + S.substring(S.indexOf(s.charAt(i)) + 1);
        }

        //Если на выходе нулевые строки, то они полностью взаимоисключились и s анаграмма
        return T.length() == 0 && S.length() == 0;
    }

    public static String hiddenAnagram(final String s, final String target){
        //Сначала удалим все не буквы
        String AlfaS = "", targ = "";

        //Копируем обе строки, но только буквы
        for(int i = 0; i < s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                AlfaS += s.charAt(i);
            }
        }
        for(int i = 0; i < target.length(); i++){
            if(Character.isAlphabetic(target.charAt(i))){
                targ += target.charAt(i);
            }
        }

        //Если анаграмма больше строки, то искать не имеет смысла
        if(AlfaS.length() < targ.length()){
            return "notfound";
        }

        //К нижнему регистру
        AlfaS = AlfaS.toLowerCase(Locale.ROOT);
        targ = targ.toLowerCase(Locale.ROOT);

        //Выделяем подстроки длиной с target
        for(int i = 0; i <= AlfaS.length() - targ.length(); i++){

            //Выделяем подстроки длиной с target и сравниваем их
            if(isAnagram(AlfaS.substring(i, i + targ.length()), targ)){
                return AlfaS.substring(i, i + targ.length());
            }
        }
        return "notfound";
    }

    //Напишите функцию, которая возвращает массив строк, заполненных из срезов символов n-длины данного слова
    // (срез за другим, в то время как n-длина применяется к слову).
    public static ArrayList<String> collect(final String s, int n){
        //Копируем строку
        String buff = s;

        ArrayList<String> arr = new ArrayList(0);

        while(buff.length() >= n){
            //Добавляем подстроку
            arr.add(buff.substring(0, n));

            //Уменьшаем строку
            buff = buff.substring(n);
        }

        //Сортируем
        Collections.sort(arr);

        return arr;
    }
//В шифре Nico кодирование осуществляется путем создания цифрового ключа и присвоения каждой буквенной позиции
// сообщения с помощью предоставленного ключа.
//Создайте функцию, которая принимает два аргумента, message и key, и возвращает закодированное сообщение
    //Метод для обмена столбиков
    public static void swapColumns(char[][] charr, final int c1, final int c2){
        char temp;

        for(int i = 0; i < charr.length; i++){
            temp = charr[i][c1];
            charr[i][c1] = charr[i][c2];
            charr[i][c2] = temp;
        }
    }

    //Метод для шифроания Нико
    public static String nicoCipher(String message, String key){
        int s2 = key.length();
        int s1 = (int)Math.ceil(((double)message.length() / s2));

        //Формируем массив для перестановок
        char[][] charr = new char[s1][s2];

        //Заполняем его
        int si = 0;

        for(int i = 0; i < charr.length; i++){

            for(int j = 0; j < charr[i].length; j++, si++){
                charr[i][j] = si < message.length()? message.charAt(si) : ' ';
            }
        }

        //Переодим ключ в массив char
        char[] chkey = key.toCharArray();
        /*String sortedKey = key;*/

        //Сортируем
        Arrays.sort(chkey);

        //Возвращаем в форму String
        String sortedKey = "";
        for(int i = 0; i < chkey.length; i++){
            sortedKey += chkey[i];
        }


        //Формируем массив номеров key
        int[] sortNumKey = new int[key.length()];

        for(int i = 0; i < sortNumKey.length; i++){
            sortNumKey[i] = sortedKey.indexOf(key.charAt(i));

            sortedKey = sortedKey.replaceFirst("" + key.charAt(i), "|");
        }

        //Можно сортировать
        int temp;
        for(int i = sortNumKey.length - 1; i >= 1; i--){

            for(int j = 0; j < i; j++){

                if(sortNumKey[j] > sortNumKey[j+1]){
                    temp = sortNumKey[j];
                    sortNumKey[j] = sortNumKey[j + 1];
                    sortNumKey[j + 1] = temp;

                    swapColumns(charr, j, j + 1);
                }
            }
        }

        //Вытягиваем двумерный массив
        String res = "";

        for(int i = 0; i < charr.length; i++){

            for(int j = 0; j < charr[i].length; j++){
                res += charr[i][j];
            }
        }

        return res;
    }

    // Создайте метод, который принимает массив arr и число n и возвращает массив из
    // двух целых чисел из arr, произведение которых равно числу n
    public static ArrayList twoProduct(int[] arr, int n) {
        ArrayList<Integer> resarr = new ArrayList<>(0);
        resarr.add(-1);
        resarr.add(-1);

        int min_gap = arr.length;

        for (int i = 0; i < arr.length; i += 1) {
            for (int j = i + 1; j < arr.length; j += 1) {

                if (arr[i] * arr[j] == n && j - i - 1 < min_gap) {

                    resarr.set(0, arr[i]);
                    resarr.set(1, arr[j]);


                    min_gap = j - i - 1;

                    /*return resarr;*/

                    break;
                }

            }
        }

        if(min_gap == arr.length/*resarr.get(0) == -1 && resarr.get(1) == -1*/){
            resarr = new ArrayList<>(0);
        }
        return resarr;
    }

    // Создайте рекурсивную функцию, которая проверяет, является ли число точной верхней границей факториала n.
    // Если это так, верните массив точной факториальной границы и n, или иначе, пустой массив
    // считаем факториал
    public static int findFact(int f, int div){

        if(f % div == 0){
            if(f / div == 1){
                return div;
            }else{
                return findFact(f / div, div + 1);
            }

        }else{
            return 0;
        }
    }
    public static ArrayList isExact(int f){
        ArrayList<Integer> arr = new ArrayList<>(0);

        int res = findFact(f, 2);

        if(res != 0){
            arr.add(f);
            arr.add(res);
        }

        return arr;
    }
//Создайте функцию, которая принимает десятичную дробь в строковой форме с повторяющейся частью
// в круглых скобках и возвращает эквивалентную дробь в строковой форме и в наименьших членах.
    public static String fractions(String fraction){

        //Получае целую часть
        BigInteger intPart = new BigInteger(fraction.substring(0, fraction.indexOf('.')));
        String buff = "";

        //Получаем периодическую часть
        int period = Integer.parseInt(fraction.substring(fraction.indexOf('(') + 1, fraction.indexOf(')')));

        //Получаем дробную часть до периода
        buff = fraction.substring(fraction.indexOf('.') + 1, fraction.indexOf('('));
        int beforePeriod = Integer.parseInt(buff.equals("") ? "0" : buff);

        //Берем все цифрыы после запятой
        int reduce = Integer.parseInt(fraction.substring(fraction.indexOf('.') + 1, fraction.indexOf('(')) +
                fraction.substring(fraction.indexOf('(') + 1, fraction.indexOf(')')));

        //Числитель
        int numerator = reduce - beforePeriod;

        //Знаменатель
        String denominator = "";

        //Строим знаменатель
        for(int i = 0; i < ("" + period).length(); i++){
            denominator += "9";
        }
        for(int i = 0; beforePeriod != 0 && i < ("" + beforePeriod).length(); i++){
            denominator += "0";
        }

        BigInteger n = new BigInteger("" + numerator);
        BigInteger d = new BigInteger(denominator);
        BigInteger g;

        //Делим на наибольший общий делитель пока он не 1
        while(!(g = n.gcd(d)).equals(new BigInteger("1"))){
            n = n.divide(g);
            d = d.divide(g);
        }

        //Учитываем целую часть
        if(!intPart.equals(new BigInteger("0"))){
            n = intPart.multiply(d).add(n);
        }

        return "" + n.toString() + " / " + d.toString();

    }

    // В этой задаче преобразуйте строку в серию слов (или последовательности символов), разделенных одним пробелом,
    // причем каждое слово имеет одинаковую длину, заданную первыми 15 цифрами десятичного представления числа Пи
    public static String pilish_string(String s){
        if(s.equals("")){
            return "";
        }

        String pi = "314159265358979";
        int subsLen;

        String res = "";

        for(int i = 0; pi.length() != 0 && i < s.length(); i += subsLen){
            //Получаем требуемую длину
            subsLen = Integer.parseInt(pi.substring(0, 1));

            //Убираем ее из pi
            pi = pi.substring(1);

            //Если требуемая длина больше исходной строки
            if(i + subsLen >= s.length()){
                //Копируем слово
                res += s.substring(i);

                //Дописываем символы
                char ch = res.charAt(res.length() - 1);

                for(int j = 0; j < i + subsLen - s.length(); j++){
                    res += ch;
                }
                res += " ";
            }
            else {
                //Получаем подстроку
                res += s.substring(i, i + subsLen) + " ";
            }

        }

        return res.substring(0, res.length() - 1);
    }

// Создайте функцию для генерации всех непоследовательных двоичных строк, где непоследовательные определяется как строка,
// в которой нет последовательных строк, и где n определяет длину каждой двоичной строки
    //Формирование двоичного числа и проверка на содержание "11"
    public static String checkCons(int d, int n){
        String res = "";

        //Строим двоичное представление
        for(int i = (int)Math.pow(2, n - 1); i > 0; i = i >> 1){

            if((d & i) != 0){
                res += "1";
            }else{
                res += "0";
            }
        }

        if(!res.contains("11")){
            return res;
        }else{
            return null;
        }
    }
    //Генерация строки двоичных чисел от 0 до 2^n - 1, которые не содержат "11"
    public static String generateNonconsecutive(int n){
        int last = (int)Math.pow(2, n) - 1;

        String res = "", buff = "";

        for(int d = 0; d <= last; d++){

            //Если число подходит
            if((buff = checkCons(d, n)) != null){
                res += buff + " ";
            }
        }

        return res.substring(0, res.length() - 1);

    }

    // Шерлок считает строку действительной, если все символы строки встречаются одинаковое количество раз.
    // Также допустимо, если он может удалить только 1 символ из 1 индекса в строке, а остальные символы будут встречаться
    // одинаковое количество раз.
    // Для данной строки str определите, действительна ли она. Если да, верните «ДА», в противном случае верните «НЕТ
    public static String isValid(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        Integer n = new Integer(0);

        for(int i = 0; i < s.length(); i++){
            //Если элмент есть
            if((n = map.get(s.charAt(i))) != null){
                map.put(s.charAt(i), n + 1);
                //Если нет, то кладем первый элемент
            }else{
                map.put(s.charAt(i), 1);
            }
        }

        Integer min = new Integer(s.length()), temp = new Integer(0);
        int diff_1 = 0, diff_more_1 = 0;

        //Найдем min
        for (HashMap.Entry e: map.entrySet()) {
            temp = (Integer)(e.getValue());

            if(temp < min){
                min = temp;
            }
        }

        //Найдем кол-во значений, больших min на 1 и на более чем 1
        for (HashMap.Entry e: map.entrySet()) {

            temp = (Integer)(e.getValue());

            if(temp > min){

                if(temp - min == 1){
                    diff_1++;

                }else if(temp - min > 1){
                    diff_more_1++;
                }

            }
        }

        if(diff_more_1 > 0){
            return "NO";
        }
        if(diff_1 > 1){
            return "NO";
        }

        return "YES";

    }

    // Создайте функцию, которая получает каждую пару чисел из массива, который суммирует до восьми,
    // и возвращает его как массив пар (отсортированный по возрастанию).
    public static ArrayList<ArrayList<Integer>> sumUp(ArrayList<Integer> arr){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int s = -1;

        for(int i = 0; i < arr.size() - 1; i++){

            for(int j = i + 1; j < arr.size(); j++){

                //Нашли сумму = 8
                if(arr.get(i) + arr.get(j) == 8){
                    //Добавили массив
                    res.add(new ArrayList<>());

                    s++;

                    //Добавили значения
                    res.get(s).add(arr.get(i));
                    res.get(s).add(arr.get(j));

                    //Отсортировали
                    Collections.sort(res.get(s));
                }

            }
        }

        return res;
    }
}
