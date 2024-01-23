import controller.BankController;
import dao.BankDao;
import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        String url = "selectAll";

        BankDao dao = new BankDao();
        BankController con = new BankController(dao); //의존성 주입(dependention injection)//만들 책임이 없다 //디스패처에서 만들면 계속 new해서 만들어야 됨

        Dispatcher dis = new Dispatcher(con);
        dis.route(url);
    }
}
