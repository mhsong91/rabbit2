package kr.co.rabbit.service;

import java.util.List;

import kr.co.rabbit.vo.ShopVO;
import kr.co.rabbit.vo.UserInfoVO;

public interface ShopService {

	public List<ShopVO> getConnectionInfoList(UserInfoVO ui);
	List<ShopVO> getShopList();
	
	
}
