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
	
	//��ü����
	public List<MemberVO> list(){
		return mDao.getList("selectMember");
	}
	public List<MemberVO> list(HashMap<String, Integer> hm){
		return mDao.getList("selectMember",hm);
	}
	
	//�󼼺���
	public MemberVO detail(String id){
		return mDao.findById("detail", id);
	}
	
	//�����ϱ�
	public void update(MemberVO user){
		mDao.update("updateMember", user);
	}
	
	//�����ϱ�
	public void delete(String id) {
		mDao.delete("deleteMember", id);
	}
	
	/* �˻��ϱ� */
	public List<MemberVO> search(HashMap<String, String> map){
		return mDao.searchList("search",map);
	}
	public int getCount() {
		return mDao.getCount("getMember");
	}
}
