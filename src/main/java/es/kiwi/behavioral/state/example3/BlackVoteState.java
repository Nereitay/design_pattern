package es.kiwi.behavioral.state.example3;

public class BlackVoteState implements VoteState {
    /**
     * 处理状态对应的行为
     *
     * @param user        投票人
     * @param voteItem    投票项
     * @param voteManager 投票上下文，用来在实现状态对应的功能处理的时候，
     *                    可以回调上下文的数据
     */
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //黑名单
        //记入黑名单中，禁止登录系统了
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}
