package Etraveli.RentalInfo.Logic;


import java.util.HashMap;
import java.util.Objects;

import Etraveli.RentalInfo.Model.*;


public class RentalInfo {
  /**
   * This is where the rental statement is calculated and returned.
   * @param customer is the customer object.
   * @return the amount due and the frequent enter points.
   */
  public String statement(Customer customer) {

    HashMap<String, Movie> movies = createMoviesList();
    double totalAmount = 0;
    double cost;

    int frequentEnterPoints = 0;
    StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");
    for (MovieRental r : customer.getRentals()) {

      // determine amount for each movie
      cost = getMovieCost(r, movies.get(r.getMovieId()) );
      totalAmount += cost;

      //add frequent bonus points
      frequentEnterPoints++;
      // add bonus for a two day new release rental
      if(hasBonus(movies.get(r.getMovieId()).getCode(), r.getDays()))
        frequentEnterPoints++;

      //print figures for this rental
      result.append("\t").append(movies.get(r.getMovieId()).getTitle()).append("\t").append(cost).append("\n");
    }
    // add footer lines
    result.append("Amount owed is ").append(totalAmount).append("\n");
    result.append("You earned ").append(frequentEnterPoints).append(" frequent points\n");

    return result.toString();
  }

  /**
   * Creates a list of movies
   * @return List of movies.
   */
  private HashMap <String, Movie> createMoviesList() {
    HashMap<String, Movie> customerMovies = new HashMap<>();
    customerMovies.put("F001", new Movie("You've Got Mail", "regular"));
    customerMovies.put("F002", new Movie("Matrix", "regular"));
    customerMovies.put("F003", new Movie("Cars", "childrens"));
    customerMovies.put("F004", new Movie("Fast & Furious X", "new"));
    return customerMovies;
  }

  /**
   * Calculates rental cost
   * @param r  movie rental object.
   * @param m  movie object.
   * @return  Rental cost.
   */
  private double getMovieCost(MovieRental r, Movie m)
  {
    double movieCost = 0.0;
    // determine amount for each movie
    if (m.getCode().equals("regular")) {
      movieCost = 2;
      if (r.getDays() > 2) {
        movieCost = ((r.getDays() - 2) * 1.5) + movieCost;
      }
    }
    if (m.getCode().equals("new")) {
      movieCost = r.getDays() * 3;
    }
    if (m.getCode().equals("childrens")) {
      movieCost = 1.5;
      if (r.getDays() > 3) {
        movieCost = ((r.getDays() - 3) * 1.5) + movieCost;
      }
    }
    return movieCost;
  }

  /**
   * Determins if the customer has earned bonus.
   * @param code  movie code.
   * @param days  number of rental days.
   * @return  True if the customer has earned a bonus otherwise false.
   */
  private boolean hasBonus(String code, int days){
    return code.equals("new") && days > 2;
  }
}
