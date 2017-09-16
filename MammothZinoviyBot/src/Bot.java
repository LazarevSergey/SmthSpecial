import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by sereg on 16.09.2017.
 */
public class Bot extends TelegramLongPollingBot{

    /*public static void main(String[] args){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            if (message.getText().equals("/help")){
                String msg = "Привет, дорогой друг! Сейчас я расскажу тебе, как со мной общаться.\n" +
                        "Вот перечень команда основного меню, которые я понимаю:\n";
                msg += Commands.getDescriptionOfAllCommands("Main");
                sendMsg(message, msg);
            }else if (message.getText().equals("/songs")){
                String msg = "Привет! Сейчас я расскажу тебе, как найти нужную информацию о песне.\n" +
                        "Вот перечень команда, которые я понимаю:\n";
                msg += Commands.getDescriptionOfAllCommands("Songs");
                sendMsg(message, msg);
            } else if (message.getText().equals("/events")){
                String msg = "Привет! Сейчас я расскажу, что тебя ожидает в ближайшее время.\n" +
                        "Вот перечень команда, которые я понимаю:\n";
                msg += Commands.getDescriptionOfAllCommands("Events");
                sendMsg(message, msg);
            } else {
                sendMsg(message, "Привет! С тобой общается мамонт Зиновий. И да, я настоящий мамонт. " +
                        "Пиши /help и я помогу.");
            }
        }
    }

    private void sendMsg(Message message, String s) {
        SendMessage sendMessage = new SendMessage();
        //sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        //sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Мамонт Зиновий";
    }

    @Override
    public String getBotToken() {
        return "441712916:AAGeZcci2oODEFReDTe9XrM1vtDx-YOr1Fc";
    }
}
