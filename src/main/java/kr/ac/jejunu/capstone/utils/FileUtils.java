package kr.ac.jejunu.capstone.utils;

import kr.ac.jejunu.capstone.configuration.ParkingConfig;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

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

    private static String getServerPath() {
        String serverUrl;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            serverUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        } else {
            try {
                InetAddress address = InetAddress.getLocalHost();
                serverUrl = "http://" + address.getHostAddress() + ":" + 8080;// 포트번호
            } catch (UnknownHostException unknownHostException) {
                unknownHostException.printStackTrace();
                serverUrl = null;
            }
        }
        return serverUrl;
    }

    public static String getImagePath(String directoryName, String fileName, String ext) {
        String serverUrl = getServerPath();
        String imagePath = String.format("%s/images/%s/%s.%s", serverUrl, directoryName, fileName, ext);
        return imagePath;
    }
}