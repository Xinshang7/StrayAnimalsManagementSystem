package com.HexTechGDUT.po.animal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 对动物的评论
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Comment")
@TableName("comment")
public class Comment {

    /**
     * 评论id
     */
    @TableId("id")
    private int id;

    /**
     * 评论所属的动物id
     */
    @TableField("animal_record_id")
    private String animalRecordId;

    /**
     * 发布评论的用户id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 评论的具体内容
     */
    @TableField("content")
    private String content;

    /**
     * 若该评论为另一条评论的子评论
     * 该属性记录该评论的父评论
     */
    @TableField("previous_comment_id")
    private String previousCommentId;

    /**
     * 该评论的子评论
     */
    @TableField(exist = false)
    private List<Comment> commentList;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

}
