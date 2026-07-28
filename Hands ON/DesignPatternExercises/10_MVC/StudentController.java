class StudentController{

    Student model;
    StudentView view;

    StudentController(Student m,StudentView v){

        model=m;
        view=v;
    }

    void updateName(String n){
        model.name=n;
    }

    void show(){
        view.display(model);
    }
}