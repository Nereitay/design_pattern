package es.kiwi.Behavioral.state.extension.state_maintenance;

public class MaliciousVote implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // 恶意投票
        //取消用户的投票资格，并取消投票纪录
        String s =  voteManager.getMapVote().get(user);
        if (s != null)
            voteManager.getMapVote().remove(user);
        System.out.println("你有恶意刷票行为，取消投票资格");

        //恶意投票完成，维护下一个状态，投票到8次，就进黑名单
        //注意这里是判断大于等于7，因为这里设置的是下一个状态
        //下一个操作次数就是8了，就应该进黑名单了
        if (voteManager.getMapVoteCount().get(user) >= 7) {
            //voteManager.getMapState().put(user, new BlackListVoteState());
            voteManager.getMapState().put(user, new BlackListWarnVoteState());
        }
    }
}
