package com.talbot.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@Data
@TableName("owner")
public class OwnerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer id;
    /**
     *
     */
    private Integer age;
    /**
     *
     */
    private String carId;
    /**
     *
     */
    private String carType;
    /**
     *
     */
    private Integer gender;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String password;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private String profession;
    /**
     *
     */
    private String username;
    private List<AccountEntity> accountList;
    private List<LostEntity> lostList;
    private List<CarPositionEntity> carPositionList;
    private List<HouseEntity> houseList;
    private List<ComplainEntity> complainList;
    private List<RepairEntity> repairList;

}
