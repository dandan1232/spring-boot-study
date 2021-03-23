package top.danbao.boot.basic.service;

import top.danbao.boot.basic.entity.Listsoft1921;

import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/16 14:25
 * @description:
 */
public interface Listsoft1921Service {
    /**
     * 新增一个学生
     * @param student 学生实体
     * @return boolean
     */
    boolean postStudent(Listsoft1921 student);

    /**
     * 查询所有学生
     *
     * @return list
     */
    List<Listsoft1921> getStudentList();

    /**
     * 根据id查询
     * @param id id
     * @return list
     */
    List<Listsoft1921> getStudentById(Integer id);

    /**
     * 根据id删除学生
     *
     * @param id 文章id
     * @return 删除是否成功
     */
    int deleteStudent(int id);


    /**
     * 更新学生
     *
     * @param student student对象
     * @return 更新是否成功
     */
    int updateStudent(Listsoft1921 student);
}



