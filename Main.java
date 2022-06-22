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
        System.out.println("Name cannot be blank");
        System.out.println();
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
  //************ Main Routine ***********
  public static void main(String[] args) {
    //set up dictionaries / lists needed to hold data
    String EXITCODE = "xxx";
    String tooYoungError = "Sorry, you are too young to view this material";
    String tooOldError = "Sorry, you seem to have entered an age that is unrealistic";
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
      inputName = getName();
      if (inputName.equals(EXITCODE)) {
        continue;
      }
      else {
        inputAge = getAge();
        if (inputAge < 12) {
          System.out.println(tooYoungError);
        }
        else if (inputAge > 130) {
          System.out.println(tooOldError);
        }
      }
      count ++;  
      }
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
