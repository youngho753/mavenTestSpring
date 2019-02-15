package com.mymaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mymaven.mybatis.vo.MemberVO;

@Repository("mDao")
public class memberDAOImpl implements memberDAO{
	@Autowired
	private SqlSession sqlMap;
	
	
	
	@Override
	public List<MemberVO> getList(String sqlid) {
		//sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		
		return sqlMap.selectList(sqlid);
		
	}
	
	public List<MemberVO> getList(String sqlid, HashMap<String,Integer> map) {
		//sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		
		return sqlMap.selectList(sqlid,map);
	}
	
	
		
	@Override
	public List<MemberVO> searchList(String sqlid, HashMap<String,String> map) {
		//sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		
		return sqlMap.selectList(sqlid,map);
	}
	
	@Override
	public void insert(String sqlid, MemberVO user) {
		//sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.insert(sqlid,user);
		/* sqlMap.commit(); */
	}

	@Override
	public void update(String sqlid, MemberVO user) {
		//sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.update(sqlid,user);
	}

	@Override
	public MemberVO findById(String sqlid, String id) {
		//sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		return sqlMap.selectOne(sqlid, id);
		
	}

	@Override
	public void delete(String sqlid, String id) {
		//sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.delete(sqlid,id);
	}

	@Override
	public int getCount(String sqlid) {
		//sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		return sqlMap.selectOne(sqlid);
	}
	
	

}
