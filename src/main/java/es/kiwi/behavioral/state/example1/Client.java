package es.kiwi.behavioral.state.example1;

public class Client {

    public static void main(String[] args) {
        VoteManager vm = new VoteManager();
        for (int i = 0; i < 8; i++) {
            vm.vote("u1", "A");
        }
    }
}
/*
 * 问题： vote()中判断过多，添加新功能需要改动源码
 * 需要容易地添加新功能并修改已有功能
 *
 */
