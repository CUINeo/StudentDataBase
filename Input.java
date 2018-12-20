import DataBase.*;

public class Input {
    public static void main(String[] args) {
        String StudentName = args[0];
        String CourseName = args[1];
        double Marks = Double.valueOf(args[2]);
        DataBaseRecord DB = new DataBaseRecord();
        FileOperation fo = new FileOperation();
        fo.DefaultInit(DB);
        DB.AddStudentCourse(StudentName, CourseName, Marks);
        fo.InfoSave(DB);
        System.out.println("Input success!");
    }
}
