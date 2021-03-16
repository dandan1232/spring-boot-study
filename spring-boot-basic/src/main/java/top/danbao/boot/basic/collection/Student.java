package top.danbao.boot.basic.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :蛋宝
 * @date :2021/3/11
 * @description :学生类实现comparable<E>接口
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Comparable<Student>{
    private String name;
    private Integer age;

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
