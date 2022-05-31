package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {//her seyeden once calisisan block, ve sadece bir kere calisir
        String yol = "configuration.properties";

        try {
            FileInputStream fis = new FileInputStream(yol);
            //fis dosya yolunu tanimladigimiz configuratio.properies dosyasini okudu

            properties = new Properties();
            properties.load(fis);//fis in okududgu bilgileri properties e yukledi

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getProperty(String key) {

        /*
        test meth yolladigimiz stering key degerini alip
        properties classindan get properti meth kullanarak bu key e ait value bize getirdi
         */

        return properties.getProperty(key);
    }


}
