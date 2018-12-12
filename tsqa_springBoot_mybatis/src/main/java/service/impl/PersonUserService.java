package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.IPersonUserService;
import dao.PersonUserDao;
import domain.PersonUserBo;
@Service
public class PersonUserService implements IPersonUserService{
	
	@Autowired
	private PersonUserDao personUserDao;
	
	@Override
	public PersonUserBo queryById(String id) {
		return personUserDao.queryById(id);
	}

	@Override
	public int insertIntoPersonUser(PersonUserBo personUserBo) {
		// TODO Auto-generated method stub
		return personUserDao.insertIntoPersonUser(personUserBo);
	}

	@Override
	public boolean updataPersonUser(PersonUserBo personUserBo) {
		// TODO Auto-generated method stub
		return personUserDao.updataPersonUser(personUserBo);
	}

	@Override
	public boolean deletePersonUser(String userId) {
		// TODO Auto-generated method stub
		return personUserDao.deletePersonUser(userId);
	}

	@Override
	public List<PersonUserBo> getListByCondation(PersonUserBo personUserBo) {
		// TODO Auto-generated method stub
		return personUserDao.getListByCondation(personUserBo);
	}

	@Override
	public List<PersonUserBo> getAllList() {
		return personUserDao.getAllList();
	}

}
