package com.ljl.mall.tiny.nosql.mongodb.repository;

import com.ljl.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 商品浏览记录的Repository
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {

    /**
     * 根据会员的id按时间倒序获取浏览记录
     * @param memberId
     * @return List<MemberReadHistory>
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
