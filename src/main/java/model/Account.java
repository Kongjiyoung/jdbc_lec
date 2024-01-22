package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

/*
DB에 Select 한 데이터를 담기 위한 오브젝트
 */
@ToString
@AllArgsConstructor //생성자를 하나하나 만들어주기 귀찮아서 if(isRow){}를 한꺼번에 담아주는 항아리 같은 존재, 만약 1번이 삭제되도 1번자리에 들어가지 않고 2번부터 들어`간다
@Getter
public class Account {
    private int number;
    private String password;
    private int balance;

    //java.sql의 Timestamp
    //카멜표기법 사용하기
    private Timestamp createdAt;

}
