package com.chj.ddddemo.fzxc.application;

import com.chj.ddddemo.fzxc.domainV2.activity.UserCustomerBrowsingHistory;
import com.chj.ddddemo.fzxc.domainV2.activity.UserCustomerBrowsingHistoryRepository;

public class UserCustomerBrowsingHistoryApplicationService {
    private UserCustomerBrowsingHistoryRepository repo;

    public void addCustomerBrowsed(String userId, String custId) {
        UserCustomerBrowsingHistory history = repo.ofId(userId);
        if (history == null) {
            history = new UserCustomerBrowsingHistory(userId, true);
        }
        if(history.addActivity(custId))
            repo.save(history);
    }
}
