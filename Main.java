//import statements
import java.util.Scanner;
//functions go here
class Main{
  public static void notBlank(String name) {
    if (name != "") {
      System.out.println("Hello " + name);
    }
    else {
      System.out.println("Name cannot be blank");
      getName();
    }
  }
  public static void getName() {
     Scanner getName = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = getName.nextLine();
    notBlank(name);
  }
    
  //************ Main Routine ***********
  public static void main(String[] args) {
    getName();
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
