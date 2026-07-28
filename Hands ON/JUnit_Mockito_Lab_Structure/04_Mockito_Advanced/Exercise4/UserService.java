public class UserService {

    private AuditService auditService;

    public UserService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void createUser(String name) {

        System.out.println("User Created : " + name);

        auditService.log("Created User : " + name);

    }

}