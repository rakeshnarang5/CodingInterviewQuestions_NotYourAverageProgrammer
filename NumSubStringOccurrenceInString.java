import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "yzxxyzabzyxxyzyxhfdskazyxyzx";
        int count = 0;
        String subStr = "xyz";
        int start = 0;
        int end = input.length() - 1;
        while (start <= end) {
            if (input.charAt(start) == subStr.charAt(0)) {
                boolean match = true;
                for (int i = 1; i < subStr.length() - 1; i++) {
                    start++;
                    if (start > end || input.charAt(start) != subStr.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    count++;
                }
            } else {
                start++;
            }
        }
        System.out.println(count);
    }
}
