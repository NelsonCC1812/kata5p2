package kata5p2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kata5p2.model.Mail;

public class MailListReaderBD {
    static public List<Mail> read(String url) {

        List<Mail> mails = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from email")) {

            while (rs.next())
                mails.add(new Mail(rs.getString("mail")));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return mails;
    }
}
