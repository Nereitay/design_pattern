package es.kiwi.behavioral.state.example5;


public class SpiteVoteState implements VoteState {
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
        //恶意投票
        //取消用户的投票资格，并取消投票记录
        String s = voteManager.getMapVote().get(user);
        if (s != null) {
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷票行为，取消投票资格");

        //恶意投票完成，维护下一个状态，投票到8次，就进黑名单了
        //注意这里是判断大于等于7，因为这里设置的是下一个状态
        //下一个操作次数就是8了，就应该算是进黑名单了
        if (voteManager.getMapVoteCount().get(user) >= 7) {
//            voteManager.getMapState().put(user, new BlackVoteState());
            /*直接把下一个状态的编码记录到数据库就可以了*/
        }
    }
}
