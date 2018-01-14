import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by sereg on 16.09.2017.
 */
public class Texts {

    static HashMap<String, String> texts = new HashMap<>();

    public static String getText(String substring) {
        String msg = null;
        if (texts.get(substring) == null) {
            String[] songData = Utils.getSongData(substring);
            try {
                String path = songData[0].substring(0, 1) + "/" + songData[0] + "/" + songData[1] + "/text.txt";
                System.out.println(path);
                ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                File file = new File(classLoader.getResource(path).getFile());
                msg = IOUtils.toString(classLoader.getResourceAsStream(path));
                if (msg == null || msg.isEmpty()) return "Файл " + substring + " не найден!";
            } catch (IOException e) {
                e.printStackTrace();
                return "Ooops! Что-то пошло не так! ПОМОГИТЕ!";
            }
            texts.put(substring, msg);
        } else {
            msg = texts.get(substring);
        }
        return msg;
    }
}
