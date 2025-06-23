public class Test {
    public static void main(String[] args) throws Exception {
        Student st1 = new Student("Jay Kumar", "1106", "B+");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(st1, view);

        controller.updateView();

        controller.setStudentName("Vijay Kumar");
        controller.setStudentGrade("A");
        controller.setStudentId("1120");

        controller.updateView();
    }
}
