package kr.co.rabbit.dao;

import java.util.List;

import kr.co.rabbit.vo.ShopVO;

public interface ShopDAO {

	List<ShopVO> selectShopList();
}
