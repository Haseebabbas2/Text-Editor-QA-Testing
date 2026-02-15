package dal;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HashCalculatorTest {
    
    @Test
    @DisplayName("Hash calculation returns non-null value")
    public void testHashNotNull() throws Exception {
        String hash = HashCalculator.calculateHash("test");
        assertNotNull(hash, "Hash should not be null");
    }
    
    @Test
    @DisplayName("MD5 hash has correct length (32 characters)")
    public void testHashLength() throws Exception {
        String hash = HashCalculator.calculateHash("test");
        assertEquals(32, hash.length(), "MD5 hash should be 32 characters");
    }
    
    @Test
    @DisplayName("MD5 hash contains only hex characters")
    public void testHashFormat() throws Exception {
        String hash = HashCalculator.calculateHash("test");
        assertTrue(hash.matches("[A-F0-9]{32}"), "Hash should contain only uppercase hex characters");
    }
    
    @Test
    @DisplayName("Same input produces same hash")
    public void testConsistency() throws Exception {
        String hash1 = HashCalculator.calculateHash("test");
        String hash2 = HashCalculator.calculateHash("test");
        assertEquals(hash1, hash2, "Same input should produce same hash");
    }
    
    @Test
    @DisplayName("Different inputs produce different hashes")
    public void testUniqueness() throws Exception {
        String hash1 = HashCalculator.calculateHash("test1");
        String hash2 = HashCalculator.calculateHash("test2");
        assertNotEquals(hash1, hash2, "Different inputs should produce different hashes");
    }
    
    @Test
    @DisplayName("Empty string produces valid hash")
    public void testEmptyString() throws Exception {
        String hash = HashCalculator.calculateHash("");
        assertNotNull(hash);
        assertEquals(32, hash.length());
    }
}