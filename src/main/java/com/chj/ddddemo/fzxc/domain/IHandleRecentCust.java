package com.chj.ddddemo.fzxc.domain;

import java.util.List;

public interface IHandleRecentCust  {
    List<String> allRecentCusts();

    void addRecentCust(String custId);

    void deleteRecentCust(String custId);

    void replaceRecentCusts(List<String> custList);
}
