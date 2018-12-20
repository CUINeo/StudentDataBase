package DataBase;

import java.io.*;

// Initialize the system with information in a .csv file
public class FileOperation {
    // Initialize system with a .csv file
    private void Init(String FileName, DataBaseRecord DB) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(FileName);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] Records = line.split(",");
                String StudentName = Records[0];
                String CourseName = Records[1];
                double Marks = Double.valueOf(Records[2]);
                DB.AddStudentCourse(StudentName, CourseName, Marks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Initialize system with a default .csv file
    public void DefaultInit(DataBaseRecord DB) {
        File file = new File("Default.csv");
        if (file.exists())
            Init("Default.csv", DB);
    }

    // Initialize system with a given .csv file
    public void FileInit(String FileName, DataBaseRecord DB) {
        Init(FileName, DB);
        System.out.println("Import success!");
    }

    // Save the information into Default.csv
    public void InfoSave(DataBaseRecord DB) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File("Default.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter("Default.csv");
            bw = new BufferedWriter(fw);
            StringBuffer sb = new StringBuffer();
            String StudentName, CourseName;
            double Marks;
            for (StudentRecord sr : DB.StudentSet) {
                StudentName = sr.StudentName;
                for (CourseRecord cr : sr.CourseSet) {
                    CourseName = cr.CourseName;
                    Marks = cr.Marks;
                    sb.append(StudentName);
                    sb.append(",");
                    sb.append(CourseName);
                    sb.append(",");
                    sb.append(String.valueOf(Marks));
                    bw.write(sb.toString() + "\n");
                    sb.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
