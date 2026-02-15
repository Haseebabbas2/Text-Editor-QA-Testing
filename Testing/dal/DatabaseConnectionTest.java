package dal;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;

public class DatabaseConnectionTest {
    
    @Test
    @DisplayName("Test Singleton returns same instance")
    public void testSingletonInstance() {
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();
        
        assertNotNull(instance1);
        assertNotNull(instance2);
        assertSame(instance1, instance2, "Should return same instance");
    }
    
    @Test
    @DisplayName("Test connection is established")
    public void testConnectionEstablished() {
        DatabaseConnection dbConn = DatabaseConnection.getInstance();
        Connection conn = dbConn.getConnection();
        assertNotNull(conn, "Connection should not be null");
    }
}