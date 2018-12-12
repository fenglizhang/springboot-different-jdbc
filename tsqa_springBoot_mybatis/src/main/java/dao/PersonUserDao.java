package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import domain.PersonUserBo;

@Component
public class PersonUserDao extends MybatisHelper<PersonUserBo> {

	private  final static String spaceName="mapper.PersonUserMapper";
	
	public PersonUserDao() {
		super(spaceName);
	}
	//按id查询出一个
	public PersonUserBo queryById(String id){
		PersonUserBo personUserBo = findById("findById",id);
		return personUserBo;
	}
	//新增一条
	public int insertIntoPersonUser(PersonUserBo personUserBo){
		return create("insertIntoPersonUser", personUserBo);
	}
	
	//修改一条
	public boolean updataPersonUser(PersonUserBo personUserBo){
		return update("updatePeoperUser", personUserBo);
	}
	//删除一条
	public boolean deletePersonUser(String userId){
		return delete("deletePersonUser", userId);
	}
	//按条件查询符合条件的集合
	public List<PersonUserBo> getListByCondation(PersonUserBo personUserBo){
		return findListByCondition("findPeopleUserListByCondation", personUserBo);
	}
	
	//查询所有
	public List<PersonUserBo> getAllList(){
		return findAll("findAll");
	}
	
	
}
