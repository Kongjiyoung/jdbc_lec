import dao.BankDao;
import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //http://bank.com/account GET(식별자)  계좌 정보 얻기 http account메서드가 필요
        //http://bank.com/account/10 GET  계좌 정보 얻기 식별자요청 db에 있는 데이터가 필요하다
        //http://bank.com/account POST 계좌 정보 넣기
        //http://bank.com/account/1 DELETE 계좌 정보 삭제
        //http://bank.com/account/1 PUT 계좌 수정
        //post, put 데이터가 필요하다(body데이터) 돌려줄 데이터가 없다.
        //get 요청은 body가 없다 http에
        //post,put은 바디데이터가 필요하다 응답할 데이터는 필요없다, 잘들어갔다만 필요함


        // /account,
        // /account/1
        // /account
        // /account/1
        // /account/1
        System.out.println("http 메서드를 입력하세요");
        String method=sc.nextLine();

        System.out.println("body식별자를 입력하세요");
        String action=sc.nextLine();

        String body = "";

        BankDao bankDao=new BankDao();

        //라우팅한다.
        if(method.equals("GET")){
            if (action.equals("/account")){
                List<Account> accountList = bankDao.selectAll();
                System.out.println(accountList);
            } else if (action.contains("/account/")) {
                String[] st1 = body.split("/");
                int number = Integer.parseInt(st1[1].substring(action.lastIndexOf("/") + 1));
                Account account = bankDao.selectByNumber(number);
                System.out.println(account);
            }
        }else if(method.equals("POST")){

            if (action.equals("/account")){
                System.out.println("body 데이터를 입력하세요");
                body = sc.nextLine();

                //passward=12344&balance=1000
                String[] st1 = body.split("&");
                String password = st1[0].split("=")[1];
                int balance =Integer.parseInt(st1[1].split("=")[1]);
                bankDao.insert(password, balance);
            }

        }else if(method.equals("PUT")){
            if (action.equals("/account/5")) {
                System.out.println("body 데이터를 입력하세요");
                body = sc.nextLine();

                String[] st1 = body.split("=");
                int balance = Integer.parseInt(st1[1]);
                bankDao.updateByNumber(balance,5);
            }
        }else if(method.equals("DELETE")){
            if (action.equals("/account/7")) {
                bankDao.deleteByNumber(7);
            }
        }
    }
}
