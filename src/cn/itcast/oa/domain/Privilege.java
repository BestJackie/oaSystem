package cn.itcast.oa.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 权限实体
 * Created by Administrator on 2016/9/22 0022.
 */
public class Privilege implements Serializable {
    private Long id;

    private String name;

    private String url;

    private Privilege parent;

    private Set<Privilege>children;

    private Set<Role> roles;

    public Privilege() {
    }

    public Privilege(String name, String url, Privilege parent) {
        this.name = name;
        this.url = url;
        this.parent = parent;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Privilege getParent() {
        return parent;
    }

    public void setParent(Privilege parent) {
        this.parent = parent;
    }

    public Set<Privilege> getChildren() {
        return children;
    }

    public void setChildren(Set<Privilege> children) {
        this.children = children;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
