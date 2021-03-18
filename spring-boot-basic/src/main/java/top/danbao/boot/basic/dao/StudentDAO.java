package top.danbao.boot.basic.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.danbao.boot.basic.entity.Student;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/16 14:08
 * @description:
 */
@Repository
public class StudentDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Student> listStudents() {
        String sql = "SELECT * FROM t_student WHERE deleted = 0 ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

    }

    public List<Student> getStudentById(Integer id) {
        String sql = "SELECT * FROM t_student WHERE id=? and deleted = 0 ";
        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
    }

    public Student save(Student student) {
        String sql = "INSERT INTO t_student(id,name,nickname,hometown,constellation,mobile,qq,hobby) VALUES(?,?,?,?,?,?,?,?) ";
        Object[] args = {student.getId(), student.getName(), student.getNickname(),
                student.getHometown(), student.getBirthday(), student.getConstellation(), student.getMobile()
                , student.getQq(), student.getHobby()};
        int count = jdbcTemplate.update(sql, args);
        if (count == 1) {
            return student;
        } else {
            return null;
        }
    }

    public int updateStudent(Student student) {
        String sql = "UPDATE t_student SET name = ?,qq = ?,hobby = ? WHERE id = ? ";
        Object[] args = {student.getName(), student.getQq(), student.getHobby(), student.getId()};
        return jdbcTemplate.update(sql, args);
    }

    public int deleteStudent(Integer id) {
        String sql = " UPDATE t_student SET deleted = 1 WHERE id= ? ";
        return jdbcTemplate.update(sql, id);
    }
}