package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DBConnection_Test{


    //리턴타입을 적을 수 없다.
    //매개변수를 적을 수 없다.
    //@Test 붙이면 매서트별로 신청가능

    @Test
    public void getInstance_Test(){ //Connection 소켓객체
        //given = 파라미터

        //when = 본코드 실행
        Connection conn = DBConnection.getInstance();
        //then = 검증
        if (conn==null){
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
    }
}