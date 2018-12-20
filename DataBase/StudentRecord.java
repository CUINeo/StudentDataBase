package DataBase;

import java.util.HashSet;

// The Data Structure of a student
public class StudentRecord {
    public String StudentName;
    public HashSet<CourseRecord> CourseSet = new HashSet<>();

    public StudentRecord(String StudentName) {
        this.StudentName = StudentName;
    }

    // Add new course record to the student's record
    public void AddCourse(String CourseName, double Marks) {
        boolean flag = false;
        for (CourseRecord cr : CourseSet) {
            if (cr.CourseName.equals(CourseName)) {
                cr.Marks = Marks;
                flag = true;
                break;
            }
        }
        if (!flag) {
            CourseRecord cr = new CourseRecord(CourseName, Marks);
            CourseSet.add(cr);
        }
    }
}
