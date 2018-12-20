import DataBase.*;

public class CheckCourse {
    public static void main(String[] args) {
        String CourseName = args[0];
        DataBaseRecord DB = new DataBaseRecord();
        FileOperation fo = new FileOperation();
        fo.DefaultInit(DB);
        System.out.println("Course's name: " + CourseName);
        double total = 0;
        int count = 0;
        double average;
        for (StudentRecord sr : DB.StudentSet) {
            for (CourseRecord cr : sr.CourseSet) {
                if (cr.CourseName.equals(CourseName)) {
                    System.out.println(sr.StudentName + ": " + cr.Marks);
                    total += cr.Marks;
                    count++;
                }
            }
        }
        average = total / count;
        System.out.println("Total marks: " + total);
        System.out.println("Average marks: " + average);
        fo.InfoSave(DB);
    }
}
