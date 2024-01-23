import controller.BankController;
import lombok.AllArgsConstructor;

/**
 * 책임 : 라우팅
 */
@AllArgsConstructor
public class Dispatcher {
    private BankController con;
//        public Dispatcher(BankController con){ //필요한 애한테 주입
//            this.con=con;
//        }
    public void route(String url){



        //라우터(ex)뭐들어오면 일로가), 디스페처(추적해서 찾아줌)
        if(url.equals("insert")){
            con.insert();
        } else if (url.equals("delete")) {
            con.delete();
        } else if (url.equals("update")) {
            con.update();
        } else if (url.equals("selectOne")) {
            con.selectOne();
        } else if (url.equals("selectAll")) {
            con.selectAll();
        }
    }
}
