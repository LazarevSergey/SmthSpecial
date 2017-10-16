public class Utils {
    public static String[] getSongData(String request){
        String singer = request.substring(0, request.indexOf(" —") - 1);
        String song = request.substring(request.indexOf("— ") + 1);
        String[] songData = {singer, song};
        return songData;
    }
}
