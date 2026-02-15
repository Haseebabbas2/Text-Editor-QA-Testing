package dal;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TFIDFCalculatorTest {
    private TFIDFCalculator calc;
    
    @BeforeEach
    public void setUp() { calc = new TFIDFCalculator(); }
    
    @Test
    @DisplayName("TF-IDF positive test")
    public void testPositive() {
        // Manual calculation verify karo
        double result = calc.calculateTFIDF("test doc", "test");
        assertTrue(result >= 0);
    }
    
    @Test
    @DisplayName("Empty document test")
    public void testEmpty() {
        double result = calc.calculateTFIDF("", "test");
        assertEquals(0.0, result);
    }
}