package controller;

import dao.BankDao;
import lombok.AllArgsConstructor;

import java.lang.annotation.Retention;

/**
 *책임 : 유효성검사(바디데이터), 파싱(바디데이터), 적절한 DAO 찾기   SRP : 책임을 적게 가져라
 */
@AllArgsConstructor
public class BankController {
    private BankDao dao;


    public  void insert(){
        //1. 파싱

        //2. 유효성 검사 (값이 유효한지 검사한다 ex)글자수가 초과하거나 값의 조건에 맞지 않을텐데 악의적인 접근을 막기위해(보안))

        //3. dao 찾기
        System.out.println("controller : insert");
        dao.insert("1234", 1000);
    }


    public void delete(){
        System.out.println("controller : delete");
        System.out.println(5);
    }


    public  void update(){
        System.out.println("controller : update");
        dao.updateByNumber(1000,4);
    }

    public void selectOne(){
        System.out.println("controller : selectOne");
        dao.selectByNumber(4);
    }

    public void selectAll(){
        System.out.println("controller : selectAll");
        dao.selectAll();
    }
}
