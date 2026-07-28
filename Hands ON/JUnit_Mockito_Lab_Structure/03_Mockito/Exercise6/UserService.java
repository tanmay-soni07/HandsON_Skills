public class UserService {

    private LoggerService loggerService;

    public UserService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void addUser(String name) {

        System.out.println("User Added : " + name);

        loggerService.log("User Added : " + name);

    }

}