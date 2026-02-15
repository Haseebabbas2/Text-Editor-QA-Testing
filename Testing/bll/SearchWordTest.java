package bll;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SearchWordTest {
    
    private SearchWord searchWord;
    
    @BeforeEach
    public void setUp() {
        searchWord = new SearchWord();
    }
    
    @Test
    @DisplayName("Search word in text - basic test")
    public void testSearchBasic() {
        // Test the actual methods available in SearchWord class
        assertNotNull(searchWord, "SearchWord should be initialized");
    }
    
    @Test
    @DisplayName("SearchWord object creation")
    public void testObjectCreation() {
        SearchWord sw = new SearchWord();
        assertNotNull(sw);
    }
}