package system.dept.entiy.supplier;

import java.io.Serializable;

public class Items implements Serializable{

	private static final long serialVersionUID = 1L;

	private String iid;
	private String bname;
	private String bnum;
	private String sid;

	public Items(String iid, String bname, String bnum, String sid) {
		this.iid = iid;
		this.bname = bname;
		this.bnum = bnum;
		this.sid = sid;
	}

	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

}
