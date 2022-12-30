package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Category;
import model.dao.DB;

public class GetCategory {
    
    public ArrayList<Category> getCategoryList(){
        ArrayList<Category> result = new ArrayList<Category>();
        
        try{
            DB db = new DB();
            String columns = "bookCategoryId, bookCategoryName";
            String sql = "select " + columns + " from tb_bookCategory;";
            ResultSet rs = db.query(sql);
            while(rs.next()){
                result.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (SQLException e){
            System.err.println("ERROR GET CATEGORY LIST");
        }
        
        return result;
    }
    
    public static void main(String[] args){
        System.out.println((new GetCategory()).getCategoryList().size());
    }
}
