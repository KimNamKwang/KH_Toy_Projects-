import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AppDelete {
    public void DeleteFunction(Statement statement) {
        Scanner scanner = new Scanner(System.in);        
        // 커맨드 받기.
        System.out.print("이름을 입력해주세요 :" );
        String name = scanner.next();
        System.out.print("비밀번호를 입력해주세요 :" );
        String password = scanner.next();
        String query = "SELECT * FROM user WHERE NAME = '"+name+"' AND PASSWORD = '"+password+"';";
        
        try {
            
            ResultSet resultSet = statement.executeQuery(query);
            //ResultSet resultSet2 = statement.executeQuery(query);
            
            if(resultSet.isBeforeFirst()) {
                
                System.out.println("\n== 로그인에 성공했습니다. ==\n");
                query = "DELETE FROM survey WHERE USER_ID IN (SELECT USER_ID FROM user WHERE NAME = '" + name + "'AND password ='" + password + "');" ;
                statement.execute(query);
                
                query = "SELECT * FROM survey WHERE USER_ID IN (SELECT USER_ID FROM user WHERE NAME = '" + name + "')" ;
                ResultSet rst = statement.executeQuery(query);
                //Scanner로 입력받은 USER_NAME과 USER_ID를 어떻게 엮을지 고민.-> 했으나 극뽁-! ->한 줄 알았는데 FAIL->했으나 실패는 성공의 오까상
                
                if(!rst.isBeforeFirst()) {
                    
                    System.out.println("삭제가 완료되었습니다.");
                }
            }else{
                System.out.println("회원정보가 일치하지 않습니다, 다시 시도해주세요.");
            }
            
        }catch (Exception exception) {
            exception.printStackTrace();
        }        
    }
}


