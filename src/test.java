import java.util.Arrays;

public class test {
    // 괄호 변환 >> 블로그 XX
    public static String u = "";
    public static String v = "";

    public static int CheckCorrect(String p) {
        String[] pArray = p.split("");
        int checkUW = 0, correct = 1;
        String temp = "";

        for (String parentheses : pArray) {
            temp += parentheses;
            if (parentheses == "(") checkUW++;
            else checkUW--;
            if (checkUW < 0) {
                correct = -1;
                break;
            } else if (checkUW == 0) {
                u = temp;
                temp = "";
            }
        }
        v = temp;

        if (correct == 1) return 1;
        else return 0;
    }


}
