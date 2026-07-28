/**
 * WordDocument - Concrete implementation of Document interface
 * Represents a Word document (.docx)
 */
public class WordDocument implements Document {
    
    private String fileName;
    private boolean isOpen;
    
    /**
     * Constructor for WordDocument
     * @param fileName the name of the word document
     */
    public WordDocument(String fileName) {
        this.fileName = fileName;
        this.isOpen = false;
    }
    
    @Override
    public void open() {
        isOpen = true;
        System.out.println("[WORD] Opening Word document: " + fileName);
        System.out.println("[WORD] Document loaded in Microsoft Word");
    }
    
    @Override
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("[WORD] Closing Word document: " + fileName);
        } else {
            System.out.println("[WORD] Document is already closed");
        }
    }
    
    @Override
    public void save() {
        if (isOpen) {
            System.out.println("[WORD] Saving Word document: " + fileName);
            System.out.println("[WORD] Document saved successfully");
        } else {
            System.out.println("[WORD] Cannot save closed document");
        }
    }
    
    @Override
    public String getDocumentType() {
        return "Word Document (.docx)";
    }
    
    @Override
    public void print() {
        if (isOpen) {
            System.out.println("[WORD] Printing Word document: " + fileName);
            System.out.println("[WORD] Sending to printer...");
        } else {
            System.out.println("[WORD] Cannot print closed document");
        }
    }
    
    @Override
    public void edit(String content) {
        if (isOpen) {
            System.out.println("[WORD] Editing Word document");
            System.out.println("[WORD] Content: " + content);
        } else {
            System.out.println("[WORD] Cannot edit closed document");
        }
    }
}
