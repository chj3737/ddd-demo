package com.chj.ddddemo.fzxc.domainV2.activity;

import com.chj.ddddemo.common.domain.DomainObjectConverter;
import com.chj.ddddemo.common.helper.ListStringConverter;
import com.chj.ddddemo.fzxc.infrastructureV2.dataobject.UserCustomerBrowsingHistoryDO;

/**
 * FIXME: should be placed in package of infrastructure, but to provide access to domain object's
 * default methods, keep it here.
 */
public class UserCustomerBrowsingHistoryConverter implements DomainObjectConverter<UserCustomerBrowsingHistory, UserCustomerBrowsingHistoryDO> {

    @Override
    public UserCustomerBrowsingHistoryDO objectToDO(UserCustomerBrowsingHistory doaminObject) {
        return null;
    }

    @Override
    public UserCustomerBrowsingHistory DOToObject(UserCustomerBrowsingHistoryDO dataObject) {
        UserCustomerBrowsingHistory cust = new UserCustomerBrowsingHistory();
        cust.setRecordHistoryEnabled(dataObject.isTrackingEnabled());
        cust.setUserId(dataObject.getUserId());
        cust.setCustList(ListStringConverter.stringToDeque(dataObject.getCustListAsString()));
        return cust;
    }
}
