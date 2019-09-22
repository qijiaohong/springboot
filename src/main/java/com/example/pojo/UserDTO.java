package com.example.pojo;

//import tk.mybatis.mapper.annotation.KeySql;
//
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Transient;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name="user")
public class UserDTO extends PaginationRequest{
/**
	 * 
	 */
/*@JsonIgnore*/
@Id
@KeySql(useGeneratedKeys = true)
private Integer id;
//@JsonInclude(Include)
private String name;
private Integer age;
@Transient
//不需要持久化到数据库
private Date birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
