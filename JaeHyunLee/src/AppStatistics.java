import java.sql.*;
import java.util.Scanner;
//Statement == sql쿼리문을 보내기위한 객체
public class AppStatistics {
    public void StatisticsFunction(Statement statement) {
        
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("통계");
        
        String query =("SELECT QUESTION_ID,
        SUM(IF(ANSWER_ID = "ANSWER1",1,0) ) AS 'ANSWER1',
        SUM(IF(ANSWER_ID = "ANSWER2",1,0) ) AS 'ANSWER2',
        SUM(IF(ANSWER_ID = "ANSWER3",1,0) ) AS 'ANSWER3',
        SUM(IF(ANSWER_ID = "ANSWER4",1,0) ) AS 'ANSWER4',
        SUM(IF(ANSWER_ID = "ANSWER5",1,0) ) AS 'ANSWER5'
        FROM survey
        GROUP BY QUESTION_ID
        WITH ROLLUP"
        
        
        
        
        
        );



        ResultSet resultSet = null;
        //String query = "SELECT * FROM user;";
               
        try {

            resultSet = statement.executeQuery(query);
                            
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"+resultSet.getString(6)+"\t");
            }

            
        } catch (SQLException e) {
           System.out.println("조회 실패!");
            e.printStackTrace();
        }
    }
}
