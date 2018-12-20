import DataBase.*;

public class CheckStudent {
    public static void main(String[] args) {
        String StudentName = args[0];
        DataBaseRecord DB = new DataBaseRecord();
        FileOperation fo = new FileOperation();
        fo.DefaultInit(DB);
        if (DB.HasStudent(StudentName)) {
            for (StudentRecord sr : DB.StudentSet) {
                if (sr.StudentName.equals(StudentName)) {
                    double total = 0;
                    int count = 0;
                    double average;
                    System.out.println("Student's name: " + StudentName);
                    for (CourseRecord cr : sr.CourseSet) {
                        System.out.println(cr.CourseName + ": " + cr.Marks);
                        total += cr.Marks;
                        count++;
                    }
                    average = total / count;
                    System.out.println("Total marks: " + total);
                    System.out.println("Average marks: " + average);
                    break;
                }
            }
        } else {
            System.out.println("There is no student called " + StudentName);
        }
        fo.InfoSave(DB);
    }
}
