//가장 큰 수 >> 블로그 XX
public class SolutionL2_12 {
    private String input="";

    public SolutionL2_12(int[] numbers) {
        this.input = input;
        String[] num_s=new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
            num_s[i] = Integer.toString(numbers[i]);
        }
        //num_s 각각 길이를 통해 몇자리순지 알아내고, 나눠서 맨 앞자리가 큰 애를 찾아.
        //맨 앞자리가 같은 수라면 두번째 자리 수에 대해 반복해

        //암튼 맨앞자리 수 젤큰애가 맨앞으로 가야함
    }


    public String BigNum(){
        //int len = input.length();

        String answer = "이게 맞나?";
        return answer;
    }
    public SolutionL2_12(String input) {
        this.input = input;
    }

}
