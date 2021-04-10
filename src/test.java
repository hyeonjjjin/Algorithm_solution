import java.util.Arrays;
class test_extend{
    public static String u = "";
    public static String v = "";
}
public class test extends test_extend{
    //어케해..
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
