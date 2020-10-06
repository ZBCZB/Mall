package com.ljl.mall.tiny.service.impl;


import com.ljl.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.ljl.mall.tiny.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.ljl.mall.tiny.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户浏览记录service的实现类
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {

    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public int creat(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);//id为什么要为空？
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deletelist=new ArrayList<>();
        for(String id:ids){
            MemberReadHistory memberReadHistory=new MemberReadHistory();
            memberReadHistory.setId(id);
            deletelist.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deletelist);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
