import  java.util.*;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "[" + taskId + "] " + taskName + " - " + status;
    }
}


class TaskList {
    Task head;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
            return;
        }
        Task temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newTask;
    }

    public Task searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void showTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task deleted.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList taskList = new TaskList();
        System.out.println("\n========= Task Management Menu =========");
        System.out.println("1. Add Task");
        System.out.println("2. Search Task");
        System.out.println("3. Show All Tasks");
        System.out.println("4. Delete Task");
        System.out.println("0. Exit");

        while (true) {

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Task Status (Pending/Done): ");
                    String status = sc.nextLine();
                    taskList.addTask(id, name, status);
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    Task found = taskList.searchTask(searchId);
                    System.out.println(found != null ? found : "Task not found.");
                    break;

                case 3:
                    taskList.showTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int delId = sc.nextInt();
                    taskList.deleteTask(delId);
                    break;

                case 0:
                    System.out.println("Exiting Task Manager.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
