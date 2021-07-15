import java.util.Arrays;

public class SolutionL2_17 {
    //기능 개발 >> 블로그 XX
    public static int[] solutionL2_17(int[] progresses, int[] speeds){
        //다른 조건이 있나,, 스택 큐 안썼다고 이러는거니 혹시
        int[] times = new int[progresses.length];
        int[] answer = new int[progresses.length];
        int index=0, index_ans=0;
        for(int i=0;i<progresses.length;i++)
            times[i] = (int) Math.ceil((100-progresses[i])/speeds[i]);

        for(int time:times){
            if(index ==0) answer[index_ans] += 1;
            else {
                if (time <= times[index - 1]) answer[index_ans]++;
                else answer[++index_ans]++;
            }
            index++;
        }
        return Arrays.copyOf(answer, index_ans+1);
    }

    public static void main(String[] args) {
        int[] progresses={1,2};
        int[] speeds={99,3};
        System.out.println("기능개발: "+Arrays.toString(solutionL2_17(progresses, speeds)));
    }
}
