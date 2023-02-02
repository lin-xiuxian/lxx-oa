package com.lxx.oa.entity;

/**
 * @author 林修贤
 * @date 2023/2/2
 * @description 用户实体类
 */
public class User {
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", employeeId=" + employeeId +
                ", salt=" + salt +
                '}';
    }

    private Long userId;
    private String userName;
    private String password;
    private Long employeeId;
    private Integer salt;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }
}
