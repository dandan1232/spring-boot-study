package top.danbao.boot.basic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.danbao.boot.basic.dao.StudentDAO;
import top.danbao.boot.basic.entity.Student;
import top.danbao.boot.basic.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/16 14:34
 * @description:
 */
@Service

public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDAO studentDAO;

    @Override
    public boolean postStudent(Student student){
        Student saveStudent =studentDAO.save(student);
        return saveStudent != null;
    }

    //@Transactional
    @Override
    public List<Student> getStudentList() {

        return studentDAO.listStudents();
    }


    @Override
    public List<Student> getStudentById(Integer id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public int deleteStudent(int id) {
        return studentDAO.deleteStudent(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }
}