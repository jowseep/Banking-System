import java.util.Scanner;

class bankingSystem {

    static String currency = "PHP";

   public static void main(String[] args) {

    String name;
    double balance;
    int selection;
    
    Scanner input = new Scanner(System.in);


    System.out.print("Enter your name: ");
    name = input.nextLine();
    System.out.print("Enter initial balance: ");
    balance = input.nextDouble();


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
            balance = convertFunds(balance);
            currency = theCurrency(balance);
                /*if(balance % 0.019 == 0)
                    currency = "USD";
                else if(balance % 0.018 == 0)
                    currency = "EUR"; */
        
            break;
            case 5:
            System.exit(0);
        }
        
    } 

}


   public static void displayInfo(String name, double balance, String currency) {
       System.out.println("\n");
       System.out.print("Name: " + name + " | Balance: " + currency + balance );
   }

   public static double addFunds(double initialAmount) {
        Scanner input = new Scanner(System.in);
        int amountAdd;
        System.out.println("\n");
        System.out.print("Enter amount to deposit: ");
        amountAdd = input.nextInt();
        
        if(amountAdd<=0 || amountAdd<500) {
            System.out.println("We only accept 500 and above. Please try again. ");
        } else {
            System.out.println(amountAdd + " is added to your account");
            initialAmount += amountAdd;
        } 
        
        return initialAmount;
   }

   public static double withdrawFunds(double initialAmount) {

        Scanner input = new Scanner(System.in);

        System.out.println("\n");
        System.out.print("Enter amount to withdraw: ");
        int withdraw = input.nextInt();
        
        if(withdraw<=0 || withdraw<500) {
            System.out.println("We only dispense 500 and above. Please try again.");
        } else if(withdraw>initialAmount) {
            System.out.println("Desired amount should not exceed the current balance.");
        } else {
            System.out.println(withdraw + " has been withdrawn successfully.");
            initialAmount -= withdraw;
        }
        return initialAmount;

   }

   public static double convertFunds(double balance) {

        Scanner input = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Select currency: ");
        System.out.println("1 - USD");
        System.out.println("2 - EUR");
        System.out.println("\n");
        System.out.print("Selection: ");
        int selection = input.nextInt();

        if(selection == 1) {
            balance *= 0.019;
            System.out.println("Sucessfully converted to USD. Total dollars on the account is " + balance);
        } else if (selection == 2) {
            balance *= 0.018;
            System.out.println("Sucessfully converted to EUR. Total euros on the account is " + balance);
        }
        return balance;
    }

    public static String theCurrency(double balance) {

        String currentCurrency = "PHP";
        if(balance % 0.019 == 0) {
            currentCurrency = "USD";
        } else if(balance % 0.018 == 0) {
            currentCurrency = "EUR";
        } 
        return currentCurrency;
    }

}