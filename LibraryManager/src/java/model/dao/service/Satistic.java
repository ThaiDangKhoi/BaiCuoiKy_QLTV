package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.EntitySatistic;
import model.dao.DB;

public class Satistic {
    
    public ArrayList<EntitySatistic> getBorrowingBookStatistic(){
        
        ArrayList<EntitySatistic> result = new ArrayList<EntitySatistic>();
        
        try{
            String columns = "bookId, count(bookId)";
            String sql = "select " + columns + " from tb_borrow_book "
                    + "group by bookId;";
            DB db = new DB();
            ResultSet rs = db.query(sql);
            while(rs.next()){
                result.add(new EntitySatistic(rs.getInt(1), rs.getInt(2)));
            }
        } catch(SQLException se){
            System.err.println("ERROR GET STATISTC");
        }
        
        return result;
    }
    
    public EntitySatistic getUserStatistic(){
        
        EntitySatistic result = null;
        
        try{
            String sql = "select count(email) from tb_userInfo;";
            DB db = new DB();
            ResultSet rs = db.query(sql);
            rs.next();
            result = new EntitySatistic("user", rs.getInt(1));
        } catch(SQLException se){
            System.err.println("ERROR GET STATISTC");
        }
        
        return result;
    }
    
    public int getBorrowedBookQuantity(){
        
        int result = 0;
        
        try{
            String sql = "select count(email) from tb_borrow_book;";
            DB db = new DB();
            ResultSet rs = db.query(sql);
            rs.next();
            result = rs.getInt(1);
        } catch(SQLException se){
            System.err.println("ERROR GET STATISTC");
        }
        
        return result;
    }
    
    public int getBorrowedUserQuantity(){
        
        int result = 0;
        
        try{
            String sql = "select count(distinct email) from tb_borrow_book;";
            DB db = new DB();
            ResultSet rs = db.query(sql);
            rs.next();
            result = rs.getInt(1);
        } catch(SQLException se){
            System.err.println("ERROR GET STATISTC");
        }
        
        return result;
    }
    
    public static void main(String[] args){
        System.out.println((new Satistic()).getUserStatistic().getQuantity());
        System.out.println((new Satistic()).getBorrowedUserQuantity());
    }
}
