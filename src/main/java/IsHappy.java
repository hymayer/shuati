import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while (n != 1 && !sumSet.contains(n)) {
            sumSet.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n = n /10;
        }
        return sum;
    }

}