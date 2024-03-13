package dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class ConnectionManager {
    private final SQLServerDataSource ds;
    public ConnectionManager() {
        ds = new SQLServerDataSource();
        ds.setDatabaseName("EventTicketsDB");
        ds.setUser("CSe2023b_e_23");
        ds.setPassword("CSe2023bE23#23");
        ds.setServerName("EventTicketsDB");
        ds.setTrustServerCertificate(true);
    }

    public Connection getConnection()  {
        try {
            return ds.getConnection();
        } catch (SQLServerException e) {
            throw null; //MyTunesException(ExceptionsMessages.NO_DATABASE_CONNECTION,e.getCause());
        }
    }
}