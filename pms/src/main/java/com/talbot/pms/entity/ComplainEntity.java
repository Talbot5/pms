package com.talbot.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@Data
@TableName("complain")
public class ComplainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Date date;
	/**
	 * 
	 */
	private Boolean isret;
	/**
	 * 
	 */
	private OwnerEntity owner;
	/**
	 * 
	 */
	private String retContent;
	/**
	 * 
	 */
	private String title;

}
