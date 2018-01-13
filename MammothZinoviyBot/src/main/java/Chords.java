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
            /*URL url = Chords.class.getResource(songData[0].substring(0, 1));
            System.out.println(url.getPath());
            Stream<String> lines = Files.lines(Paths.get(
                    String.valueOf(ClassLoader.getSystemResourceAsStream(
                            url.getPath() + "/" + songData[0]  + "/" + songData[1] + "/chords.txt"))));
                            //songData[0].substring(0, 1) + "/" + songData[0] + "/" + songData[1] + "/chords.txt"))));
            for (String line : (Iterable<String>) () -> lines.iterator()) {
                msg += line;
                msg += "\n";
            }*/
            String path = songData[0].substring(0,1) + "/" + songData[0] + "/" + songData[1] + "/chords.txt";
            System.out.println(path);
            //URL url = .class.getResource(songData[0]);
            //System.out.println(url.getPath());
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(classLoader.getResource(path).getFile());
            msg = new String(Files.readAllBytes(file.toPath()));
//            FileReader fileReader = new FileReader(path);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            msg = bufferedReader.readLine();
//            bufferedReader.close();
            if (msg == null || msg.isEmpty()) return "Файл " + substring + " не найден!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Ooops! Что-то пошло не так! ПОМОГИТЕ!";
        }
//        File chords = new File();
            return msg;
        }
    }
