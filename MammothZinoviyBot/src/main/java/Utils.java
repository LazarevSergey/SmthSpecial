public class Utils {
    public static String[] getSongData(String request){
        String singer = request.substring(0, request.indexOf("—") - 1);
        String song = request.substring(request.indexOf("—") + 2);
        System.out.println("Singer: " + singer);
        System.out.println("Song: " + song);
        String[] songData = {singer, song};
        return songData;
    }
}
