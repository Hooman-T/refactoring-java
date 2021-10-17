import java.util.Arrays;
import Etraveli.RentalInfo.Logic.*;
import Etraveli.RentalInfo.Model.*;

public class Main {

  public static void main(String[] args) {
    String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

    String result = new RentalInfo().statement(createCustomer());

    if (!result.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + expected + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }
    System.out.println("Success");
  }
  private static Customer createCustomer()
  {
    return new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1)));
  }
}
