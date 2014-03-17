package com.qubo.learning.common.mapper;

import com.qubo.learning.common.model.SysPost;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Qubo_Song on 3/17/14.
 */
public interface SysPostMapper {

    @Select("select count(*) from sys_post")
    public int getTotalPostsCount();

    //@Select("select * from sys_post")
    @Select("select p.post_id, p.post_title, p.post_content, u.user_id, u.user_name, p.post_time, p.last_modified_time from sys_post as p inner join sys_user as u on p.user_id = u.user_id")
/*    @Results(
            @Result(property = "post_id", column = {"user_id", })
    )*/
    public List<SysPost> getAllPosts();

}
