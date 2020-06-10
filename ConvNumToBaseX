import java.util.*;

public class Main {
    public static void main(String[] args) {
        int base10Num = 100;
        int baseXNum = convBase10ToBaseXNum(base10Num, 8);
        System.out.println(baseXNum);
    }

    public static int convBase10ToBaseXNum(int num, int base) {
        int result = 0;
        List < Integer > list = new ArrayList < > ();
        while (num != 0) {
            list.add(num % base);
            num = num / base;
        }
        for (int i = 0; i < list.size(); i++) {
            result += (list.get(i) * Math.pow(10, i));
        }
        return result;
    }
}
