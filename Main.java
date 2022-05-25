//import statements
import java.util.Scanner;
//functions go here
class Main{
  public static String notBlank(String name) {
    System.out.println("Hello!");
    return name;
  }
    
  //************ Main Routine ***********
  static void main() {
    Scanner getName = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = getName.nextLine();
    notBlank(name);
  }
  //set up dictionaries / lists needed to hold data

  //Ask user if they have used the program before & show instructions if necessary

  //Loop to get ticket details

  //get name (can't be blank)

  //get age (between 1 and 130)

  //calculate ticket price

  //loop to ask for snacks

  //calculate snack price

  //ask for payment method (and apply surchanrge if needed)

  //calculate total sales and profit

  //output data to text file
}
