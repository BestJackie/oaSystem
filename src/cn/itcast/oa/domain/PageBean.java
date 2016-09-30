package cn.itcast.oa.domain;

import java.util.List;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class PageBean {
    //页面传值
    private int pageSize;
    private int currentPage;
    //数据库
    private List recordList;
    private int recordCount;
    //计算
    private int pageCount;
    private int beginPageIndex;
    private int endPageIndex;

    public PageBean(int pageSize, int currentPage, List recordList, int recordCount) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.recordList = recordList;
        this.recordCount = recordCount;
        //计算总页码
        pageCount = (recordCount + pageSize - 1) / pageSize;
        //  计算BeginpageIndex 和EndpageIndex
        //总页码不多于10页，则显示全部
        if (pageCount <= 10) {
            beginPageIndex = 1;
            endPageIndex = pageCount;
        }
        //总页数多余10页则显示当前页附近的共10个页码
        else {
            //当前页附近的共10个页码，（前4+当前页+后5页）
            beginPageIndex = currentPage - 4;
            endPageIndex = currentPage + 5;
            //当前页的页码不足4个时，则显示前10个页码
            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 10;
            }
            //当后面的页码不足5个时，则显示后10个页码
            if (endPageIndex > pageCount) {
                endPageIndex = pageCount;
                beginPageIndex = pageCount - 10;
            }

        }


    }

    public List getRecordList() {
        return recordList;
    }

    public void setRecordList(List recordList) {
        this.recordList = recordList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }
}
