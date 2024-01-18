package cc.ehan.framework.mybatis.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Author ZhangZhiYong
 */
@Data
@Accessors(chain = true)
public class BaseEntity {

    @Id
    private Long id;

    private Long createdUserId;

    private String createdUserName;

    private LocalDateTime createdTime;

    private Long updatedUserId;

    private String updatedUserName;

    private LocalDateTime updatedTime;

    @Column(isLogicDelete = true)
    private Boolean deleted;

//    public Long getId() {
//        return id;
//    }
//
//    public T setId(Long id) {
//        this.id = id;
//        return (T) this;
//    }
//
//    public Long getCreatedUserId() {
//        return createdUserId;
//    }
//
//    public T setCreatedUserId(Long createdUserId) {
//        this.createdUserId = createdUserId;
//        return (T) this;
//    }
//
//    public String getCreatedUserName() {
//        return createdUserName;
//    }
//
//    public T setCreatedUserName(String createdUserName) {
//        this.createdUserName = createdUserName;
//        return (T) this;
//    }
//
//    public LocalDateTime getCreatedTime() {
//        return createdTime;
//    }
//
//    public T setCreatedTime(LocalDateTime createdTime) {
//        this.createdTime = createdTime;
//        return (T) this;
//    }
//
//    public Long getUpdatedUserId() {
//        return updatedUserId;
//    }
//
//    public T setUpdatedUserId(Long updatedUserId) {
//        this.updatedUserId = updatedUserId;
//        return (T) this;
//    }
//
//    public String getUpdatedUserName() {
//        return updatedUserName;
//    }
//
//    public T setUpdatedUserName(String updatedUserName) {
//        this.updatedUserName = updatedUserName;
//        return (T) this;
//    }
//
//    public LocalDateTime getUpdatedTime() {
//        return updatedTime;
//    }
//
//    public T setUpdatedTime(LocalDateTime updatedTime) {
//        this.updatedTime = updatedTime;
//        return (T) this;
//    }
//
//    public Boolean getDeleted() {
//        return deleted;
//    }
//
//    public T setDeleted(Boolean deleted) {
//        this.deleted = deleted;
//        return (T) this;
//    }
}
