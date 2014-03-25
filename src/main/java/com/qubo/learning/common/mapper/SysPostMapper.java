package com.qubo.learning.common.mapper;

import com.qubo.learning.common.model.SysPost;
import com.qubo.learning.common.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Qubo_Song on 3/17/14.
 */
public interface SysPostMapper {

    @Select("select count(*) from sys_post")
    public int getTotalPostsCount();

    @Select("select * from sys_post")
    //@Select("select p.post_id, p.post_title, p.post_content, u.user_id, u.user_name, p.post_time, p.last_modified_time from sys_post as p inner join sys_user as u on p.user_id = u.user_id")
    @Results(
            @Result(property = "user", column = "user_id", javaType = SysUser.class,
                    one = @One(select = "com.qubo.learning.common.mapper.SysUserMapper.getUserById"))
    )
    public List<SysPost> getAllPosts();

    @Select("select * from sys_post where post_id = #{post_id}")
    @Results(
            @Result(property = "user", column = "user_id", javaType = SysUser.class,
                    one = @One(select = "com.qubo.learning.common.mapper.SysUserMapper.getUserById"))
    )
    public SysPost getPostById(@Param("post_id") int postId);

    @Insert("insert into sys_post values(default, #{post_title}, #{post_content}, #{user_id}, #{post_time}, #{last_modified_time})")
    public void newPost(@Param("post_title") String postTitle,
                        @Param("post_content") String postContent,
                        @Param("user_id") int userId,
                        @Param("post_time") Timestamp postTime,
                        @Param("last_modified_time") Timestamp lastModifiedTime);

}
