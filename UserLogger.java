package com.test;

import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

public class UserLogger {
    private static final Logger log = Logger.getLogger(UserLogger.class.getName());
    
    // Repository hum dummy le rahe hain testing ke liye
    private Object userRepository; 

    public void auditUserOperations(List<String> userIds) {
        
        // ISSUE 1: SELECT * (Performance killer)
        String query = "SELECT * FROM users WHERE status = 'ACTIVE'";
        
        // ISSUE 2: N+1 Query Problem (Loop ke andar DB call)
        // Ye aapke scanner ko "Critical Performance" trigger karega
        for (String id : userIds) {
            // Maan lo ye database se har baar ek user fetch kar raha hai loop ke andar
            Object user = userRepository.findById(id); 
            log.info("Checking user: " + id);
        }

        // ISSUE 3: Sensitive data in logs (Security Risk)
        String email = "test@example.com";
        String phoneNumber = "9876543210";
        log.info("Processing user with email: " + email + " and phone: " + phoneNumber);

        // ISSUE 4: Empty Catch Block (Code Quality Audit)
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            // Khali chhod diya - isse error dhoondna mushkil hota hai
        }

        // ISSUE 5: Thread.sleep (Performance/Scaling Issue)
        try {
            Thread.sleep(1000); // System ko faltu mein wait karwa raha hai
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
