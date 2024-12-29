package hus.oop.mystudentmanager;

import java.util.ArrayList;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        /* TODO */
       studentList = new MyLinkedList();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        /* TODO */
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.insertAtEnd(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        studentList.insertAtPosition(student, index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        /* TODO */
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).equals(student)) {
                studentList.remove(i);
            }
        }
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return  (Student) studentList.get(index);
    }

    /**
     * Lọc ra những sinh viên có điểm trung bình trên 15 điểm.
     * @return
     */
    public MyList filterStudentsByAverageGrade() {
        /* TODO */
        // khởi tạo danh sách lưu các sinh viên có avg trên 15 điểm
        MyList myList = new MyLinkedList();
        for (int i = 0; i < getStudentList().size(); i++) {
            if (studentAt(i).getAverageGrade() > 15) {
                myList.insertAtEnd(studentAt(i));
            }
        }
        return myList;
    }

    /**
     * Lọc ra những sinh viên có điểm toán trên 5 điểm.
     * @return
     */
    public MyList filterStudentsByMathGrade() {
        /* TODO */
        // khởi tạo danh sách lưu các sinh viên có avg trên 5 điểm
        MyList myList = new MyLinkedList();
        for (int i = 0; i < getStudentList().size(); i++) {
            if (studentAt(i).getMathsGrade() > 5) {
                myList.insertAtEnd(studentAt(i));
            }
        }
        return myList;
    }
}
