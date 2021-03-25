package tasks;

public class One {
    public static void main(String[] args) {
        System.out.println("1: " + minToSec(2));
        System.out.println("2: " + points(5,6));
        System.out.println("3: " + footballPoints(2,1,5));
        System.out.println("4: " +  divByFive(16));
        System.out.println("5: " + and(true, true));
        System.out.println("6: " + howManyWalls(54,1,43));
        System.out.println("7: " + squared(5));
        System.out.println("8: " + profitableGamble(0.2, 50, 9));
        System.out.println("9: " + frames(10,1));
        System.out.println("10: " + mod(5,2));

    }

    // 1/6
    // преобразует минуты в секунды
    public static int minToSec(int minutes) {
        return minutes * 60;
    }
    // подсчет 2 и 3 очковых
    public static int points(int a, int b) {
        return a * 2 + b * 3;
    }
    // подсчет побед * 3, ничьих * 1 и проигрышей * 0
    public static int footballPoints(int wins, int ties, int losses) {
        return wins * 3 + ties;
    }
    // делится ли на 5
    public static boolean divByFive(int a) {
        return a % 5 == 0;
    }
    // функция &&
    public static boolean and(boolean a, boolean b) {
        return a && b;
    }
    // сколько стен можно покрасить, n - кол метров, w и h - высота и ширина стены
    public static int howManyWalls(int n, int w, int h) {
        return n / (w * h);
    }
    // квадрат числа
    public static int squared(int a) {
        return a * a;
    }
    // прибыль
    public static boolean profitableGamble(double prob, double prize, double pay) {
        return prob * prize > pay;
    }
    // количество кадров
    public static int frames(int a, int b) {
        return a * b * 60;
    }
    // оператор %
    public static int mod(int a, int b) {
        return a - (a / b) * b;
    }

}
