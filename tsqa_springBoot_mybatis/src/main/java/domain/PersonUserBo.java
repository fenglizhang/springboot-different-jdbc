package domain;

import java.sql.Timestamp;

import lombok.Data;

@Data	//lombok插件的注解自动添加get set方法
public class PersonUserBo {

private String	userId ;
private String 	pwd ;
private String	userName;
private String	sex ;
private Timestamp	birth ;
private String	education ;
private String	phone ;
private String	status ;
private String	userLevle ;
private String	enabled ;
private String	managecom ;
private String	saleCom ;
private Timestamp	createTime ;
private String	createPeople ;
private Timestamp	editTime ;
private String	editPeople ;
	
	
}
