package com.zkq.pageutils;

import com.zkq.domain.Blog;
import java.util.List;

public class Page<T> {
    private int currentPage; //当前页数
    private int totalPage;//总页数
    private int pageNumber;//每页行数
    private int totalRows;//总行数
    private List<T> list;//需要返回的数据
    public Page(){}
    public Page(int currentPage, int pageNumber){
        this.currentPage=currentPage;
        this.pageNumber=pageNumber;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public List<T> getList() {
        return list;
    }
}
