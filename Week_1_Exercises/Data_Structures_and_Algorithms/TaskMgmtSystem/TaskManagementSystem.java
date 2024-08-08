package Data_Structures_and_Algorithms.TaskMgmtSystem;

public class TaskManagementSystem {

    static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "taskId=" + taskId +
                    ", taskName='" + taskName + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        private Node head;

        public SinglyLinkedList() {
            this.head = null;
        }

        // Add a task to the end of the list
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Search for a task by ID
        public Task searchTaskById(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        // Traverse and display all tasks
        public void traverseTasks() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        // Delete a task by ID
        public void deleteTaskById(int taskId) {
            if (head == null) {
                System.out.println("Task list is empty.");
                return;
            }

            if (head.task.getTaskId() == taskId) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null && current.next.task.getTaskId() != taskId) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Task not found.");
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        // Add tasks
        taskList.addTask(new Task(1, "Task A", "Incomplete"));
        taskList.addTask(new Task(2, "Task B", "Complete"));
        taskList.addTask(new Task(3, "Task C", "Incomplete"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search for a task
        System.out.println("\nSearching for task with ID 2:");
        Task task = taskList.searchTaskById(2);
        System.out.println(task != null ? task : "Task not found.");

        // Delete a task
        System.out.println("\nDeleting task with ID 1:");
        taskList.deleteTaskById(1);
        System.out.println("All Tasks after deletion:");
        taskList.traverseTasks();
    }
}
