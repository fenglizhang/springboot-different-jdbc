package com.zlf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlf.bo.StaffBo;
import com.zlf.service.IStaffService;
@Controller
@RequestMapping(path="/staff",produces="application/json;charset=utf-8")
public class StaffController {
	private static final Logger logger=LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	private IStaffService staffService;
	
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
	
	
	
	
	
	
	
	
	
	
}
