package es.kiwi.behavioral.mediator;

import es.kiwi.behavioral.mediator.extension.generalized_mediator.Dep;
import es.kiwi.behavioral.mediator.extension.generalized_mediator.DepUserMediatorImpl;
import es.kiwi.behavioral.mediator.extension.generalized_mediator.User;
import es.kiwi.behavioral.mediator.solution.*;

public class Client {
    public static void main(String[] args) {
        //使用中介者模式
//        mediator();

        // 广义中介者
        simplifiedMediator();


    }

    /*
        简化中介这模式：
            - 通常会去掉同时对象的父类，这样可以让任意的对象，只要需要交互，就可以成为同事
            - 通常不定义Mediator接口，把具体的中介者对象实现成为单例
            - 同时对象不再持有中介者，而是在需要的时候直接获取中介者对象并调用；中介者也不再持有同事对象，而是在具体处理方法里面去创建
                或者获取，或者从参数传入需要的同事对象
     */
    private static void simplifiedMediator() {
        DepUserMediatorImpl mediator = DepUserMediatorImpl.getInstance();
        //准备需要撤销的部门，仅仅需要一个部门编号
        Dep dep = new Dep();
        dep.setDepId("d1");
        Dep dep2 = new Dep();
        dep2.setDepId("d2");
        //准备用于测试的人员，也只需要一个人员编号
        User user = new User();
        user.setUserId("u1");

        //测试撤销部门，在运行之前，输出一下，看这个人员属于哪些部门
        System.out.println("撤销部门前---------------------");
        mediator.showUserDeps(user);
        //真正执行业务，撤销这个部门
        dep.deleteDep();
        //再次输出一下，看这个人员属于哪些部门
        System.out.println("撤销部门后-----------------------");
        mediator.showUserDeps(user);

        System.out.println("-------------------------------");
        System.out.println("人员离职前----------------------");
        mediator.showDepUsers(dep2);
        //真正执行业务，人员离职
        user.dimission();
        //再次输出一下，看这个部门下都有哪些人员
        System.out.println("人员离职后----------------------");
        mediator.showDepUsers(dep2);
    }

    private static void mediator() {
        //1. 创建中介者-主板对象
        MainBoard mediator = new MainBoard();

        //2.创建同事类
        CDDriver cd = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard videoCard = new VideoCard(mediator);
        SoundCard soundCard = new SoundCard(mediator);

        //3.让中介者知道所有的同事
        mediator.setCdDriver(cd);
        mediator.setCpu(cpu);
        mediator.setVideoCard(videoCard);
        mediator.setSoundCard(soundCard);

        //4.开始看电影，把光盘放入光驱，光驱开始读盘
        cd.readCD();
    }
}
