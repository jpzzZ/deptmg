package system.dept.commons.bean;

import system.dept.commons.contrant.SysContrant;

import java.util.List;

/**
 * 分页插件
 */
public class PageModel<T,E> {

    // 当前页数
    private int pageNumber ;
    // 每页的大小
    private int pageSize = SysContrant.PAGE_SIZE ;
    // 总页数
    private int pagetotal ;
    // 总条数
    private int total ;

    // 当前页的数据
    private List<T> list ;
    // 查询条件
    private E query ;

    //从前台传过来
    public int getPageNumber() {
        return pageNumber;
    }

    //总页数计算获得
    public int getPagetotal() {
        return (this.total + pageSize - 1) / pageSize;
    }

    public int getTotal() {
        return total;
    }

    public List<T> getList() {
        return list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


    public E getQuery() {
        return query;
    }

    public void setQuery(E query) {
        this.query = query;
    }
}
