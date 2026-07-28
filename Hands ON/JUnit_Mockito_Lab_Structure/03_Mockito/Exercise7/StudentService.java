public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public String getStudent(int id) {

        return repository.findStudent(id);

    }

}