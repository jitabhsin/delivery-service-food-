import java.util.Scanner;

public class Jasfooddelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char continueShopping;
        double balance = 10000.0;
        double discountRate = 0.10;
        boolean isPrimeMember = false;

        do {
            System.out.println("Welcome to Jasfooddelivery");
            System.out.println();
            System.out.println("Please choose from the options below:");
            System.out.println("1. Order Food Items");
            System.out.println("2. Check Prime Membership");
            System.out.println("3. Become Prime Member");
            System.out.println("4. Exit");
            int option = sc.nextInt();
            
            switch (option) {
                case 1:
                    System.out.println("Food Menu:");
                    System.out.println("1. Pizza - ₹500");
                    System.out.println("2. Burger - ₹300");
                    System.out.println("3. Biryani - ₹400");
                    System.out.println("4. Paneer Tikka - ₹350");
                    
                    double totalAmount = 0;
                    char addMore = 'y';
                    do {
                        System.out.println("Select a food item to order (enter 0 to finish):");
                        int foodItem = sc.nextInt();
                        double foodPrice = 0;
                        switch (foodItem) {
                            case 1:
                                foodPrice = 500;
                                break;
                            case 2:
                                foodPrice = 300;
                                break;
                            case 3:
                                foodPrice = 400;
                                break;
                            case 4:
                                foodPrice = 350;
                                break;
                            case 0:
                                addMore = 'n';
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                continue;
                        }
                        if (foodItem != 0) {
                            totalAmount += foodPrice;
                            System.out.println("Do you want to add more items? (y/n)");
                            addMore = sc.next().charAt(0);
                        }
                    } while (addMore == 'y');

                    System.out.println("Are you a Prime Member? (true/false)");
                    isPrimeMember = sc.nextBoolean();

                    if (isPrimeMember) {
                        totalAmount = totalAmount - (totalAmount * discountRate);
                        System.out.println("Prime member discount applied!");
                    }

                    balance -= totalAmount;
                    System.out.println("Total Amount: ₹" + totalAmount);
                    System.out.println("Current balance: ₹" + balance);
                    break;

                case 2:
                    System.out.println("Prime Membership Status: " + (isPrimeMember ? "Active" : "Not Active"));
                    break;

                case 3:
                    if (!isPrimeMember) {
                        System.out.println("Become a Prime Member for ₹1000/year");
                        System.out.println("Proceed with payment? (y/n)");
                        char paymentChoice = sc.next().charAt(0);
                        if (paymentChoice == 'y') {
                            balance -= 1000;
                            isPrimeMember = true;
                            System.out.println("Prime Membership activated!");
                        }
                    } else {
                        System.out.println("You are already a Prime Member.");
                    }
                    break;

                case 4:
                    System.out.println("Thanks for visiting Jasfooddelivery!");
                    continueShopping = 'n';
                    continue;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            if (option != 4) {
                System.out.println("Do you want to proceed with payment? (y/n)");
                char paymentChoice = sc.next().charAt(0);
                if (paymentChoice == 'y') {
                    System.out.println("Select Payment Method:");
                    System.out.println("1. Credit");
                    System.out.println("2. UPI");
                    System.out.println("3. Cash on Delivery (COD)");
                    int paymentMethod = sc.nextInt();

                    switch (paymentMethod) {
                        case 1:
                            System.out.println("Payment successful using Credit!");
                            break;
                        case 2:
                            System.out.println("Payment successful using UPI!");
                            break;
                        case 3:
                            System.out.println("Payment will be collected upon delivery (COD)!");
                            break;
                        default:
                            System.out.println("Invalid payment method. Please try again.");
                            break;
                    }
                }
            }
            
            if (option != 4) {
                System.out.println("Do you want to continue? (y/n)");
                continueShopping = sc.next().charAt(0);
            } else {
                continueShopping = 'n';
            }
        } while (continueShopping == 'y');

        sc.close();
    }
}
