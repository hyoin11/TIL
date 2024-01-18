package Algorithm;

public class Prime {
    public static void main(String[] args) {
        int number = 17;
        int number2 = 16;

        System.out.println(number + " is prime ? " + isPrime(number));
        System.out.println(number2 + " is prime ? " + isPrime(number2));
    }

    private static Boolean isPrime(int number) {
        Boolean isPrime = true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
