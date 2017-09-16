import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sereg on 16.09.2017.
 */
public class Commands {
    private static Integer HELP = 1;
    private static Integer DND = 2;
    private static Integer SONGS = 3;
    private static Integer EVENTS = 4;
    private static Integer TEXTS = 32;
    private static Integer CHORDS = 31;
    private static Integer QUEST = 42;
    private static Integer TRIP = 41;

    private static Map<Integer, String> mainCommands;
    private static Map<Integer, String> mainCommandsDescription;
    private static Map<Integer, String> songsCommands;
    private static Map<Integer, String> songsCommandsDescription;
    private static Map<Integer, String> dndCommands;
    private static Map<Integer, String> dndCommandsDescription;
    private static Map<Integer, String> eventCommands;
    private static Map<Integer, String> eventCommandsDescription;

    static {
        Map<Integer, String> tempCommands = new HashMap<Integer, String>();
        Map<Integer, String> tempCommandsDescription = new HashMap<Integer, String>();
        tempCommands.put(HELP, "/help");
        tempCommands.put(DND, "/dnd");
        tempCommands.put(SONGS, "/songs");
        tempCommands.put(EVENTS, "/events");
        tempCommandsDescription.put(HELP, "Нужна помощь? Не вопрос. " +
                                                    "Введи эту команду, и я тебе помогу в любой момент.");
        tempCommandsDescription.put(DND, "Есть вопрос, связанный с ДнД. Пиши эту комманду.");
        tempCommandsDescription.put(SONGS, "Выехали с друзьями на природу или в другой город. " +
                                                     "Помни Мамонт всегда с тобой и знает много песен. " +
                                                        "Пиши комманду, а я полистаю свои распечатки и найду тексты и аккорды к песне.");
        tempCommandsDescription.put(EVENTS, "Хочешь узнать, какие приключения я для тебя приготовил, напиши особенное слово");

        mainCommands = Collections.unmodifiableMap(tempCommands);
        mainCommandsDescription = Collections.unmodifiableMap(tempCommandsDescription);

        tempCommands = new HashMap<Integer, String>();
        tempCommandsDescription = new HashMap<Integer, String>();
        tempCommands.put(TEXTS, "/text");
        tempCommands.put(CHORDS, "/chords");
        tempCommandsDescription.put(TEXTS, "Забыл слова. Сейчас напомним пиши комманду");
        tempCommandsDescription.put(CHORDS, "Забыл аккорды. С этим потяжелее. Посмотрим, что я смогу сделать. " +
                                                "Пиши комманду.");
        songsCommands = Collections.unmodifiableMap(tempCommands);
        songsCommandsDescription = Collections.unmodifiableMap(tempCommandsDescription);

        tempCommands = new HashMap<Integer, String>();
        tempCommandsDescription = new HashMap<Integer, String>();
        tempCommands.put(QUEST, "/quest");
        tempCommands.put(TRIP, "/trip");
        tempCommandsDescription.put(QUEST, "Если хочешь узнать, когда квест, или просмотреть статистику команды по всем квестам, " +
                                                "пиши команду.");
        tempCommandsDescription.put(TRIP, "Хочешь узнать, когда ближайшая вылазка на природу или за пределы Москвы, " +
                                                "пиши команду.");
        eventCommands = Collections.unmodifiableMap(tempCommands);
        eventCommandsDescription = Collections.unmodifiableMap(tempCommandsDescription);
    }


    public static String getDescriptionOfAllCommands(String name) {
        String msg = new String();
        switch(name) {
            case "Main":
                for (Integer key : mainCommands.keySet()) {
                    msg += mainCommandsDescription.get(key) + " - " + mainCommands.get(key) + "\n";
                }
                break;
            case "Songs":
                for(Integer key: songsCommands.keySet()){
                    msg += songsCommandsDescription.get(key) + " - " + songsCommands.get(key) + "\n";
                }
                break;
            case "Events":
                for(Integer key: eventCommands.keySet()){
                    msg += eventCommandsDescription.get(key) + " - " + eventCommands.get(key) + "\n";
                }
                break;
        }
        return msg;
    }
}
