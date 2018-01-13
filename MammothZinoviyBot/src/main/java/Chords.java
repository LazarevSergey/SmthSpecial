import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by sereg on 16.09.2017.
 */
public class Chords {

    static HashMap<String, String> chords = new HashMap<>();

    public static String getChords(String substring) {
        String msg = null;
        if(chords.get(substring) == null){
            String[] songData = Utils.getSongData(substring);
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
            chords.put(substring, msg);
        } else {
            msg = chords.get(substring);
        }
            return msg;
        }
    }
