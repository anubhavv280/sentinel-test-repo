import java.util.logging.Logger;

public class UserLogger {
    private static final Logger log = Logger.getLogger(UserLogger.class.getName());

    public void logUserData(String email, String phoneNumber) {
        // Check 3: Sensitive data in logs (LOGGING AUDIT ISSUE)
        log.info("Processing user with email: " + email + " and phone: " + phoneNumber);
    }
}
