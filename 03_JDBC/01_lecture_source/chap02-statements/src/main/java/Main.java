

public class Main {
    public static int s = 10;

    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int result1 = a + b + Main.s;
        System.out.println("result1 = " + result1);

        Counter sub = new Counter();

        int result2 = sub.plus(a);
        System.out.println("result2 = " + result2);

        int result3 = multiply(a, b);
        System.out.println("result3 = " + result3);
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }
}

