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
 * @date 2020-05-28 22:12:43
 */
@Data
@TableName("menu")
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String url;
	/**
	 * 
	 */
	private String path;
	/**
	 * 菜单组件
	 */
	private String component;
	/**
	 * 菜单名字
	 */
	private String name;
	/**
	 * 菜单图标
	 */
	private String iconcls;
	/**
	 * 
	 */
	private Integer keepAlive;
	/**
	 * 要求权限
	 */
	private Integer requireAuth;
	/**
	 * 父级菜单
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private Integer enabled;

}
