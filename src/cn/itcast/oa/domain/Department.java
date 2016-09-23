package cn.itcast.oa.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class Department implements Serializable{
    private Long id;
    private String name;
    private String description;
    private Set<User> users;
    private Department parent;
    private Set<Department> children;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public Set<Department> getChildren() {
        return children;
    }

    public void setChildren(Set<Department> children) {
        this.children = children;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
