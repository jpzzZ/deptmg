package system.dept.entiy.supplier;

import java.io.Serializable;

public class BookItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String bid;
	private String bname;
	private String bnum;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
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

}
