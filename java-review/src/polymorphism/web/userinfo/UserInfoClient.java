package polymorphism.web.userinfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import polymorphism.domain.userinfo.UserInfo;
import polymorphism.domain.userinfo.dao.UserInfoDao;
import polymorphism.domain.userinfo.dao.mysql.UserInfoMySqlDao;
import polymorphism.domain.userinfo.dao.oracle.UserInfoOracleDao;

public class UserInfoClient {
	
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("db.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String dbType = prop.getProperty("DBTYPE");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("1001");
		userInfo.setPassword("1234");
		userInfo.setUserName("최민석");
		
		
		UserInfoDao userInfoDao = null;
		
		if(dbType.equals("ORACLE")){
			userInfoDao = new UserInfoOracleDao();
		}
		else if(dbType.endsWith("MYSQL")){
			userInfoDao = new UserInfoMySqlDao();
		}
		else{
			System.out.println("db error");
			return;
		}
		
		userInfoDao.insertUserInfo(userInfo);
		userInfoDao.updateUserInfo(userInfo);
		userInfoDao.deleteUserInfo(userInfo);

	}
}
