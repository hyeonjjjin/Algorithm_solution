// 괄호 변환 >> 블로그 XX

public class SolutionL2_11 {
    private String input;
    private String u, v;

    public void SolutionL2_11(String p) {
        input = p;
    }

    public SolutionL2_11(String input) {
        this.input = input;
    }

    public String solve() {
//        TODO: Algo
        return "hello ";
    }
    /*
    public static String solutionL2_11(String p) {
        switch (CheckCorrect(p)) {
            case 1:
                return p; //균형잡히고 올바른 괄호 문자열
            case 0: //균형잡히고 올바르지 않은 문자열
        }
        return "";
    }*/

    private boolean CheckCorrect() {
        String[] pArray = input.split("");
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
        if (correct == 1) return true;
        else return false;
    }

    //public static void main(String[] args) {
    //    System.out.println("hello world ");
    //}
}