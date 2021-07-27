package org.salim.learn.guli.service.edu.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.salim.learn.guli.service.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author Salim
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("edu_teacher")
@ApiModel(value="Teacher对象", description="讲师")//来自数据库表定义，不知道在API网页中哪里可以显示，代码生成器生成
public class Teacher extends BaseEntity {

    private static final long serialVersionUID=1L;
    //API文档小注解
    @ApiModelProperty(value = "讲师姓名", example = "Salim")//通过example = 来添加例子，API中的数据案例会变成这个值"name": "Salim",
    private String name;

    @ApiModelProperty(value = "讲师简介")
    private String intro;

    @ApiModelProperty(value = "讲师资历,一句话说明讲师")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    @ApiModelProperty(value = "排序")//value是数据库中的数据描述，表中的每列都会有comment属性，创建代码时会把这个属性带入到实体类的value中
    private Integer sort;

    @ApiModelProperty(value = "入驻时间", example = "2021-07-23")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")//为什么properties里面已经有了还要在这里写？那里是全局的设置，这里是个性设置
    private Date joinDate;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
