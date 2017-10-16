/**
 * Created by sereg on 16.09.2017.
 */
public class Chords {
    public static String getChords(String substring) {
        String[] songData = Utils.getSongData(substring);
        return songData.toString();
    }
}
