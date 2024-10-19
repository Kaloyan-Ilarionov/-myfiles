import java.util.Scanner;

public class Main {

    static String[] items = {"French Fries", "Burger", "Pastry", "Pizza", "Cold Drinks", "Coffee", "Cold Coffee", "Iced Tea"};
    static int[] prices = {5, 12, 14, 12, 2, 1, 2, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        boolean ordering = true;

        int[] orderQuantities = new int[items.length];

        System.out.println("**************** Welcome To Our Cafe ****************");

        while (ordering) {
            displayMenu();

            System.out.println("What would you like to eat?");
            int choice = sc.nextInt();

            if (choice == 9) {
                ordering = false;
                break;
            }

            if (choice >= 1 && choice <= 8) {
                System.out.println("You have selected " + items[choice - 1]);

                System.out.println("Enter the desired quantity:");
                int quantity = sc.nextInt();

                total += prices[choice - 1] * quantity;
                orderQuantities[choice - 1] += quantity;
            }

            System.out.println("Do you wish to order anything else? (y/n)");
            char orderMore = sc.next().charAt(0);

            if (orderMore == 'n' || orderMore == 'N') {
                ordering = false;
            }
        }

        displayBill(orderQuantities, total);
    }

    static void displayMenu() {
        System.out.println("*****************************************************");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + "." + items[i] + "  $" + prices[i]);
        }
        System.out.println("9. Exit");
        System.out.println("*****************************************************");
    }

    static void displayBill(int[] orderQuantities, int total) {
        System.out.println("\n************ Your Order Summary ************");
        for (int i = 0; i < items.length; i++) {
            if (orderQuantities[i] > 0) {
                System.out.println(items[i] + " x " + orderQuantities[i] + " = $" + (prices[i] * orderQuantities[i]));
            }
        }
        System.out.println("********************************************");
        System.out.println("Total Bill: $" + total);
        System.out.println("Thank you for dining with us!");
    }
}
