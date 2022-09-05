package es.kiwi.behavioral.state.scenario;

import java.util.HashMap;
import java.util.Map;

/**
 * 投票管理
 * 投票过程，有四种情况：
 *  - 用户是正常投票
 *  - 用户正常投票后，有意或者无意地重复投票
 *  - 用户恶意投票
 *  - 黑名单用户
 *
 *  问题：
 *  1. 如果要修改某种投票情况所对应的具体功能处理，那就需要在那个大杂烩中找到相应的代码块，然后进行改动
 *  2. 如果要添加新的功能，需要改动投票管理的源代码，添加一个else if块进行处理
 *
 */
public class VoteManager {

    private Map<String, String> mapVote = new HashMap<>();

    private Map<String, Integer> mapVoteCount = new HashMap<>();

    public void vote(String user, String voteItem) {
        //1. 先为该用户增加投票的次数
        Integer oldVoteCount = mapVoteCount.get(user);

        if (oldVoteCount == null)
            oldVoteCount = 0;

        oldVoteCount++;
        mapVoteCount.put(user, oldVoteCount);
        //2. 判断该用户投票类型
        if (oldVoteCount == 1) {
            mapVote.put(user, voteItem);
            System.out.println("恭喜你投票成功！");
        } else if (oldVoteCount > 1 && oldVoteCount < 5)
            System.out.println("请不要重复投票");
        else if (oldVoteCount >= 5 && oldVoteCount < 8) {
            String s = mapVote.get(user);
            if (s != null)
                mapVote.remove(user);
            System.out.println("你有恶意刷票行为，取消投票资格");
        } else if (oldVoteCount >= 8)
            System.out.println("进入黑名单， 将禁止登录和使用本系统");
    }
}
