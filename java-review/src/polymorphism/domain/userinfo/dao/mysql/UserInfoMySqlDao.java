package polymorphism.domain.userinfo.dao.mysql;

import polymorphism.domain.userinfo.UserInfo;
import polymorphism.domain.userinfo.dao.UserInfoDao;

public class UserInfoMySqlDao implements UserInfoDao {

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("insert into MySql DB, userId = " + userInfo.getUserId());		
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("update into MySql DB, userId = " + userInfo.getUserId());
		
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		System.out.println("delete into MySql DB, userId = " + userInfo.getUserId());
		
	}

}
