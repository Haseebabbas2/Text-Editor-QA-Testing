package dal;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TFIDFCalculatorTest {
    private TFIDFCalculator calc;
    
    @BeforeEach
    public void setUp() {
        calc = new TFIDFCalculator();
        // Add documents to corpus for IDF calculation
        calc.addDocumentToCorpus("This is a test document with some words");
        calc.addDocumentToCorpus("Another test document here with different content");
        calc.addDocumentToCorpus("Third document for testing purposes");
    }
    
    @Test
    @DisplayName("TF-IDF calculation returns a valid numeric value")
    public void testValidTFIDF() {
        double result = calc.calculateDocumentTfIdf("test document with words");
        assertFalse(Double.isNaN(result), "TF-IDF should not be NaN");
        assertFalse(Double.isInfinite(result), "TF-IDF should not be infinite");
    }
    
    @Test
    @DisplayName("TF-IDF calculation is consistent for same input")
    public void testConsistency() {
        String testDoc = "test document";
        double result1 = calc.calculateDocumentTfIdf(testDoc);
        double result2 = calc.calculateDocumentTfIdf(testDoc);
        assertEquals(result1, result2, 0.0001, "Same input should produce same TF-IDF");
    }
    
    @Test
    @DisplayName("Document with single word returns valid TF-IDF")
    public void testSingleWord() {
        double result = calc.calculateDocumentTfIdf("word");
        assertFalse(Double.isNaN(result), "Single word should produce valid TF-IDF");
    }
    
    @Test
    @DisplayName("Corpus size affects IDF calculation")
    public void testCorpusSize() {
        TFIDFCalculator newCalc = new TFIDFCalculator();
        newCalc.addDocumentToCorpus("document one");
        double score1 = newCalc.calculateDocumentTfIdf("test");
        
        newCalc.addDocumentToCorpus("document two");
        double score2 = newCalc.calculateDocumentTfIdf("test");
        
        // IDF should change with corpus size
        assertNotEquals(score1, score2, "Corpus size should affect TF-IDF");
    }
}