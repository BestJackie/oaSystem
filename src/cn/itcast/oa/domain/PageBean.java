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
        // TODO: 2016/9/30 0030  计算BeginpageIndex 和EndpageIndex

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
