//import statements
import java.util.Scanner;
import java.util.InputMismatchException;
//functions go here
class Main{
  //get name (can't be blank)
  public static String getName() {
    String name = "";
    Boolean validName = false;
    Scanner getName = new Scanner(System.in);
    while (validName != true) {      
      System.out.println("What is your name?");
      name = getName.nextLine();
      if (name != "") {
        validName = true;
      }
      else {
        System.out.println("Name cannot be blank \n");
      }
    }
    return name;
  }
  //get age (between 1 and 130)
  public static int getAge() {
    Scanner age = new Scanner(System.in);
    int inputAge = 0;
    String error = "Please enter a valid integer that is greater than 0";
    boolean valid = false;
    do {
      try {
         System.out.println("What is your age?");
         inputAge = age.nextInt();
         if(inputAge <= 0){
           System.out.println(error);
           }
         else {
           valid = true;
           }
      }
       catch (InputMismatchException e) {
         System.out.println(error);
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
  //************ Main Routine ***********
  public static void main(String[] args) {
    //set up dictionaries / lists needed to hold data
    String EXITCODE = "xxx";
    String tooYoungError = "Sorry, you are too young to view this material: \n Ticket not sold";
    String tooOldError = "Sorry, you seem to have entered an age that is unrealistic: \n Ticket not sold";
    String inputName = "";
    int MAX_TICKETS = 5;
    int count = 0;
    int inputAge = 0;
    double ticketPrice = 0;
    double userProfit = 0;
    double totalProfit = 0;
    //Ask user if they have used the program before & show instructions if necessary
    //Loop to get ticket details
    while ((count < MAX_TICKETS) & (inputName.equals(EXITCODE) == false)) {
      //get name (can't be blank)
      inputName = getName();
      //check for exit code
      if (inputName.equals(EXITCODE)) {
        continue;
      }
      //if exit code doesn't exist, get name
      else {
        inputAge = getAge();
        //check name is within valid range
        if (inputAge < 12) {
          System.out.println(tooYoungError);
        }
        else if (inputAge > 130) {
          System.out.println(tooOldError);
        }
        else {
          count ++; 
          ticketPrice = ticketPrice(inputAge);
          userProfit = ticketPrice - 5;
          totalProfit += userProfit;
          System.out.println("Name: " + inputName + "\nAge: " + inputAge + "\nTicket Price: " + ticketPrice + "\nProfit: " + userProfit + "\nOverall Profit: " + totalProfit);
          if (MAX_TICKETS - count > 1) {
            System.out.println("Remaining tickets: " + (MAX_TICKETS - count));
          }
          else {
            System.out.println("1 ticket remaining");
          }
          
        }
      }
    }
    //when extit code applied or all tickets sold, inform user of remaining tickets
    if (count == MAX_TICKETS) {
      System.out.println("All available tickets have been sold.");
    }
    else {
      System.out.println(count + " tickets sold. \n" + (MAX_TICKETS - count) + " tickets still available");
    }
    }

  //calculate ticket price

  //loop to ask for snacks

  //calculate snack price

  //ask for payment method (and apply surchanrge if needed)

  //calculate total sales and profit

  //output data to text file
}
