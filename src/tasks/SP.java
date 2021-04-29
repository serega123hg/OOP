package tasks;
import java.util.*;
public class SP {

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        /////№1
        String str = c.nextLine();
        char[] arr = str.toCharArray();
        Spyder pa = new Spyder(arr[0],Character.getNumericValue(arr[1]));
        str = c.nextLine();
        char[] arr1 = str.toCharArray();
        Spyder pc = new Spyder(arr1[0],Character.getNumericValue(arr1[1]));
        System.out.println(spiderVsFly(pa,pc));
    }

    public static class Spyder {
        private char name;
        private Integer count;
        public Spyder(char name, int count) {
            this.name = name;
            this.count = count;
        }
        public void setCount(int val) { this.count = val; }
        public void setName(char val) { this.name = val; }
    }

    public static String spiderVsFly(Spyder p1, Spyder p2) {
        String res = p1.name + "" + p1.count + " ";
        do {
            if (Math.abs(((int) p1.name - (int) p2.name)) <= 2 && p1.count == p2.count) {
                while (((int) p1.name != (int) p2.name) && p1.count == p2.count) {
                    if ((int) p1.name < (int) p2.name) {
                        p1.setName((char) ((int) p1.name + 1));
                    } else {
                        p1.setName((char) ((int) p1.name - 1));
                    }
                    res += p1.name + "" + p1.count + " ";
                }
            }
            else if (p1.name=='A' && p2.name == 'H' || p1.name=='H' && p2.name == 'A'){
                p1.setName(p2.name);
                res += p1.name + "" + p1.count + " ";
            }
            else if (p1.name == 'A' && p2.name == 'G' || p1.name=='G' && p2.name == 'A'){
                p1.setName('H');
                res += p1.name + "" + p1.count + " ";
            }
            else {
                if (((int) p1.name != (int) p2.name) && p1.count > 0) {
                    p1.setCount(p1.count - 1);
                }
                if (p1.count == 0) {
                    res += "A0" + " ";
                    p1.setName(p2.name);
                }
                if (((int) p1.name == (int) p2.name)) {
                    p1.setCount(p1.count + 1);
                }
                res += p1.name + "" + p1.count + " ";
            }
        }while (((int) p1.name != (int) p2.name) || p1.count != p2.count);
        return res;
    }
}
