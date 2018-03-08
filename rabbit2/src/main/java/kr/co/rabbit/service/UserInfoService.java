package kr.co.rabbit.service;

import java.util.Map;

import kr.co.rabbit.vo.UserInfoVO;

public interface UserInfoService {
	public boolean login(Map<String,Object> rMap, UserInfoVO ui);
	public int join(UserInfoVO ui);
	public int checkUserId(String uiId);
}
