package pl;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import bll.IEditorBO;

public class FileImporterTest {
    
    private FileImporter importer;
    private IEditorBO mockEditor;
    
    @BeforeEach
    public void setUp() {
        mockEditor = Mockito.mock(IEditorBO.class);
        importer = new FileImporter(mockEditor);
    }
    
    @Test
    @DisplayName("FileImporter initialization with mock")
    public void testFileImporterInit() {
        assertNotNull(importer, "FileImporter should be initialized");
    }
    
    @Test
    @DisplayName("FileImporter with mock editor")
    public void testWithMockEditor() {
        FileImporter fi = new FileImporter(mockEditor);
        assertNotNull(fi);
    }
}