package com.chrisjhkim.hellospring.dao;

import com.chrisjhkim.hellospring.vo.UserInfo;

public interface UserInfoDao {

	public UserInfo findUserInfoByNo(String customerNo);

}
