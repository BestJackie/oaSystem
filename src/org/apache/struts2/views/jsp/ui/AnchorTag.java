package org.apache.struts2.views.jsp.ui;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import cn.itcast.oa.domain.User;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Anchor;
import org.apache.struts2.components.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;


public class AnchorTag extends AbstractClosingTag {
    private static final long serialVersionUID = -1034616578492431113L;
    protected String href;
    protected String includeParams;
    protected String scheme;
    protected String action;
    protected String namespace;
    protected String method;
    protected String encode;
    protected String includeContext;
    protected String escapeAmp;
    protected String portletMode;
    protected String windowState;
    protected String portletUrlType;
    protected String anchor;
    protected String forceAddSchemeHostAndPort;

    public AnchorTag() {
    }

    @Override
    public int doEndTag() throws JspException {
        //获取当前用户
        User user = (User) pageContext.getSession().getAttribute("user");
        //当前显示的连接对应权限的Url
        String privUrl = "/"+action;
       if (user.hasPrivilegeByUrl(privUrl)) {
            return super.doEndTag();
        }
        return EVAL_PAGE;
    }

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Anchor(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();
        Anchor tag = (Anchor) this.component;
        tag.setHref(this.href);
        tag.setIncludeParams(this.includeParams);
        tag.setScheme(this.scheme);
        tag.setValue(this.value);
        tag.setMethod(this.method);
        tag.setNamespace(this.namespace);
        tag.setAction(this.action);
        tag.setPortletMode(this.portletMode);
        tag.setPortletUrlType(this.portletUrlType);
        tag.setWindowState(this.windowState);
        tag.setAnchor(this.anchor);
        if (this.encode != null) {
            tag.setEncode(Boolean.valueOf(this.encode).booleanValue());
        }

        if (this.includeContext != null) {
            tag.setIncludeContext(Boolean.valueOf(this.includeContext).booleanValue());
        }

        if (this.escapeAmp != null) {
            tag.setEscapeAmp(Boolean.valueOf(this.escapeAmp).booleanValue());
        }

        if (this.forceAddSchemeHostAndPort != null) {
            tag.setForceAddSchemeHostAndPort(Boolean.valueOf(this.forceAddSchemeHostAndPort).booleanValue());
        }

    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public void setIncludeContext(String includeContext) {
        this.includeContext = includeContext;
    }

    public void setEscapeAmp(String escapeAmp) {
        this.escapeAmp = escapeAmp;
    }

    public void setIncludeParams(String name) {
        this.includeParams = name;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPortletMode(String portletMode) {
        this.portletMode = portletMode;
    }

    public void setPortletUrlType(String portletUrlType) {
        this.portletUrlType = portletUrlType;
    }

    public void setWindowState(String windowState) {
        this.windowState = windowState;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public void setForceAddSchemeHostAndPort(String forceAddSchemeHostAndPort) {
        this.forceAddSchemeHostAndPort = forceAddSchemeHostAndPort;
    }
}

