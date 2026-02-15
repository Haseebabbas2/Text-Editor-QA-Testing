package dal;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dto.Pages;
import java.util.List;

public class PaginationDAOTest {
    
    @Test
    @DisplayName("Empty content returns single page with empty content")
    public void testEmptyContent() {
        List<Pages> pages = PaginationDAO.paginate("");
        assertNotNull(pages);
        assertEquals(1, pages.size());
        assertEquals(1, pages.get(0).getPageNumber());
    }
    
    @Test
    @DisplayName("Null content returns single page")
    public void testNullContent() {
        List<Pages> pages = PaginationDAO.paginate(null);
        assertNotNull(pages);
        assertEquals(1, pages.size());
    }
    
    @Test
    @DisplayName("Content with exactly 100 characters creates 1 page")
    public void testExactly100Chars() {
        String content = generateContent(100);
        List<Pages> pages = PaginationDAO.paginate(content);
        assertEquals(1, pages.size());
    }
    
    @Test
    @DisplayName("Content with 101 characters creates 2 pages")
    public void testOver100Chars() {
        String content = generateContent(101);
        List<Pages> pages = PaginationDAO.paginate(content);
        assertEquals(2, pages.size());
    }
    
    @Test
    @DisplayName("Content with 200 characters creates 2 pages")
    public void test200Chars() {
        String content = generateContent(200);
        List<Pages> pages = PaginationDAO.paginate(content);
        assertEquals(2, pages.size());
    }
    
    private String generateContent(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}