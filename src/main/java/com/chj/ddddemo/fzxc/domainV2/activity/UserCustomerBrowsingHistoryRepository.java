package com.chj.ddddemo.fzxc.domainV2.activity;

import com.chj.ddddemo.common.domain.Repository;

public interface UserCustomerBrowsingHistoryRepository extends Repository {
    void save(UserCustomerBrowsingHistory userCustomerBrowsingHistory) ;

    UserCustomerBrowsingHistory ofId(String userId) ;
}
