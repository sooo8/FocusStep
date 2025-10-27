package test;

import dao.AccountsDAO;
import model.Account;
import model.Login;

public class AccountsDAOTest {
	public static void main(String[] args) {
		testFindByLoginOK(); //ユーザーが見つかる場合のテスト
		testFindByLoginNG(); //ユーザーが見つからない場合のテスト
	}
	public static void testFindByLoginOK() {
		Login login = new Login("minato","1234");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result != null &&
			result.getUserId().equals("0001") &&
			result.getPass().equals("0123456789") &&
			result.getMail().equals("yusuke.minato@miyabilink.jp") &&
			result.getNameSei().equals("湊") &&
			result.getNameMei().equals("雄輔") &&
			result.getNameSeiRoma().equals("Minato") &&
			result.getNameMeiRoma().equals("Yusuke") &&
			result.getAge() == 23){
				System.out.println("testFindByLoginOK:成功しました");
			}else {
				System.out.println("testFindByLoginOK:失敗しました");
			}
	}
	public static void testFindByLoginNG() {
		Login login = new Login("0001","0123456789");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testFindByLoginNG:成功しました");
		}else {
			System.out.println("testFindByLoginNG:失敗しました");
		}
	}
}
