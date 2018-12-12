package com.zlf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zlf.bo.User;
@Repository//用于标注数据访问组件，即DAO组件
public interface UserRepository extends JpaRepository<User,Integer> {

}
