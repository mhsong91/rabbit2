package kr.co.rabbit.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.rabbit.dao.ShopDAO;
import kr.co.rabbit.vo.ShopVO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public List<ShopVO> selectShopList() {
		SqlSession ss = ssf.openSession();
		List<ShopVO> KShopList = ss.selectList("shop.selectKShopList");
		System.out.println("KShopList    :   "+KShopList);
		ss.close();
		return KShopList;
	}

	@Override
	public List<ShopVO> selectConnectionInfoList(int uiNo) {
		SqlSession ss = ssf.openSession();
		List<ShopVO> spList = ss.selectList("shop.selectAdminShop",uiNo);
		return spList;
	}



}
