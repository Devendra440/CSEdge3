import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private Map<String, String> users;

    public Authentication() {
        users = new HashMap<>();
    }

    // Register a new user
    public void register(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    // Login user
    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}
