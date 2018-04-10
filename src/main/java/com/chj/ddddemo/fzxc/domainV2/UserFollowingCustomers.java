package com.chj.ddddemo.fzxc.domainV2;

import com.chj.ddddemo.common.domain.Aggregate;

import java.util.List;

public class UserFollowingCustomers implements Aggregate {
    private String userId;
    private List<String> customerList;
    private static final int MAX_CUSTOMERS = 30;

    public void followCustomer(String custId) {
        // handle exceed max customer,
        // which is different from UserCustomerBrowsingHistory handling
        // which just delete some cust
        if (customerList.contains(custId))
            return ;
        if (customerList.size() >= MAX_CUSTOMERS) {
            throw new IllegalStateException("exceed maximum follow customers");
        }
        customerList.add(custId);
    }

    public void unfollowCustomer(String custId) {
        customerList.remove(custId);
    }

    // to allow user to adjust ordering of following customers
    // and with careful thought，we cannot simply replace the following list by the newList,
    // as the the list may be changed along with customer id added or deleted

    public void replaceFollowingListWith(List<String> newList) {
        // --- bad implementation
        // customerList = Lists.newArrayList(customerList);
        // -- one possible but not quite elegant implementation
        for (String customerId : customerList) {
            unfollowCustomer(customerId);
        }
        for (String customerId: newList)
            followCustomer(customerId);

        // or maybe we should just provide a method named changeOrderFrom(customerId, newOrder)
        // referenced IDDD implementation of BacklogItem.java
    }







}
