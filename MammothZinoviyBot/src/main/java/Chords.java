import java.io.*;
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
            Stream<String> lines = Files.lines(Paths.get(
                    String.valueOf(ClassLoader.getSystemResourceAsStream(
                            songData[0].substring(0, 1) + "\\" + songData[0] + "\\" + songData[1] + "\\chords.txt"))));
            for (String line : (Iterable<String>) () -> lines.iterator()) {
                msg += line;
                msg += "\n";
            }
            if (msg == null || msg.isEmpty()) return "Файл " + substring + " не найден!";
//            String path = "/"+ songData[0].substring(0,1) + "/" + songData[0] + "/" + songData[1] + "/chords.txt";
//            FileReader fileReader = new FileReader(Chords.class.getResource("/"+ songData[0].substring(0,1) + "/" +
//                    songData[0] + "/" + songData[1] + "/chords.txt").getPath());
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            msg = bufferedReader.readLine();
//            bufferedReader.close();
        } catch (IOException|NullPointerException e) {
            e.printStackTrace();
            return "Ooops! Что-то пошло не так! ПОМОГИТЕ!";
        }
//        File chords = new File();
        return msg;
    }
}
