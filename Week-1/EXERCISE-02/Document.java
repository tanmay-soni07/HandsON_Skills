/**
 * Document interface - defines contract for all document types
 * Used in Factory Method Pattern
 */
public interface Document {
    
    /**
     * Opens the document
     */
    void open();
    
    /**
     * Closes the document
     */
    void close();
    
    /**
     * Saves the document
     */
    void save();
    
    /**
     * Gets document type
     * @return the type of document
     */
    String getDocumentType();
    
    /**
     * Prints the document
     */
    void print();
    
    /**
     * Edits the document
     * @param content the content to edit
     */
    void edit(String content);
}
