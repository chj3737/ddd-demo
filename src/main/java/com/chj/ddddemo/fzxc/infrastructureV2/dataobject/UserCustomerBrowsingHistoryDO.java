package com.chj.ddddemo.fzxc.infrastructureV2.dataobject;

import lombok.Data;

@Data
public class UserCustomerBrowsingHistoryDO {
    private String userId;
    private boolean isTrackingEnabled;
    private String custListAsString;
}
