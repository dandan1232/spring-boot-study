package top.danbao.boot.basic;

/**
 * @author: 蛋宝
 * @date: 2021/3/9 8:41
 * @description:
 */
public class toString {
    public static void main(String[] args){
        String name="111.11.jpg";
        int index = name.lastIndexOf(".");
        System.out.println(index);
        System.out.println(name.substring(index));
    }
}