package com.leyou.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author 18070943
 * @create 2018-12-16 15:17
 * @desc 分页实体
 **/
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -8905691497555954860L;
    private Long total;// 总条数
    private Long totalPage;// 总页数
    private List<T> items;// 当前页数据
    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}