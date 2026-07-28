/**
 * DocumentManagementTest - Test class for Factory Method Pattern
 * Demonstrates creation and management of different document types
 */
public class DocumentManagementTest {
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("Factory Method Pattern - Document Management System");
        System.out.println("═══════════════════════════════════════════════════════\n");
        
        // Test 1: Creating documents using different factories
        System.out.println("TEST 1: Creating Different Document Types");
        System.out.println("───────────────────────────────────────────────────────\n");
        testDocumentCreation();
        
        // Test 2: Document operations
        System.out.println("\n\nTEST 2: Performing Document Operations");
        System.out.println("───────────────────────────────────────────────────────\n");
        testDocumentOperations();
        
        // Test 3: Factory method polymorphism
        System.out.println("\n\nTEST 3: Factory Polymorphism");
        System.out.println("───────────────────────────────────────────────────────\n");
        testFactoryPolymorphism();
        
        // Test 4: Document management workflow
        System.out.println("\n\nTEST 4: Complete Document Workflow");
        System.out.println("───────────────────────────────────────────────────────\n");
        testCompleteWorkflow();
    }
    
    /**
     * Test 1: Create different document types using factories
     */
    public static void testDocumentCreation() {
        // Create Word document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument("Report.docx");
        System.out.println("Document Type: " + wordDoc.getDocumentType());
        
        // Create PDF document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument("Invoice.pdf");
        System.out.println("Document Type: " + pdfDoc.getDocumentType());
        
        // Create Excel document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument("Budget.xlsx");
        System.out.println("Document Type: " + excelDoc.getDocumentType());
        
        System.out.println("\n✓ All documents created successfully");
    }
    
    /**
     * Test 2: Perform operations on documents
     */
    public static void testDocumentOperations() {
        System.out.println("--- Word Document Operations ---\n");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument("Contract.docx");
        wordDoc.open();
        wordDoc.edit("This is a contract document");
        wordDoc.save();
        wordDoc.print();
        wordDoc.close();
        
        System.out.println("\n--- PDF Document Operations ---\n");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument("Certificate.pdf");
        pdfDoc.open();
        pdfDoc.print();
        pdfDoc.close();
        
        System.out.println("\n--- Excel Document Operations ---\n");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument("Expenses.xlsx");
        excelDoc.open();
        excelDoc.edit("Q1: $1000, Q2: $1500, Q3: $1200");
        excelDoc.save();
        excelDoc.close();
    }
    
    /**
     * Test 3: Demonstrate factory polymorphism
     */
    public static void testFactoryPolymorphism() {
        // Array of different factories
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };
        
        System.out.println("Creating documents using factory polymorphism:\n");
        
        for (int i = 0; i < factories.length; i++) {
            DocumentFactory factory = factories[i];
            System.out.println("Factory: " + factory.getFactoryType());
            
            String fileName = "Document" + (i + 1);
            Document doc = factory.createDocument(fileName);
            System.out.println("Type: " + doc.getDocumentType());
            System.out.println();
        }
        
        System.out.println("✓ Polymorphism demonstrated successfully");
    }
    
    /**
     * Test 4: Complete workflow
     */
    public static void testCompleteWorkflow() {
        System.out.println("Scenario: Managing documents in a document management system\n");
        
        // Create and manage multiple documents
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        // Create reports
        System.out.println("=== Creating Project Report ===");
        Document reportDoc = wordFactory.createAndOpenDocument("ProjectReport.docx");
        reportDoc.edit("Project Status: In Progress");
        reportDoc.save();
        reportDoc.print();
        reportDoc.close();
        
        System.out.println("\n=== Creating Invoice ===");
        Document invoiceDoc = pdfFactory.createAndOpenDocument("Invoice_2024.pdf");
        invoiceDoc.print();
        invoiceDoc.close();
        
        System.out.println("\n=== Creating Budget Spreadsheet ===");
        Document budgetDoc = excelFactory.createAndOpenDocument("AnnualBudget.xlsx");
        budgetDoc.edit("Total Budget: $100,000");
        budgetDoc.save();
        budgetDoc.close();
        
        System.out.println("\n✓ Complete workflow executed successfully");
    }
}
