import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // stack vs heap
        int i = 10; // 10 will be stored in stack
        LocalDate today = LocalDate.now(); // LocalDate object will be stored in heap at some memory location (e.g. 996)
        // memory location value, address (996) is stored in stack (today)

        String hello = "Hello World"; // hello has value of the address of "Hello World" String object
        hello = "whatever"; // hello has value of the address of "whatever" String object, and we don't have a reference to "Hello World" anymore


        System.out.println("Sum of first 5 numbers: ");
        System.out.println(sum(5));
        System.out.println(tailSum(0, 5));
    }

    // head recursion, do the recursive call while the condition is true
    /*
    0, 1, 2, 3, 4, 5
    result of call sum(0) is 0
    result of call sum(1) is 0 + 1 = 1
    result of call sum(2) is 1 + 2 = 3
    result of call sum(3) is 3 + 3 = 6
    result of call sum(4) is 6 + 4 = 10
    result of call sum(5) is 10 + 5 = 15
     */
    static int sum(int n) {
        if (n >= 1) {
            return sum(n - 1) + n;
        }
        return n;
    }

    // tail recursion, do the recursive call as the last statement
    /*
    1, 2, 3, 4, 5
    result of call tailSum(0, 5) is call of tailSum(5, 4)
    result of call tailSum(5, 4) is call of tailSum(9, 3)
    result of call tailSum(9, 3) is call of tailSum(12, 2)
    result of call tailSum(12, 2) is call of tailSum(14, 1)
    result of call tailSum(14, 1) is 15
     */
    static int tailSum(int currentSum, int n) {
        if (n <= 1) {
            return currentSum + n;
        }
        return tailSum(currentSum + n, n - 1);
    }
}