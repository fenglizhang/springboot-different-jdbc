package com.zlf.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zlf.bo.StaffBo;

public interface StaffRepository extends PagingAndSortingRepository<StaffBo,String> {

}
