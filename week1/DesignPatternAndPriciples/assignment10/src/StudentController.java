public class StudentController {
    public Student model;
    public StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model=model;
        this.view=view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }
    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(String id) {
        model.setId(id);
    }
    public String getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }
    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(getStudentName(), getStudentId(), getStudentGrade());
    }
}
