package es.kiwi.behavioral.mediator.extension.generalized_mediator;

import lombok.Getter;
import lombok.Setter;

/**
 * 人员类
 */
@Getter
@Setter
public class User {
    /**
     * 人员编号
     */
    private String userId;
    /**
     * 人员名称
     */
    private String userName;

    /**
     * 人员离职
     * @return 是否处理成功
     */
    public boolean dimission() {
        //1. 要先通过中介者去除掉所有与这个人员的相关部门和人员的关系
        DepUserMediatorImpl mediator = DepUserMediatorImpl.getInstance();
        mediator.deleteUser(userId);
        //2. 然后才能真正地清除掉这个人员
        //请注意在实际开发中，这些业务功能可能会做到业务层去，而且实际开发中对于已经使用地业务数据通常是不会被删除的而是会被作为历史数据保留
        return true;
    }

}
