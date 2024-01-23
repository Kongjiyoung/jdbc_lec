import controller.BankController;
import controller.RequestMapping;
import dao.BankDao;
import db.DBConnection;
import model.Account;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
//        String url = "selectAll";
//
//        BankDao dao = new BankDao();
//        BankController con = new BankController(dao); //의존성 주입(dependention injection)//만들 책임이 없다 //디스패처에서 만들면 계속 new해서 만들어야 됨
//
//        Dispatcher dis = new Dispatcher(con);
//        dis.route(url);

        String path = "/selectAll";

        BankDao dao = new BankDao();
        BankController con = new BankController(dao);

        Method[] methods = con.getClass().getDeclaredMethods(); //클래스를 들고 와서 내가선언한 메서드를 다들고와
        for(Method method : methods){
            //System.out.println(method.getName());
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if(rm == null) continue;
            if(rm.uri().equals(path)){
                try {
                    method.invoke(con); //메소드 호출 =con.login(); 어떤 힙의 메서드를 넣어줘야하는지
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
