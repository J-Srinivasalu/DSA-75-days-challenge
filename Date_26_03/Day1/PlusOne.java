import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3,7,5};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    private static int[] plusOne(int[] digits){
        boolean check = false;
        int n = digits.length-1;
        for(int i=n;i>=0;i--){
            int temp = digits[i]+1;
            if(temp>=10){
                check = true;
                digits[i] = temp%10;
            }
            else{
                check = false;
                digits[i] = temp;
                break;
            }
        }
        if(check) {
            int[] c = new int[digits.length+1];

            System.arraycopy(new int[] {1}, 0, c, 0, 1);
            System.arraycopy(digits, 0, c, 1, digits.length);
            return c;
        }
        return digits;
    }
}
