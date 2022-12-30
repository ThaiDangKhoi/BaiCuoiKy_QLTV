package model.bean;

import java.util.ArrayList;

public class Title {
    public static ArrayList<String> titleList(){
        ArrayList<String> result = new ArrayList<String>();
        result.add("Sách vở đầy bốn vách, có mấy cũng không vừa (Nguyễn Du)");
        result.add("Không có gì có thể thay thế văn hóa đọc (Gunte Grass)");
        result.add("Để cho con một hòm vàng không bằng dạy cho "
                + "con một quyển sách hay (Vi Hiền Truyện)");
        result.add("Vương Thù nói: Sách Kinh thì nuôi căn bản con người, "
                + "sách Sử thì mở mang tài trí cho con người (Lê Quý Đôn)");
        return result;
    }
}
