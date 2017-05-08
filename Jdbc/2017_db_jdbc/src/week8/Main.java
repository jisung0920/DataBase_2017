package week8;

import java.sql.SQLException;


public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터 공학과 13학번 정지성\n");
		DB_Connect d1 = new DB_Connect();
		try{
			d1.query1();
			System.out.println();
			d1.query2();
			System.out.println();
			d1.query3();
			System.out.println();
			d1.query4();
			System.out.println();
			d1.query5();
			System.out.println();
			d1.query6();
			System.out.println();
			d1.query7();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQLException"+e);			
			}
	}
}


