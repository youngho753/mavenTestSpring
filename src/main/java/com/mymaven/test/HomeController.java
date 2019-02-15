package com.mymaven.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mymaven.mybatis.mapper.MemberService;
import com.mymaven.mybatis.util.PagingAction;
import com.mymaven.mybatis.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//@Autowired 랑 같음
	@Resource(name="mService")
	private MemberService mService;
	@Autowired
	private PagingAction page;


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}
	//insert-form
	@RequestMapping("insert")
	public String insert() {
		return "memberInsert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(MemberVO user) {
		mService.insert(user);
		return "redirect:list";
		//이렇게 해야 매핑된곳으로 감
	}

	/* 전체보기 */
	@RequestMapping("list")
	public String list(Model model,String pageNum) {
		int pageSize = 5;
		if(pageNum==null)pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		
		int count = mService.getCount();
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;
		if(endRow>count)endRow = count;
		HashMap<String,Integer> hm =new HashMap<String,Integer>();
		hm.put("startRow",startRow);
		hm.put("endRow",endRow);
		
		List<MemberVO> userList = mService.list(hm);
		String pageHtml = page.paging(count,pageSize,currentPage);
		model.addAttribute("userList",userList);
		model.addAttribute("count",count);
		model.addAttribute("pageHtml",pageHtml);
		model.addAttribute("pageNum",pageNum);
		
		
		return "list";
	}
	/* 상세보기 */
	@RequestMapping("detail")
	public String detail(Model model,String id) {
		model.addAttribute("user",mService.detail(id));
		return "memberDetail";
	}

	/* 수정하기 */
	@RequestMapping("update")
	public String update(MemberVO user) {
		mService.update(user);
		return "list";
	}
	
	/* 삭제하기 */
	@RequestMapping("delete")
	public String delete(String id) {
		mService.delete(id);
		return "list";
	}
	
	/* 검색하기 */
	@RequestMapping("search")
	public String search(Model model,String word,String field) {
		HashMap<String, String> map = new HashMap<>();
		map.put("word",word);
		map.put("field",field);
		model.addAttribute("userList",mService.search(map));
		return "list";
	}
	

}
