package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Author;
import model.dao.DB;
import tool.Convert;

public class GetAuthor {
    
    public ArrayList<Author> getAuthorList(){
        ArrayList<Author> result = new ArrayList<Author>();
        
        try{
            DB db = new DB();
            String columns = "authorId, authorName, authorAddress, birthday";
            String sql = "select " + columns + " from tb_author;";
            ResultSet rs = db.query(sql);
            while(rs.next()){
                result.add(new Author(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        Convert.convertDate(rs.getString(4))
                ));
            }
        } catch (SQLException e){
            System.err.println("ERROR GET AUTHOR LIST");
        }
        
        return result;
    }
    
    public static void main(String[] args){
        System.out.println((new GetAuthor()).getAuthorList().size());
    }
}
