/**
 * Abstract DocumentFactory - Base class for all document factories
 * Implements Factory Method Pattern
 */
public abstract class DocumentFactory {
    
    /**
     * Factory method - creates document
     * Must be implemented by concrete factories
     * @param fileName the name of the document
     * @return the created Document object
     */
    public abstract Document createDocument(String fileName);
    
    /**
     * Creates and opens a document
     * @param fileName the name of the document
     * @return the opened Document object
     */
    public Document createAndOpenDocument(String fileName) {
        Document document = createDocument(fileName);
        document.open();
        return document;
    }
    
    /**
     * Gets the factory type
     * @return the type of factory
     */
    public abstract String getFactoryType();
}

/**
 * WordDocumentFactory - Concrete factory for creating Word documents
 */
class WordDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument(String fileName) {
        System.out.println("[FACTORY] Creating Word document: " + fileName);
        return new WordDocument(fileName);
    }
    
    @Override
    public String getFactoryType() {
        return "Word Document Factory";
    }
}

/**
 * PdfDocumentFactory - Concrete factory for creating PDF documents
 */
class PdfDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument(String fileName) {
        System.out.println("[FACTORY] Creating PDF document: " + fileName);
        return new PdfDocument(fileName);
    }
    
    @Override
    public String getFactoryType() {
        return "PDF Document Factory";
    }
}

/**
 * ExcelDocumentFactory - Concrete factory for creating Excel documents
 */
class ExcelDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument(String fileName) {
        System.out.println("[FACTORY] Creating Excel document: " + fileName);
        return new ExcelDocument(fileName);
    }
    
    @Override
    public String getFactoryType() {
        return "Excel Document Factory";
    }
}
