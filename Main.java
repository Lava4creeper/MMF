//import statements
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
//functions go here
class Main{
  public static void clearScreen() {
    Scanner clearScreen = new Scanner(System.in);
    System.out.println("Press <enter> to continue: ");
    clearScreen.nextLine();
    System.out.print("\033[H\033[2J");
  }
  //get name (can't be blank)
  public static String getName() {
    String name = "";
    Boolean validName = false;
    Scanner getName = new Scanner(System.in);
    while (validName != true) {      
      System.out.println("What is your name?\n");
      name = getName.nextLine();
      if (name != "") {
        validName = true;
      }
      else {
        System.out.println("Error: Name cannot be blank.");
        clearScreen();
      }
    }
    return name;
  }
  //get age (between 1 and 130)
  public static int getAge() {
    Scanner age = new Scanner(System.in);
    int inputAge = 0;
    String error = "\nPlease enter a valid integer that is greater than 0";
    boolean valid = false;
    do {
      try {
         System.out.println("What is your age?\n");
         inputAge = age.nextInt();
         if(inputAge <= 0){
           System.out.println(error);
           clearScreen();
           }
         else {
           valid = true;
           }
      }
       catch (InputMismatchException e) {
         System.out.println(error);
         clearScreen();
         inputAge = 0;
         age.next();
         }
       } while (!valid);
    return inputAge;
   }
  //calculate ticket price
  public static double ticketPrice(int age) {
    double ticketPrice = 0;
    if (age < 16) {
      ticketPrice = 7.5;
    }
    else if (age < 65) {
      ticketPrice = 10.5;
    }
    else {
      ticketPrice = 6.5;
    }
    return ticketPrice;   
  }
  //check if the user wants snacks
  public static boolean wantsSnacks(String EXITCODE) {
    String error = "Sorry, you have entered an invalid answer. Please enter yes (or y) or no (or n)";
    boolean wantsSnacks = false;
    boolean validInput = false;
    String userInput = "";
    String loweredUserInput;
    Scanner yesNo = new Scanner(System.in);
    while ((userInput.equals(EXITCODE) == false)&&(validInput != true)) {
      System.out.println("Would you like to purchase snacks?");
      userInput = yesNo.nextLine();
      loweredUserInput = userInput.toLowerCase();
        if ((loweredUserInput.equals("yes"))||(loweredUserInput.equals("y"))) {
          wantsSnacks = true;
          validInput = true;
        }
        else if ((loweredUserInput.equals("no"))||(loweredUserInput.equals("n")))
          validInput = true;
        else {
          System.out.println(error);
        }
    }
    return wantsSnacks;
  }
  //Check for the snacks the user wants
  public static String
  //************ Main Routine ***********
  public static void main(String[] args) {
    System.out.print("\033[H\033[2J");
    //set up dictionaries / lists needed to hold data
    String EXITCODE = "xxx";
    String tooYoungError = "Sorry, you are too young to view this material: \nTicket not sold";
    String tooOldError = "Sorry, you seem to have entered an age that is unrealistic: \nTicket not sold";
    String inputName = "";
    int MAX_TICKETS = 5;
    int count = 0;
    int inputAge = 0;
    double ticketPrice = 0;
    double userProfit = 0;
    double totalProfit = 0;
    boolean wantsSnacks = false;

    //Ask user if they have used the program before & show instructions if necessary
    //Loop to get ticket details
    while ((count < MAX_TICKETS) & (inputName.equals(EXITCODE) == false)) {
      if (MAX_TICKETS - count > 1) {
        System.out.println("Remaining tickets: " + (MAX_TICKETS - count) + "\n");
      }
      else {
        System.out.println("1 ticket remaining\n");
      }
      //get name (can't be blank)
      inputName = getName();
      //check for exit code
      if (inputName.equals(EXITCODE)) {
        continue;
      }
      //if exit code doesn't exist, get name
      else {
        System.out.println("\nYou entered: " + inputName);
        clearScreen();
        inputAge = getAge();
        //check name is within valid range
        if (inputAge < 12) {
          System.out.println(tooYoungError);
          clearScreen();          
        }
        else if (inputAge > 130) {
          System.out.println(tooOldError);
          clearScreen();
        }  
        else {
          System.out.println("\nYou Entered: " + inputAge);
          clearScreen();
          wantsSnacks = wantsSnacks(EXITCODE);
          count ++; 
          ticketPrice = ticketPrice(inputAge);
          userProfit = ticketPrice - 5;
          totalProfit += userProfit;
          //System.out.println("Name: " + inputName + "\nAge: " + inputAge + "\nTicket Price: " + ticketPrice + "\nProfit: " + userProfit + "\nOverall Profit: " + totalProfit + "\nWants Snacks: " + wantsSnacks);
          try {
            PrintWriter outputPrinter = new PrintWriter(new FileWriter("output.txt", true));
            outputPrinter.write("Name: " + inputName);
            outputPrinter.write(", Age: " + inputAge);
            outputPrinter.write(", Charged: $" + ticketPrice);
            outputPrinter.write(", Snacks: " + wantsSnacks);
            outputPrinter.write("\n");
            outputPrinter.close();
          }
          catch (IOException e) {
            System.out.println("Error in printing to file: output.txt");
          }
          clearScreen();         
        }
      }
    }
    //when exit code applied or all tickets sold, inform user of remaining tickets
    if (count == MAX_TICKETS) {
      System.out.println("All available tickets have been sold.");
    }
    else {
      System.out.println(count + " tickets sold. \n" + (MAX_TICKETS - count) + " tickets still available");
    }
    }

}
