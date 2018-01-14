import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by sereg on 16.09.2017.
 */
public class Chords {
    public static String getChords(String substring) {
        String[] songData = Utils.getSongData(substring);
        String msg = null;
        try {
            String path = songData[0].substring(0,1) + "/" + songData[0] + "/" + songData[1] + "/chords.txt";
            System.out.println(path);
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(classLoader.getResource(path).getFile());
            msg = IOUtils.toString(classLoader.getResourceAsStream(path));
            if (msg == null || msg.isEmpty()) return "Файл " + substring + " не найден!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Ooops! Что-то пошло не так! ПОМОГИТЕ!";
        }
            return msg;
        }
    }
