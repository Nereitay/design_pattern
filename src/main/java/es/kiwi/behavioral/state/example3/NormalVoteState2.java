package es.kiwi.behavioral.state.example3;

/**
 * <p>修改已有功能</p>
 */
public class NormalVoteState2 extends NormalVoteState {
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
        //先调用已有的功能
        super.vote(user, voteItem, voteManager);
        //给予积分奖励，示意一下
        System.out.println("奖励积分10分");
    }
}
