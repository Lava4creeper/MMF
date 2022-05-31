//import statements
import java.util.Scanner;
//functions go here
class Main{
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
    String inputName = "";
    int count = 0;
    int MAX_TICKETS = 5;
    while ((inputName != "xxx") & (count != MAX_TICKETS)){
    inputName = getName();
      count ++;
      }
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
