package top.danbao.boot.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.danbao.boot.basic.controller.dto.AjaxResponse;
import top.danbao.boot.basic.entity.Article;
import top.danbao.boot.basic.entity.Student;
import top.danbao.boot.basic.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/16 18:01
 * @description:
 */
@RestController
@RequestMapping(value = "api/v1/student")
@Slf4j
@Api(tags = "学生管理")
@Validated
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     * 查询所有文章
     */
    @ApiOperation(value = "查询所有学生", notes = "查询所有学生")
    @GetMapping("all")
    public AjaxResponse selectStudents() {
        List<Student> StudentList = studentService.getStudentList();
        return AjaxResponse.success(StudentList);
    }

    @GetMapping
    @ApiOperation("获取指定编号学生信息")
    public AjaxResponse getById(
            @ApiParam("查询学生编号")
            @RequestParam int id) {
        return AjaxResponse.success(studentService.getStudentById(id), "查询成功");
    }

    @PutMapping()
    @ApiOperation("修改学生信息")
    public AjaxResponse updateStudent(@RequestBody Student student){
        return AjaxResponse.success(studentService.updateStudent(student),"ok");
    }

    @DeleteMapping()
    @ApiOperation("删除学生")
    public AjaxResponse deleteById(
            @RequestParam int id) {
        return AjaxResponse.success(studentService.deleteStudent(id), "删除成功");
    }

}