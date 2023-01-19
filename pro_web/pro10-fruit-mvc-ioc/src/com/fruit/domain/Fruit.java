package com.fruit.domain;

/**
 * @author LiJing
 * @version 1.0
 * `fid` int(11) NOT NULL AUTO_INCREMENT,
 *   `fname` varchar(20) NOT NULL,
 *   `price` int(11) DEFAULT NULL,
 *   `fcount` int(11) DEFAULT NULL,
 *   `remark` varchar(50) DEFAULT NULL,
 */
public class Fruit {
    private Integer fid;
    private String fname;
    private Integer price;
    private Integer fcount;
    private String remark;

    public Fruit() {
    }

    public Fruit(Integer fid, String fname, Integer price, Integer fcount, String remark) {
        this.fid = fid;
        this.fname = fname;
        this.price = price;
        this.fcount = fcount;
        this.remark = remark;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", price=" + price +
                ", fcount=" + fcount +
                ", remark='" + remark + '\'' +
                '}';
    }
}
