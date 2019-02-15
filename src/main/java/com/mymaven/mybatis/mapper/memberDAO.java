package com.mymaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.mymaven.mybatis.vo.MemberVO;

public interface memberDAO {
	//��ü����
	List<MemberVO> getList(String sqlid);
	//�˻�
	List<MemberVO> searchList(String sqlid,HashMap<String, String> map);
	
	//�߰�
	void insert(String sqlid,MemberVO user);
	
	//����
	void update(String sqlid,MemberVO user);
	
	//�󼼺���
	MemberVO findById(String sqlid,String id);
	
	//����
	void delete(String sqlid,String id);
	
	//count
	int getCount(String sqlid);
}
