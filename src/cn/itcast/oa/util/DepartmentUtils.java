package cn.itcast.oa.util;

import cn.itcast.oa.domain.Department;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class DepartmentUtils {
    public static List<Department> getAllDepartments(List<Department> departmentTopList) {
        List<Department> list = new ArrayList<Department>();
        getDepartments(departmentTopList,list,"┣");
        return list;
    }

    /**
     * 递归分层显示部门名称
     * @param departmentTopList
     * @param list
     * @param prefix
     */
    private static void getDepartments(Collection<Department> departmentTopList, List<Department>list,String prefix){
        for (Department department:departmentTopList){
            Department copy = new Department();//将session中的一级缓存取出，以便于事物管理
            copy.setId(department.getId());
            copy.setName(prefix+department.getName());
            list.add(copy);
            getDepartments(department.getChildren(),list,"　"+prefix);
        }
    }
}
