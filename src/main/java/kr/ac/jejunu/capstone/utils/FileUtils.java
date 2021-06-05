package kr.ac.jejunu.capstone.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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
    public static String getImagePath(String directoryName, String fileName, String ext) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String serverUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String imagePath = String.format("%s/images/%s/%s.%s", serverUrl, directoryName, fileName, ext);
        return imagePath;
    }
}