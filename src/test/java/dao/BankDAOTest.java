package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankDAOTest {
    @Test
    public void selectAll_test(){
        //given

        //when
        BankDao dao = new BankDao();
        List<Account> accountList=dao.selectAll();

        System.out.println(accountList.size());
        System.out.println(accountList);
    }
    @Test
    public void selectByNumber_test(){
        //given
        int number=5;

        //when
        BankDao dao = new BankDao();
        Account account = dao.selectByNumber(number);

        //then
        if(account == null){
            System.out.println(number+"로 조회된 값이 없습니다");
        }else{
            System.out.println(account);
//            System.out.println(account.getNumber());
//            System.out.println(account.getPassword());
//            System.out.println(account.getBalance());
//            System.out.println(account.getCreatedAt());
        }
    }

    @Test
    public void deleteByNumber_test(){
        //given
        int number= 1;

        //when
        BankDao dao=new BankDao();
        int result=dao.deleteByNumber(number);

        //then
        if (result==1){
            System.out.println("삭제성공");
        }else if(result==0){
            System.out.println(number+"번호를 찾을 수 없습니다");
        }else {
            System.out.println("삭제실패");
        }

    }
    @Test
    public void insert_test(){
        //given
        String password="1234";
        int balance=2000;
        //when
        BankDao dao=new BankDao();
        int result=dao.insert(password, balance);

        //then
        if (result==1){
            System.out.println("삽입성공");
        }else if(result==0){
            System.out.println();
        }else {
            System.out.println("삽입실패");
        }

    }

    @Test
    public void updateByNumber_test(){
        //given
        int balance=3000;
        int number=4;
        //when
        BankDao dao=new BankDao();
        int result=dao.updateByNumber(balance,number);

        //then
        if (result==1){
            System.out.println("수정성공");
        }else if(result==0){
            System.out.println(number+"번호를 찾을 수 없습니다");
        }else {
            System.out.println("수정실패");
        }

    }


}
