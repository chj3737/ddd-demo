package com.chj.ddddemo.fzxc.domain;

import com.chj.ddddemo.common.domain.Entity;

import java.util.List;
import java.util.Queue;

/**
 * FIXME: 这样实现下来的好处是什么？跟对应的fxzcBiz有什么区别？
 * 似乎最大的好处，就是这里面不用关心底层的存储结构，对象本身只要考虑业务上的操作就可以，对不对
 * 而生产上的版本，在biz里面还要注入dao对象，还要考虑怎么把list转换为value以及value转换回来
 * 相对来说，业务上的代码就很不清楚了，你让业务专家来看，他也不知道为什么biz里面要有listToIds，
 * 或是idsToList
 */
public class FxzcUser implements IHandleFollowingCust, IHandleRecentCust, Entity {
    private String userId;
    private String userName;
    private Queue<String> followingCusts;
    private Queue<String> recentCusts;


    /**
     * FIXME: 有可能出现返回的时候使用IHandleFollowingCust接口，
     * 但是使用的是IHandlerRecentCust接口进行对象状态的修改吗？
     * 本质上不应该，因为接口的目的，就是屏蔽实现的细节，你不应该知道我后面是一个对象还是两个对象来实现你的接口
     * @return
     */
    @Override
    public List<String> allFollowingCusts() {
        return null;
    }

    @Override
    public void followCust(String custId) {
    }

    @Override
    public void unfollowCust(String custId) {

    }

    @Override
    public void replaceFollowingCusts(List<String> custList) {

    }

    @Override
    public List<String> allRecentCusts() {
        return null;
    }

    @Override
    public void addRecentCust(String custId) {

    }

    @Override
    public void deleteRecentCust(String custId) {

    }

    @Override
    public void replaceRecentCusts(List<String> custList) {

    }

    public String userId() {
        return userId;
    }



}
