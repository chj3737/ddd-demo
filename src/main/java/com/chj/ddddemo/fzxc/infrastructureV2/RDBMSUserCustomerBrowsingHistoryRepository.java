package com.chj.ddddemo.fzxc.infrastructureV2;

import com.chj.ddddemo.common.domain.DomainObjectConverter;
import com.chj.ddddemo.fzxc.domainV2.activity.UserCustomerBrowsingHistory;
import com.chj.ddddemo.fzxc.domainV2.activity.UserCustomerBrowsingHistoryRepository;
import com.chj.ddddemo.fzxc.infrastructureV2.dataobject.UserCustomerBrowsingHistoryDO;

public class RDBMSUserCustomerBrowsingHistoryRepository implements UserCustomerBrowsingHistoryRepository {
    private DomainObjectConverter<UserCustomerBrowsingHistory, UserCustomerBrowsingHistoryDO> converter;

    @Override
    public void save(UserCustomerBrowsingHistory userCustomerBrowsingHistory) {

    }

    /**
     * FIXME：想到的几种方案，
     * 1. 目前来看，转换到DO的操作，即使不是由repository来做，也应该放在Infrastructure来做
     * 2. 可以通过 Aggregate自身的static .recreateFrom();
     * 3. 放开setter方法
     * 4. 其实这里面的一个问题是，其实还是需要明确的知道是创建一个新对象，还是通过aggregate反向回来，
     * 如果是正常的不用转换，那么本身可以不用关心，因为框架一般都是支持反射调用，但如果是值之间需要
     * 做转换的，那么，就要确认，什么参数的构造函数需要发送领域事件（新对象创建），什么样的构造函数不需要
     * (通过repository重新生成) --- 比如Product.java
     *      * -- 回过头来看，这个问题应该不存在，因为本身两种构造函数的话，带参数的构造函数，
     *      是为了给客户端使用的，而不带参数的构造函数，是为了反构造的时候用的（比如DO到domain object
     *      的转换，后者一般同时配合setter方法使用）
     * 5. 把assembler跟object放在一个package下面
     * 6. 按照domain object的公有接口，使用addXX等方法从新构造domain object。这个明显不是好方法，
     * 因为很可能这些操作是会触发event的。
     * 7. 使用assembler扩展domain object的方法来获取protected权限
     * 8. 使用现成的框架将两个类中，相同字段的属性作直接拷贝
     * https://stackoverflow.com/questions/1432764/any-tool-for-java-object-to-object-mapping。
     * 需要注意的：1. null 时的处理；2. 增加对不同类型转换的映射，比如这里的String <-> List
     * 9. 目前来看，最好的办法，应该还是反射。而使用反射的方法，目前来看，还是自己写一个bean属性的复制类
     * 最有可移植性，其实现上，可以使用上面提到现有工具类，也可以是自己写的。那么，这样的话，
     * 对于domain object 来说，应该只要定义private的 constructor跟private 的setter就可以
     * . 目前来看，大部分情况下，如果有不符合需求的情况，都还是自己实现吧（）
     * -- 另外，可以考虑在DO中，也是使用list<>跟domain object对应，只是repository 本身操作do的时候
     * 做转换（而不是在DO本身做）
     * @param userId
     * @return
     */
    @Override
    public UserCustomerBrowsingHistory ofId(String userId) {
        // get data object from Database
        // may return a Map<> or a DTO
        UserCustomerBrowsingHistoryDO custDo = new UserCustomerBrowsingHistoryDO();
        UserCustomerBrowsingHistory userCustomerBrowsingHistory = converter.DOToObject(custDo);
        return userCustomerBrowsingHistory;
    }
}
