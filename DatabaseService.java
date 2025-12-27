public class DatabaseService {
    // Check 1: Hardcoded Password (SECURITY ISSUE)
    private String dbPassword = "root_password_123"; 
    private String apiKey = "AIzaSyB-890-test-key";

    public void connect() {
        // Check 2: Using System.out (LOGGING ISSUE)
        System.out.println("Connecting to database with pass: " + dbPassword);
    }
}
