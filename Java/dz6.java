import java.util.ArrayList;
import java.util.List;

class Review {
    private String user;
    private String text;

    public Review(String user, String text) {
        this.user = user;
        this.text = text;
    }

}

public class ReviewSystemApp {
    private List<Review> reviews = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public List<Review> showReviews() {
        return reviews;
    }

    public List<Review> searchReviews(String keyword) {
        List<Review> searchResults = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getText().contains(keyword)) {
                searchResults.add(review);
            }
        }
        return searchResults;
    }

    public void deleteReview(Review reviewToDelete) {
        reviews.remove(reviewToDelete);
    }

    public void editReview(Review reviewToEdit, String newText) {
        reviewToEdit.setText(newText);
    }

    private class User {
        private String username;
        private String password;

    }

    public void registerUser(String username, String password) {
        users.add(new User(username, password));
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}