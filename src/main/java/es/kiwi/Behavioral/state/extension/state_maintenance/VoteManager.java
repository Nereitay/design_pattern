package es.kiwi.Behavioral.state.extension.state_maintenance;


import java.util.HashMap;
import java.util.Map;

/**
 * 投票管理
 */
public class VoteManager {

    private Map<String, String> mapVote = new HashMap<>();

    private Map<String, Integer> mapVoteCount = new HashMap<>();

    private Map<String, VoteState> mapState = new HashMap<>();

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    public Map<String, Integer> getMapVoteCount() {
        return mapVoteCount;
    }

    public Map<String, VoteState> getMapState() {
        return mapState;
    }

    public void vote (String user, String voteItem) {
        Integer oldVoteCount = mapVoteCount.get(user);
        if (oldVoteCount == null)
            oldVoteCount = 0;
        oldVoteCount ++;

        mapVoteCount.put(user, oldVoteCount);

        // 获取该用户的投票状态
        VoteState state = mapState.get(user);
        if (state == null)
            state = new NormalVoteState();

        // 然后转调状态对象来进行操作
        state.vote(user, voteItem, this);
    }
}
