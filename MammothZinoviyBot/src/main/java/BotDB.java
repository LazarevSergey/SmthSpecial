import org.postgresql.ds.PGConnectionPoolDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BotDB {

    private static String hostname = "ec2-54-247-99-159.eu-west-1.compute.amazonaws.com";
    private static String databaseName = "d1eegvb8f6mn3p";
    private static String username = "pwqkghaqqfnkks";
    private static String password = "1388fda4e6e17056d6c9b9222eda571f882b6c9a1d7885940559f9d37f0431ff";
    private static Integer port = 5432;

    public static Statement getStatement() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setPortNumber(port);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPassword(password);
        dataSource.setUser(username);
        dataSource.setServerName(hostname);
        dataSource.setSsl(true);
        dataSource.setSslfactory("org.postgresql.ssl.NonValidatingFactory");
        return dataSource.getConnection().createStatement();
    }

    public static String getTheNearestEventByEventType(Statement statement, String eventType) throws SQLException {
        String event = new String();
        ResultSet rs = statement.executeQuery("SELECT getthenearesteventbyeventtype('" + eventType + "')");
        while (!rs.next()){
            event = rs.getString(1);
        }
        statement.close();
        return event;
    }

    public static String getTheNearestEvent(Statement statement) throws SQLException {
        String event = new String();
        ResultSet rs = statement.executeQuery("call getTheNearestTrip()");
        while (!rs.next()){
            event = rs.getString(1);
        }
        statement.close();
        return event;
    }

    public static String getEvents(Statement statement) throws SQLException {
        String events = "Запланированы следующие события: ";
        ResultSet rs = statement.executeQuery("SELECT getevents()");
        while (rs.next()){
            events = events + ";\n" + rs.getString(1);
        }
        statement.close();
        return events;
    }

    public static String getEventsByEventType(Statement statement, String eventType) throws SQLException {
        String events = new String();
        ResultSet rs = statement.executeQuery("SELECT geteventsbyeventtype('" + eventType + "')");
        while (!rs.next()){
            events = events + ";\n" + rs.getString(1);
        }
        statement.close();
        return events;
    }
}
