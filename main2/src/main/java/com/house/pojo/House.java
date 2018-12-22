package com.house.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

//房屋信息表
@Setter
@Getter
public class House {
	private static final long serialVersionUID = 1L;

	private Integer hmid;

	private User user;// 房屋拥有者

	private Street street;

	private District district;

	private Type type;

	private double price;

	private String area;

	private String topic;

	private String contents;

	private Date htime;

	private String copy;

}
