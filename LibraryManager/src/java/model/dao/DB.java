package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DB {
    private String dbName = "book";
    private String user = "root";
    private String pass = "12345";
    private int port = 3306;
    
    private Connection connect;
    private Statement statement;
    
    public DB(){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect = DriverManager.getConnection("jdbc:mysql://localhost:"+
                    port+"/"+dbName, user, pass);
            this.statement = connect.createStatement();
        } catch (Exception e){
            System.err.println("ERROR CONNECT DATABASE");
        }
    }
    
    public ResultSet query(String query){
        ResultSet rs = null;
        try{
            rs = statement.executeQuery(query);
        } catch (Exception e){}
        return rs;
    }
    
    public int update(String query){
        int rs = 0;
        try{
            rs = statement.executeUpdate(query);
        } catch (Exception e){}
        return rs;
    }
    
    public static void main(String[] args){
        String content = new String();
        
        DB db = new DB();
        
        try{
            String sql = "select * from tb_book;";
            ResultSet rs = db.query(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                for(int i = 0; i < rsmd.getColumnCount(); i++){
                    System.out.print(rs.getObject(i+1));
                    System.out.print("======");
                }
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.println(content);
    }
}
