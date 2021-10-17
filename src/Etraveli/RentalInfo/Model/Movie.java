package Etraveli.RentalInfo.Model;

public class Movie {
    private String title;
    private String code;

    /**
     * Movie data model.
     * @param title movie title (string).
     * @param code  movie code (string).
     */
    public Movie(String title, String code) {

        this.title = title;
        this.code = code;
    }

    /**
     *
     * @return movie title.
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return movie code
     */
    public String getCode() {
        return code;
    }
}
