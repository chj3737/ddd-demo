package com.chj.ddddemo.common.domain;

public interface DomainObjectConverter<O, D> {
    D objectToDO(O doaminObject);

    O DOToObject(D dataObject);
}
