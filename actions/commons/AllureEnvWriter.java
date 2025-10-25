package commons;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class AllureEnvWriter {

    public static void writeEnvironment(String projectRoot) {
        try {
            String folder = projectRoot + File.separator + "allure-results";
            File dir = new File(folder);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String filePath = folder + File.separator + "environment.properties";
            Properties props = new Properties();
            props.setProperty("Project", "Wordpress Admin");
            props.setProperty("Tester", "Phuong Nguyen");
            props.setProperty("Environment", "Staging");
            props.setProperty("Browser", "Chrome");
            props.setProperty("OS", System.getProperty("os.name"));
            props.setProperty("Java.Version", System.getProperty("java.version"));

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                props.store(fos, "Allure environment");
            }
            System.out.println("Allure environment file written: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}