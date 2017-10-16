/**
 * Created by sereg on 16.09.2017.
 */
public class Texts {

    public static String getText(String substring) {
        String[] songData = Utils.getSongData(substring);
        return songData.toString();
    }
}
