package dal;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TFIDFCalculatorTest {
    
    @Test
    @DisplayName("TFIDFCalculator can be instantiated")
    public void testInstantiation() {
        TFIDFCalculator calc = new TFIDFCalculator();
        assertNotNull(calc, "Calculator should be instantiated");
    }
    
    @Test
    @DisplayName("Can add documents to corpus")
    public void testAddDocument() {
        TFIDFCalculator calc = new TFIDFCalculator();
        assertDoesNotThrow(() -> {
            calc.addDocumentToCorpus("test document");
            calc.addDocumentToCorpus("another document");
        }, "Should add documents without error");
    }
    
    @Test
    @DisplayName("Calculate TF-IDF executes without exception")
    public void testCalculationExecutes() {
        TFIDFCalculator calc = new TFIDFCalculator();
        calc.addDocumentToCorpus("hello world test");
        calc.addDocumentToCorpus("test document here");
        
        assertDoesNotThrow(() -> {
            double result = calc.calculateDocumentTfIdf("hello world");
        }, "Calculation should execute without exception");
    }
}