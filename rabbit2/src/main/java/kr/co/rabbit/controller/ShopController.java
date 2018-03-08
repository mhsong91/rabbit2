package kr.co.rabbit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rabbit.service.ShopService;
import kr.co.rabbit.vo.ShopVO;
import kr.co.rabbit.vo.UserInfoVO;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopService shs;

	@RequestMapping(value = "/shopList", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getMenuList(Map<String, Object> map) {
		System.out.println("shop컨트롤러에요");
		List<ShopVO> shopList = shs.getShopList();
		map.put("shopList", shopList);
		System.out.println(map);
		return map;
	}

	@RequestMapping(value = "/adminHave", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getadminHave(HttpSession hs, Map<String, Object> map) {
		UserInfoVO ui = new UserInfoVO();
		if (hs.getAttribute("userNo") != null) {
			ui.setUiNo((Integer) hs.getAttribute("userNo"));//song
		} else {
			map.put("msg", "혹시 가게가 망하셨나요?ㅋㅋㅋ 사장님?");
		}
		List<ShopVO> spList = shs.getConnectionInfoList(ui);
		map.put("spList", spList);
		System.out.println("888888888888888888" + spList);

		return map;
	}
}
