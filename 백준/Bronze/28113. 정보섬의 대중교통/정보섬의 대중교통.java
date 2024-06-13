import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int chansol = sc.nextInt();
        int bus = sc.nextInt();
        int subway = sc.nextInt();

        if (bus < subway) {
            System.out.println("Bus");

        } else if (bus > subway) {
            System.out.println("Subway");

        } else {
            System.out.println("Anything");
        }
    }
}
