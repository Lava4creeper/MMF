//import statements
import java.util.Scanner;
import java.util.InputMismatchException;
//functions go here
class Main{
  //get name (can't be blank)
  public static String getName(String EXITCODE) {
    String name = "";
    Boolean validName = false;
    Scanner getName = new Scanner(System.in);
    while ((validName != true) & (name.equals(EXITCODE) == false)) {      
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
//get age (between 1 and 130)
  public static int getAge() {
    Scanner age = new Scanner(System.in);
    String error = "Please enter a valid integer between 12 and 130";
    boolean valid = false;
    int inputAge = 0;
    do {
      try {
         System.out.println("What is your age?");
         inputAge = age.nextInt();
         if(inputAge < 12 || inputAge > 130){
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
  //************ Main Routine ***********
  public static void main(String[] args) {
    //set up dictionaries / lists needed to hold data
    String EXITCODE = "xxx";
    String inputName = "";
    int count = 0;
    int MAX_TICKETS = 5;
    int inputAge = 0;
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
      inputName = getName(EXITCODE);
      inputAge = getAge();
      System.out.println("Your name is " + inputName + ", you are " + inputAge + " years old");
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

  //calculate ticket price

  //loop to ask for snacks

  //calculate snack price

  //ask for payment method (and apply surchanrge if needed)

  //calculate total sales and profit

  //output data to text file
}
