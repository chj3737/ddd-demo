package com.chj.ddddemo.fzxc.domainV2.activity;

import com.chj.ddddemo.common.domain.Aggregate;
import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// use package level accessor to allow UserCustomerBrowsingHistoryConverter to
// access the private fields while not exposing to the outside world
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UserCustomerBrowsingHistory implements Aggregate {
    private String userId;
    private boolean isRecordHistoryEnabled;
    private Deque<String> custList;
    private static final int MAX_TRACK_CUSTS = 10; // can be obtained from a config value

    public UserCustomerBrowsingHistory(String userId, boolean isRecordHistoryEnabled) {
        this.userId = userId;
        this.isRecordHistoryEnabled = isRecordHistoryEnabled;
        setCustList(new LinkedList<>());
    }

    public boolean isTrackingEnabled() {
        return isRecordHistoryEnabled;
    }

    public void enableTracking() {
        isRecordHistoryEnabled = true;
    }

    public void disableTracking() {
        isRecordHistoryEnabled = false;
    }

    public boolean addActivity(String custID) {
        if (!isTrackingEnabled())
            return false;

        custList.remove(custID);
        custList.addFirst(custID);
        while (custList.size() > MAX_TRACK_CUSTS) {
            custList.removeLast();
        }
        return true;
    }

    public void removeActivity(String custID) {
        custList.remove(custID);
    }

    public List<String> currentTrackedActivities() {
        if (isTrackingEnabled())
            return Lists.newArrayList(custList);
        else
            return Lists.newArrayList();
    }
}
