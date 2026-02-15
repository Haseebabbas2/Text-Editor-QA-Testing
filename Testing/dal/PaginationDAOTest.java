package dal;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PaginationDAOTest {
    private PaginationDAO pagDao;
    
    @BeforeEach
    public void setUp() { pagDao = new PaginationDAO(); }
    
    @Test
    @DisplayName("500 words exact boundary")
    public void testBoundary500() {
        String content = generateWords(500);
        int pages = pagDao.calculatePages(content, 500);
        assertEquals(1, pages);
    }
    
    @Test
    @DisplayName("501 words creates 2 pages")
    public void testOver500() {
        String content = generateWords(501);
        int pages = pagDao.calculatePages(content, 500);
        assertEquals(2, pages);
    }
    
    private String generateWords(int count) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) sb.append("word ");
        return sb.toString();
    }
}
```

Run: `mvn test`

---

### 2️⃣ WHITE-BOX ANALYSIS (CFG, Complexity)

**Method 1: SearchWord (bll/SearchWord.java file dekho)**

**Control Flow Graph:**
- Draw.io use karo: https://app.diagrams.net/
- Nodes: Entry, if checks, return statements
- Calculate: V(G) = E - N + 2P

**Example:**
```
Edges (E) = 7
Nodes (N) = 6  
P = 1
V(G) = 7 - 6 + 2(1) = 3
```

**Test Paths:**
```
P = {p1, p2, p3}
p1 = ⟨1,2,3⟩ (null path)
p2 = ⟨1,2,4,5,6⟩ (not found)
p3 = ⟨1,2,4,5,7,8⟩ (success)