package com.bbs.dao;

import com.bbs.domain.Upvote;
import com.bbs.domain.UpvoteExample;
import com.bbs.domain.UpvoteKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpvoteDao {
    int countByExample(UpvoteExample example);

    int deleteByExample(UpvoteExample example);

    int deleteByPrimaryKey(UpvoteKey key);

    int insert(Upvote record);

    int insertSelective(Upvote record);

    List<Upvote> selectByExample(UpvoteExample example);

    Upvote selectByPrimaryKey(UpvoteKey key);

    int updateByExampleSelective(@Param("record") Upvote record, @Param("example") UpvoteExample example);

    int updateByExample(@Param("record") Upvote record, @Param("example") UpvoteExample example);

    int updateByPrimaryKeySelective(Upvote record);

    int updateByPrimaryKey(Upvote record);
}