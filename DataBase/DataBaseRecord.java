package DataBase;

import java.util.HashSet;

public class DataBaseRecord {
    public HashSet<StudentRecord> StudentSet = new HashSet<>();

    // Check whether the student is in the database
    public boolean HasStudent(String StudentName) {
        for (StudentRecord sr : StudentSet) {
            if (sr.StudentName.equals(StudentName))
                return true;
        }
        return false;
    }

    // Add new student's course record
    public void AddStudentCourse(String StudentName, String CourseName, double Marks) {
        if (HasStudent(StudentName)) {
            // The student is already in the database
            for (StudentRecord sr : StudentSet) {
                if (sr.StudentName.equals(StudentName)) {
                    sr.AddCourse(CourseName, Marks);
                    break;
                }
            }
        } else {
            // The student is not in the database
            StudentRecord sr = new StudentRecord(StudentName);
            sr.AddCourse(CourseName, Marks);
            StudentSet.add(sr);
        }
    }
}

