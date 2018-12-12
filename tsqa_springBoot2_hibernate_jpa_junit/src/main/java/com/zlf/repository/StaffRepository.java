package com.zlf.repository;

import org.springframework.data.repository.CrudRepository;

import com.zlf.bo.StaffBo;

public interface StaffRepository extends CrudRepository<StaffBo,String> {

}
