package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Author;
import model.dao.DB;
import tool.Convert;

public class AuthorAccess {

    public ArrayList<Author> getAuhtorList() {
        ArrayList<Author> result = new ArrayList<Author>();

        try {
            DB db = new DB();
            String columns = "authorId, authorName, authorAddress, birthday";
            String sql = "select " + columns + " from tb_author;";
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                result.add(new Author(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        Convert.convertDate(rs.getString(4))
                ));
            }
        } catch (SQLException se) {
            System.err.println("ERROR ACCESS AUHTOR");
        }

        return result;
    }
}
