package org.salim.learn.guli.service.edu.controller.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.salim.learn.guli.common.util.result.R;
import org.salim.learn.guli.service.edu.entity.Teacher;
import org.salim.learn.guli.service.edu.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Salim
 * @since 2021-07-07
 */
//Teacher controller会被用于管理页面，所以移到admin包下（后台管理系统）
@RestController//相当于@Controller + @ResponseBody
@RequestMapping("/admin/edu/teacher")//访问路径与用户接触的接口也不同
@Api(tags = "讲师管理")//swagger注解, 解释API
public class TeacherController {
    @Autowired
    private ITeacherService iTeacherService;//service 里面调用mapper的方法

    @GetMapping("list")
    @ApiOperation("列出所有老师")//swagger注解，解释API的具体方法
    public R listAll () {
        List<Teacher> list = iTeacherService.list();
        return R.ok();
        //.ok()是静态方法，可以直接调用，.data()是
        //这个方法会返回一个新建的R对象,将数据以items的key填充到data的map里面。item名字随意
    }

    @DeleteMapping("delete/{id}")//通过请求参数传值
    @ApiOperation(value = "删除老师", notes = "根据id在、删除")
    public R rmById (@ApiParam("老师的ID")//swagger注解，解释参数
                               @PathVariable String id) {
        if (iTeacherService.removeById(id)) {
           return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)//通过请求体传值
    public Boolean rmById2 (@RequestBody String id) {
        return iTeacherService.removeById(id);
    }
}

