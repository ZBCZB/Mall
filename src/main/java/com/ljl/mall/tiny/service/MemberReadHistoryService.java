package com.ljl.mall.tiny.service;


import com.ljl.mall.tiny.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

public interface MemberReadHistoryService {
    /**
     * 创建浏览记录
     * @param memberReadHistory
     * @return
     */
    int creat(MemberReadHistory memberReadHistory);

    /**
     * 清除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 获取当前用户的浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> list(Long memberId);
}
