package com.fu.ssm.po;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fu.ssm.validation.ValidGroup1;
import com.fu.ssm.validation.ValidGroup2;

public class Items implements Serializable {
    private Integer id;

    //校验名称1~30字符
    @Size(min=1,max=30,message="{item.name.length.error}",groups={ValidGroup1.class})
    private String name;

    private Float price;

    private String pic;
    
    @NotNull(message="{item.createtime.isNull}",groups={ValidGroup2.class})
    private Date createtime;

    private String detail;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}