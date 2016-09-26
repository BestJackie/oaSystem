package cn.itcast.oa.base;

import cn.itcast.oa.service.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    protected T model;

    public BaseAction() {
        //通过反射获得model的真实类型
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
        //通过反射获取model实例
        try {
            model = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public T getModel() {
        return model;
    }
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected DepartmentService departmentService;
    @Autowired
    protected UserService userService;
    @Autowired
    protected PrivilegeService privilegeService;
    @Autowired
    protected ForumService forumService;


    protected void putIntoMap(String key,Object value){
        ActionContext.getContext().put(key,value);
    }
    protected void pushIntoValueStack(Object value){
        ActionContext.getContext().getValueStack().push(value);
    }

    public static final String COMMON_LIST = "list";
    public static final String COMMON_TOLIST = "toList";
    public static final String COMMON_SAVEUI = "saveUI";
    public static final String SET_PRIVILEGEUI = "setPrivilegeUI";
    public static final String LOGINUI = "loginUI";
    public static final String LOGOUT = "logout";
    public static final String TO_INDEX = "toIndex";

}
