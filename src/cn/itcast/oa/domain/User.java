package cn.itcast.oa.domain;

import com.opensymphony.xwork2.ActionContext;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class User implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String gender;
    private Department department;
    private String loginName;
    private Set<Role> roles;
    private String phoneNumber;
    private String email;
    private String password;

    public boolean hasPrivilegeByName(String name) {
        if(isAdmin())
            return true;
        for (Role role : roles) {
            for (Privilege privilege : role.getPrivileges())
                if (privilege.getName().equals(name)) {
                    return true;
                }
        }
        return false;
    }

    public boolean hasPrivilegeByUrl(String url) {

        if(isAdmin())
            return true;
        //去掉后面的参数
        int index = url.indexOf("?");
        if (index > -1)
            url = url.substring(0, index);
        //去掉"UI"
        if (url.endsWith("UI"))
            url = url.substring(0, url.length() - 2);

        Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
        if(!allPrivilegeUrls.contains(url))
            return true;
        for (Role role : roles) {
            for (Privilege privilege : role.getPrivileges())
                if (url.equals(privilege.getUrl())) {
                    return true;
                }
        }
        return false;
    }

    /**
     * @return
     */
    public boolean isAdmin(){
        return "admin".equals(loginName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
