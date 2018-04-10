package com.chj.ddddemo.fzxc.domain;

import java.util.List;

public interface IHandleFollowingCust {
    List<String> allFollowingCusts();

    /**
     * 原本叫addFollowingust，发现不合适，应该叫followCust更合适
     * @param custId
     */
    void followCust(String custId);

    void unfollowCust(String custId);

    void replaceFollowingCusts(List<String> custList);
}
