package top.danbao.boot.basic.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.danbao.boot.basic.entity.Listsoft1921;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/16 14:08
 * @description:
 */
@Repository
public class Listsoft1921DAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Listsoft1921> listStudents() {
        String sql = "SELECT * FROM `t_list-soft1921` WHERE deleted = 0 ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Listsoft1921.class));

    }

    public List<Listsoft1921> getStudentById(Integer id) {
        String sql = "SELECT * FROM `t_list-soft1921` WHERE id=? and deleted = 0 ";
        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Listsoft1921.class));
    }

    public Listsoft1921 save(Listsoft1921 student) {
        String sql = "INSERT INTO `t_list-soft1921`(id,name,nickname,hometown,constellation,mobile,qq,hobby) VALUES(?,?,?,?,?,?,?,?) ";
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

    public int updateStudent(Listsoft1921 student) {
        String sql = "UPDATE `t_list-soft1921` SET name = ?,qq = ?,hobby = ? WHERE id = ? ";
        Object[] args = {student.getName(), student.getQq(), student.getHobby(), student.getId()};
        return jdbcTemplate.update(sql, args);
    }

    public int deleteStudent(Integer id) {
        String sql = " UPDATE `t_list-soft1921` SET deleted = 1 WHERE id= ? ";
        return jdbcTemplate.update(sql, id);
    }
}