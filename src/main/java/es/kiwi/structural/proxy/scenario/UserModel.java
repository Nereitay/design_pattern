package es.kiwi.structural.proxy.scenario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 描述用户数据的对象
 */
@Getter
@Setter
@ToString
public class UserModel {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 部门编号
     */
    private String depId;
    /**
     * 性别
     */
    private String sex;
}
