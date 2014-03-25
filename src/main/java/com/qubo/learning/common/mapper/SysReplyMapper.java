package com.qubo.learning.common.mapper;

import com.qubo.learning.common.model.SysPost;
import com.qubo.learning.common.model.SysReply;
import com.qubo.learning.common.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Qubo_Song on 3/25/14.
 */
public interface SysReplyMapper {

    @Select("select * from sys_reply where post_id =  #{post_id}")
    @Results(value = {
            @Result(property = "post", column = "post_id", javaType = SysPost.class,
                    one = @One(select = "com.qubo.learning.common.mapper.SysPostMapper.getPostById")),
            @Result(property = "user", column = "user_id", javaType = SysUser.class,
                    one = @One(select = "com.qubo.learning.common.mapper.SysUserMapper.getUserById"))}
    )
    public List<SysReply> getAllRepliesByPostId(@Param("post_id") int PostId);

    @Insert("insert into sys_reply values (default, #{post_id}, #{reply_content}, #{user_id}, #{post_time})")
    public void newReply(@Param("post_id") int postId,
                         @Param("reply_content") String replyContent,
                         @Param("user_id") int userId,
                         @Param("post_time") Timestamp postTime);
}
