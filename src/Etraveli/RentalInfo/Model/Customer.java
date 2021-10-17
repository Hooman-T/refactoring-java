package Etraveli.RentalInfo.Model;

import java.util.List;

/**
 * Customer data model.
 */
public class Customer {
    private String name;
    private List<MovieRental> rentals;
    /**
     @param name  customer name.
     @param rentals  List of movieRentals.
     */
    public Customer(String name, List<MovieRental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    /**
     *
     * @return customer name.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return List of customers movie rentals (List<MovieREntals>)
     */
    public List<MovieRental> getRentals() {
        return rentals;
    }
}
