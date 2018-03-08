package kr.co.rabbit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rabbit.service.ShopService;
import kr.co.rabbit.vo.ShopVO;


@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService shs;

	@RequestMapping(value="/shopList", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> getMenuList(Map<String,Object> map){
		System.out.println("shop컨트롤러에요");
		List<ShopVO> shopList = shs.getShopList();
		map.put("shopList", shopList);
		System.out.println(map);
		return map;
	}
}
