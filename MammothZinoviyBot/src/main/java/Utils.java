public class Utils {
    public static String[] getSongData(String request){
        String singer = request.substring(0, request.indexOf('—'));
        String song = request.substring(request.indexOf('—') + 2);
        singer = singer.substring(0, singer.length()-1);
        System.out.println("Singer: " + singer);
        System.out.println("Song: " + song);
        String[] songData = {singer, song};
        return songData;
    }
}
