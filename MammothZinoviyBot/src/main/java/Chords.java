import java.io.*;

/**
 * Created by sereg on 16.09.2017.
 */
public class Chords {
    public static String getChords(String substring) {
        String[] songData = Utils.getSongData(substring);
        String msg = new String();
        try {
            FileReader fileReader = new FileReader(Chords.class.getResource(songData[0].substring(0,0) + "/" +
                    songData[0] + "/" + songData[1] + "/chords.txt").getPath());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            msg = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "Ooops! Что-то пошло не так! ПОМОГИТЕ!";
        }
//        File chords = new File();
        return msg;
    }
}
