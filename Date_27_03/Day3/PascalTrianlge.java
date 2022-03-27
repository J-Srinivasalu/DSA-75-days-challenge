import java.util.*;

public class PascalTrianlge {
    public static void main(String[] args) {
        List<List<Integer>> ans = generate(5);
        for(List<Integer> list: ans)
            System.out.println(list);
    }
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int line = 1; line <= numRows; line++) {
            // used to represent C(line, i)
            List<Integer> list = new ArrayList<>();
            int C = 1;
            for (int i = 1; i <= line; i++) {
 
                // The first value in a line is always 1
                list.add(C);
                C = C * (line - i) / i;
            }
            ans.add(list);
        }
        return ans;
    }
}
