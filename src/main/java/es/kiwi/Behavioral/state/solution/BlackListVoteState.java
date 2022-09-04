package es.kiwi.Behavioral.state.solution;

public class BlackListVoteState implements VoteState{
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //黑名单
        //记入黑名单，禁止登录系统
        System.out.println("进入黑名单， 将禁止登录和使用本系统");
    }
}
