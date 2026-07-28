/**
 * PdfDocument - Concrete implementation of Document interface
 * Represents a PDF document (.pdf)
 */
public class PdfDocument implements Document {
    
    private String fileName;
    private boolean isOpen;
    
    /**
     * Constructor for PdfDocument
     * @param fileName the name of the PDF document
     */
    public PdfDocument(String fileName) {
        this.fileName = fileName;
        this.isOpen = false;
    }
    
    @Override
    public void open() {
        isOpen = true;
        System.out.println("[PDF] Opening PDF document: " + fileName);
        System.out.println("[PDF] Document loaded in PDF Reader");
    }
    
    @Override
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("[PDF] Closing PDF document: " + fileName);
        } else {
            System.out.println("[PDF] Document is already closed");
        }
    }
    
    @Override
    public void save() {
        if (isOpen) {
            System.out.println("[PDF] Saving PDF document: " + fileName);
            System.out.println("[PDF] Document saved successfully");
        } else {
            System.out.println("[PDF] Cannot save closed document");
        }
    }
    
    @Override
    public String getDocumentType() {
        return "PDF Document (.pdf)";
    }
    
    @Override
    public void print() {
        if (isOpen) {
            System.out.println("[PDF] Printing PDF document: " + fileName);
            System.out.println("[PDF] Sending to printer...");
        } else {
            System.out.println("[PDF] Cannot print closed document");
        }
    }
    
    @Override
    public void edit(String content) {
        if (isOpen) {
            System.out.println("[PDF] PDFs have limited editing capabilities");
            System.out.println("[PDF] Note: " + content);
        } else {
            System.out.println("[PDF] Cannot edit closed document");
        }
    }
}
