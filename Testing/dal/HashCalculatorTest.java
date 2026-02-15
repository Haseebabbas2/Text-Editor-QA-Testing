package dal;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HashCalculatorTest {
    private HashCalculator hashCalc;
    
    @BeforeEach
    public void setUp() { hashCalc = new HashCalculator(); }
    
    @Test
    @DisplayName("MD5 hash format test")
    public void testMD5Format() {
        String hash = hashCalc.calculateMD5("test");
        assertNotNull(hash);
        assertEquals(32, hash.length());
        assertTrue(hash.matches("[a-f0-9]{32}"));
    }
    
    @Test
    @DisplayName("Same input same hash")
    public void testConsistency() {
        String hash1 = hashCalc.calculateMD5("test");
        String hash2 = hashCalc.calculateMD5("test");
        assertEquals(hash1, hash2);
    }
}