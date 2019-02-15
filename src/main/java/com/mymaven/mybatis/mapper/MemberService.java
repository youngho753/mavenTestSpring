package com.mymaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymaven.mybatis.util.PagingAction;
import com.mymaven.mybatis.vo.MemberVO;

@Service("mService")
public class MemberService {
	//@Resource(name="mDao")
	@Autowired
	private memberDAOImpl mDao;
	
	
	
	public void insert(MemberVO user) {
		mDao.insert("insertMember", user);
	}
	
	//전체보기
	public List<MemberVO> list(){
		return mDao.getList("selectMember");
	}
	public List<MemberVO> list(HashMap<String, Integer> hm){
		return mDao.getList("selectMember",hm);
	}
	
	//상세보기
	public MemberVO detail(String id){
		return mDao.findById("detail", id);
	}
	
	//수정하기
	public void update(MemberVO user){
		mDao.update("updateMember", user);
	}
	
	//삭제하기
	public void delete(String id) {
		mDao.delete("deleteMember", id);
	}
	
	/* 검색하기 */
	public List<MemberVO> search(HashMap<String, String> map){
		return mDao.searchList("search",map);
	}
	public int getCount() {
		return mDao.getCount("getMember");
	}
}
