package com.mymaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.mymaven.mybatis.vo.MemberVO;

public interface memberDAO {
	//전체보기
	List<MemberVO> getList(String sqlid);
	//검색
	List<MemberVO> searchList(String sqlid,HashMap<String, String> map);
	
	//추가
	void insert(String sqlid,MemberVO user);
	
	//수정
	void update(String sqlid,MemberVO user);
	
	//상세보기
	MemberVO findById(String sqlid,String id);
	
	//삭제
	void delete(String sqlid,String id);
	
	//count
	int getCount(String sqlid);
}
