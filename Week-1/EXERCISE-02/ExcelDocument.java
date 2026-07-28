/**
 * ExcelDocument - Concrete implementation of Document interface
 * Represents an Excel document (.xlsx)
 */
public class ExcelDocument implements Document {
    
    private String fileName;
    private boolean isOpen;
    
    /**
     * Constructor for ExcelDocument
     * @param fileName the name of the Excel document
     */
    public ExcelDocument(String fileName) {
        this.fileName = fileName;
        this.isOpen = false;
    }
    
    @Override
    public void open() {
        isOpen = true;
        System.out.println("[EXCEL] Opening Excel document: " + fileName);
        System.out.println("[EXCEL] Document loaded in Microsoft Excel");
    }
    
    @Override
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("[EXCEL] Closing Excel document: " + fileName);
        } else {
            System.out.println("[EXCEL] Document is already closed");
        }
    }
    
    @Override
    public void save() {
        if (isOpen) {
            System.out.println("[EXCEL] Saving Excel document: " + fileName);
            System.out.println("[EXCEL] Document saved successfully");
        } else {
            System.out.println("[EXCEL] Cannot save closed document");
        }
    }
    
    @Override
    public String getDocumentType() {
        return "Excel Document (.xlsx)";
    }
    
    @Override
    public void print() {
        if (isOpen) {
            System.out.println("[EXCEL] Printing Excel document: " + fileName);
            System.out.println("[EXCEL] Sending to printer...");
        } else {
            System.out.println("[EXCEL] Cannot print closed document");
        }
    }
    
    @Override
    public void edit(String content) {
        if (isOpen) {
            System.out.println("[EXCEL] Editing Excel spreadsheet");
            System.out.println("[EXCEL] Content: " + content);
        } else {
            System.out.println("[EXCEL] Cannot edit closed document");
        }
    }
}
