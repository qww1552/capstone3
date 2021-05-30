package kr.ac.jejunu.capstone.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    public FileUtils() {
    }

    public static void writeImageToFile(byte[] imageBytes, File fileWriteTest) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileWriteTest);
        fileOutputStream.write(imageBytes);
        fileOutputStream.close();
    }

    public static File getFile(String directoryName, String fileName) throws IOException {
        String path = getPath();
        //생성할 파일의 경로
        File dir = new File(path + "/" + directoryName);

        if (!dir.exists())
            dir.mkdir();

        File file = new File(path + "/" + directoryName + "/" + fileName + ".jpeg");
        if (!file.exists())
            file.createNewFile();

        return file;
    }

    //프로젝트 절대경로
    public static String getPath() {
        return new File("").getAbsolutePath() + "/src/main/webapp/images/";
    }
}