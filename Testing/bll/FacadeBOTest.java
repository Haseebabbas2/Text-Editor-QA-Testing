package bll;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import bll.IEditorBO;

public class FacadeBOTest {
    
    private FacadeBO facadeBO;
    private IEditorBO mockEditor;
    
    @BeforeEach
    public void setUp() {
        mockEditor = Mockito.mock(IEditorBO.class);
        facadeBO = new FacadeBO(mockEditor);
    }
    
    @Test
    @DisplayName("FacadeBO initialization")
    public void testFacadeBOInit() {
        assertNotNull(facadeBO, "FacadeBO should be initialized");
    }
    
    @Test
    @DisplayName("FacadeBO with mock editor")
    public void testWithMockEditor() {
        FacadeBO facade = new FacadeBO(mockEditor);
        assertNotNull(facade);
    }
}