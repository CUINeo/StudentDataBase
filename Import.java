import DataBase.*;

public class Import {
    public static void main(String[] args) {
        String FileName = args[0];
        DataBaseRecord DB = new DataBaseRecord();
        FileOperation fo = new FileOperation();
        fo.FileInit(FileName, DB);
        fo.InfoSave(DB);
    }
}
