public class ExamSchedule {
    private ExamNode head;
    private ExamNode current;

    public ExamSchedule() {
        this.head = null;
        this.current = null;
    }


    public void addExam(String examDetails) {
        // TODO 2: Implement logic to add an exam to the end of the linked list
        ExamNode newNode = new ExamNode(examDetails);
        if (head == null) {
            head = newNode;
            current = head;
        }
        else {
            // Traverse to the end of the list
            ExamNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            // Add the new node at the end
            temp.next = newNode;
        }
        System.out.printf("Exam added: %s\n", examDetails);
    }


    public void viewNextExam() {
        if (current == null) {
            System.out.println("No exams available.");
        } else {
            // TODO 3: Implement the logic to move to the next exam in the list and displays it
            System.out.println("Next Exam: " + current.examDetails);

            // Move to the next exam if available
            if (current.next != null) {
                current = current.next;
            } else {
                System.out.println("You have reached the last exam.");
            }
        }
    }


    public void viewPreviousExam() {
        if (current == null) {
            System.out.println("No exams available.");
        } else {
            // TODO 4: Implement logic to move to the previous exam in the list and display it
            if (current == head) {
                System.out.println("Previous Exam: " + current.examDetails);
                //System.out.println("You have reached the first exam.");
            } else {
                // Traverse from head to find the previous node
                ExamNode temp = head;
                while (temp != null && temp.next != current) {
                    temp = temp.next;
                }

                if (temp != null) {
                    current = temp;
                    System.out.println("Previous Exam: " + current.examDetails);
                }
            }
        }
    }

    public void viewAllExamSchedule() {
        ExamNode temp = head;
        if (temp == null) {
            System.out.println("No exams scheduled.");
        } else {
            System.out.println("Exam Schedule:");
            while (temp != null) {
                System.out.println(temp.examDetails);
                temp = temp.next;
            }
        }
    }
}


