package com.chj.ddddemo.fzxc.domain;

import com.chj.ddddemo.infrastructure.IKeyValueStore;

public class FxzcFollowingCustRepository {
    IKeyValueStore<String> store;
    // inject a converter to translate domain object to entity DO，
    // it may simply invoke the basic Converter.collectionToString()/collectionToJson等就可以

    // FIXME: 似乎 keyValueStore也不是很有必要，因为不同的store,它的key也不一样，因为
    // 都要有一个prefix，这样，存储不同的对象，需要指定不同的prefix，本质上要new不同的keyvaluestore实例
    // 没有办法做到全局只有一个实例通用（

    public IHandleFollowingCust ofId(String userId) {
        return null;
    }

    // FIXME: 问题，这样的话，不知道userId是谁
    // 此外，还有一个queue <=> value 的转换，这个在哪里做？
    // 这个本质上只是一个converter，即 Collection 跟 String的转换
    // 因此，实现一个工具类就可以


    public void save(IHandleFollowingCust followingCust) {
        // FIXME: 如果后面不是FxzcUser这个实现类怎么办？
        // 比如，对于RecentCust来说，本质上它是记录用户的访问行为，那么可能它后面
        // 会移到跟其它的像记录最近访问时间等信息放到一起，叫做UserTracking，那么
        // 这时候，就需要调整这里的实现，那么显然那就是不好的了
        String userId = ((FxzcUser)followingCust).userId();
        String value = ""; // use converter to convert to DO
        store.set(userId, value );
    }
}
