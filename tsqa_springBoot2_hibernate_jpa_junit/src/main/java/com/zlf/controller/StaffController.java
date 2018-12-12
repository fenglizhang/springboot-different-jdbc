package com.zlf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlf.bo.StaffBo;
import com.zlf.service.IStaffService;
@Controller
@RequestMapping(path="/staff",produces="application/json;charset=utf-8")
public class StaffController {
	private static final Logger logger=LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	private IStaffService staffService;
	
	
	/*** 
     * 根据用户id，获取用户信息 
     * @param id 
     * @return 
     */ 
	@ResponseBody
    @RequestMapping(value="getuserById", method=RequestMethod.GET)    
    public Object getUser(String id){
    	StaffBo staffBo = staffService.getStaffBoById(id);
    	return staffBo;
    }   
	
	//查询所有
	@RequestMapping("/getList")
	@ResponseBody
	public List<StaffBo> getAllList(){
		List<StaffBo> staffList=null;
		try {
			staffList = staffService.queryAllStaffList();
		} catch (Exception e) {
			logger.error("查询失败");
		}
		return staffList;
	}
	/*** 
     * 新增用户信息 
     * @param userEntity 
     * @return 
     */ 
    @RequestMapping(value="/adduser", method=RequestMethod.POST) 
    @ResponseBody
	public StaffBo addStaff(@RequestAttribute(value="staff") StaffBo staff){
//    	 StaffBo sta = new StaffBo();  
//         sta.setName("testuser2");  
//         sta.setAge(29);  
//         sta.setId("4"); 
		return staffService.addStaffBo(staff);
	}
	
	
	/*** 
     * 更新用户信息 
     * @param userEntity 
     * @return 
     */  
    @Modifying  
    @RequestMapping(value="/updatauser", method=RequestMethod.POST)  
	public void updataStaff(@RequestBody StaffBo sta){
    	staffService.updataStaffBo(sta);
	}
	
    /*** 
     * 删除用户 
     * @param id 
     * @return 
     */
    @Modifying    
    @RequestMapping(value="deleteuser", method=RequestMethod.DELETE)     
    public void deleteUser(@RequestBody StaffBo sta){
    	staffService.deleteStaffBo(sta);
    	
    }   
	
	
	
}
