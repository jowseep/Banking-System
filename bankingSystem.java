import java.util.Scanner;

public class bankingSystem {

   public static void main(String[] args) {

    String name;
    String currency = "PHP";
    double balance;
    int selection;
    
    Scanner input = new Scanner(System.in);


    System.out.print("Enter your name: ");
    name = input.nextLine();
    System.out.print("Enter initial balance: ");
    balance = input.nextInt();


    while(true) {

        System.out.println("\n");
        System.out.println("What would you like to do next? ");
        System.out.println("1 - Display Information ");
        System.out.println("2 - Add Funds ");
        System.out.println("3 - Withdraw Funds ");
        System.out.println("4 - Convert Funds ");
        System.out.println("5 - Exit ");
    
        System.out.println("\n");
        System.out.print("Selection: ");
        selection = input.nextInt();

        switch(selection) {

            case 0:
            System.out.println("Invalid selection. Please try again.");
            System.exit(0);
            case 1:
            displayInfo(name,balance,currency);
            break; 
            case 2:
            balance = addFunds(balance);
            break; 
            case 3:
            balance = withdrawFunds(balance);
            break; 
            case 4:
            convertFunds(balance);
            case 5:
            System.exit(0);
        }
        

    }
}


   public static void displayInfo(String name, double balance, String currency) {
       System.out.println("\n");
       System.out.print("Name: " + name + " | Balance: " + balance + " | Currency: " + currency);
   }

   public static double addFunds(double initialAmount) {
        Scanner input = new Scanner(System.in);
        int amountAdd;
        System.out.println("\n");
        System.out.print("Enter amount to deposit: ");
        amountAdd = input.nextInt();
        
        if(amountAdd<=0 || amountAdd<500) {
            System.out.println("You're broke. We only accept 500 and above. Please try again. ");
        } else {
            System.out.println(amountAdd + " is added to your account");
        }
        return initialAmount += amountAdd;
   }

   public static double withdrawFunds(double initialAmount) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Enter amount to withdraw: ");
        int withdraw = input.nextInt();
        
        if(withdraw<=0 || withdraw<500) {
            System.out.println("You're broke. We only dispense 500 and above. Please try again. ");
        } else {
            System.out.println(withdraw + " has been withdrawn successfully");
        }
        return initialAmount -= withdraw;

   }

   public static void convertFunds(double balance) {
        double newBalance;
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Select currency: ");
        System.out.println("1 - USD");
        System.out.println("2 - EUR");
        System.out.println("\n");
        System.out.print("Selection: ");
        int selection = input.nextInt();

        if(selection == 1) {
            newBalance = balance * 0.018;
            System.out.println("Sucessfully converted to USD. Total euros on the account is " + newBalance);
        } else if (selection == 2) {
            newBalance = balance * 0.018;
            System.out.println("Sucessfully converted to EUR. Total euros on the account is " + newBalance);
        }
    }
}