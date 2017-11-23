package system.dept.entiy.inventory;

import java.io.Serializable;

public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    // 书籍表的信息
    private String bname; // 书籍名称
    private String press; // 书籍出版社信息
    private String clazz; // 书籍的类别

    // 仓库表的信息
    private int bnum; // 书籍数量
    private String address; // 仓库名称


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBnum() {
        return bnum;
    }

    public void setBnum(int bnum) {
        this.bnum = bnum;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

}

