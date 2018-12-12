package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 因为很多的Dao对象都是简单的增删改查功能，所以我们抽象出一个最基本的父类，这个父类实现最基本的增删改查功能，每个新的Dao对象可以继承这个类，
 * 然后自定义实现特殊的数据库访问功能，我们可以把这个基本的父类成为MyBatisHelper并用上泛型
 * 
 * 需要说明的是因为sqlSession的执行回去寻找相应的mapper文件，所以namespace+方法名称很重要，这个一定要注意不要弄错了，
 * 弄错了就会无法正确调用。
 * 
 * @author Administrator
 * 
 * @param <T>
 */
@Component
public class MybatisHelper<T> {
	@Autowired
	private SqlSession sqlSession; // 这里自动注入mybatis的SqlSession
	public MybatisHelper(){};
	private String nameSpace;
	public MybatisHelper(String nameSpace) {
		this.nameSpace = nameSpace;
	}
	public String getSqlName(String sqlName) {
		return nameSpace + "." + sqlName;
	}
	public SqlSession getSqlSession(){
		return this.sqlSession;
	}
	
	
	
	
	//插入一条
	public Integer create(String name, T obj) {
		return sqlSession.insert(getSqlName(name), obj);
	}
	//更新
	public Boolean update(String name, T obj) {
		return Boolean.valueOf(sqlSession.update(getSqlName(name), obj) > 0);
	}
	//由Id查找一条
	public T findById(String name, String id) {
		return sqlSession.selectOne(getSqlName(name), id);
	}

	//由id删除一条
	public Boolean delete(String name, String id) {
		return Boolean.valueOf(sqlSession.delete(getSqlName(name), id) > 0);
	}
	//查询所有
	public List<T> findAll(String name) {
		return sqlSession.selectList(getSqlName(name));
	}
	//按条件查询全部
	public List<T> findListByCondition(String name,T obj){
		return sqlSession.selectList(getSqlName(name), obj);
	}
	
}