package service;

import java.util.List;

import domain.PersonUserBo;

public interface IPersonUserService {
		//按id查询出一个
		public PersonUserBo queryById(String id);
		//新增一条
		public int insertIntoPersonUser(PersonUserBo personUserBo);
		//修改一条
		public boolean updataPersonUser(PersonUserBo personUserBo);
		//删除一条
		public boolean deletePersonUser(String userId);
		//按条件查询符合条件的集合
		public List<PersonUserBo> getListByCondation(PersonUserBo personUserBo);
		//查询所有
		public List<PersonUserBo> getAllList();
}
