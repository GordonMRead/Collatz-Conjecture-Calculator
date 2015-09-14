public class Collatz {
    
    public static void conjecture(int n) {
        int x = n;
        boolean worked = false;
        int max = n;
        int stepsEven = 0;
        int stepsOdd = 0;
        while (!worked) {
            if (x % 2 == 0) {
                x /= 2;
                stepsEven++;
            } else {
                x = (3 * x) + 1;
                stepsOdd++;
            }
            if (max < x) max = x;
            if (x == 1) worked = true; 
        }
        int stepsTotal = stepsEven + stepsOdd;
        System.out.printf("Input: %10d\nTotal Steps: %4d\nEven Steps: %5d\nOdd Steps: %6d\nMaximum: %8d\n", n, stepsTotal, stepsEven, stepsOdd, max);
    }
    
    public static void main(String[] args) {
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: Collatz 'number'");
            return;
        } catch (NumberFormatException e) {
            System.out.printf("Invalid input (max number is: %d)\n", Integer.MAX_VALUE);
            return;
        }
        if (n < 1) {
            System.out.println("Number must be greater than 1");
            return;
        }
        conjecture(n);
    }
}