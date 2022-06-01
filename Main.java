//import statements
import java.util.Scanner;
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
        System.out.println("Name cannot be blank");
        System.out.println();
      }
    }
    return name;
  } 
  //************ Main Routine ***********
  public static void main(String[] args) {
    //set up dictionaries / lists needed to hold data
    String EXITCODE = "xxx";
    String inputName = "";
    int count = 0;
    int MAX_TICKETS = 5;
    //Ask user if they have used the program before & show instructions if necessary
    //Loop to get ticket details
    while ((count < MAX_TICKETS) & (inputName.equals(EXITCODE) == false)){
      if (MAX_TICKETS - count > 1) {
        System.out.println("Remaining tickets: " + (MAX_TICKETS - count));
      }
      else {
        System.out.println("1 ticket remaining");
      }
      //get name (can't be blank)
      inputName = getName();
      count ++;     
      }
    if (count == MAX_TICKETS) {
      System.out.println("All available tickets have been sold.");
    }
    else {
      count --;
      System.out.println(count + " tickets sold. \n" + (MAX_TICKETS - count) + " tickets still available");
    }
    }
  //get age (between 1 and 130)

  //calculate ticket price

  //loop to ask for snacks

  //calculate snack price

  //ask for payment method (and apply surchanrge if needed)

  //calculate total sales and profit

  //output data to text file
}
