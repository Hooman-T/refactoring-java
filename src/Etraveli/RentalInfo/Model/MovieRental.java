package Etraveli.RentalInfo.Model;

public class MovieRental {
    private String movieId;
    private int days;

    /**
     * Movie rentals data model.
     * @param movieId movie id (string).
     * @param days number of rental days (int).
     */
    public MovieRental(String movieId, int days) {
        this.movieId = movieId;
        this.days = days;
    }

    /**
     *
     * @return movie id.
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     *
     * @return  rental days.
     */
    public int getDays() {
        return days;
    }
}
