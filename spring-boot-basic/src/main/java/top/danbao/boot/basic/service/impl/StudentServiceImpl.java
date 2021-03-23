package top.danbao.boot.basic.service.impl;

import org.springframework.stereotype.Service;
import top.danbao.boot.basic.dao.Listsoft1921DAO;
import top.danbao.boot.basic.entity.Listsoft1921;
import top.danbao.boot.basic.service.Listsoft1921Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/16 14:34
 * @description:
 */
@Service

public class StudentServiceImpl implements Listsoft1921Service {
    @Resource
    private Listsoft1921DAO studentDAO;

    @Override
    public boolean postStudent(Listsoft1921 student){
        Listsoft1921 saveStudent =studentDAO.save(student);
        return saveStudent != null;
    }

    //@Transactional
    @Override
    public List<Listsoft1921> getStudentList() {

        return studentDAO.listStudents();
    }


    @Override
    public List<Listsoft1921> getStudentById(Integer id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public int deleteStudent(int id) {
        return studentDAO.deleteStudent(id);
    }

    @Override
    public int updateStudent(Listsoft1921 student) {
        return studentDAO.updateStudent(student);
    }
}