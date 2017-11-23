package system.dept.entiy.supplier;

import java.io.Serializable;
import java.util.Date;

public class Waybill implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String wid;
	private String wstate;
	private String wname;
	private String address;
	private Date sdate;
	private Date fdate;

	public Waybill(String wid, String wstate, String wname, String address, Date sdate, Date fdate) {
		this.wid = wid;
		this.wstate = wstate;
		this.wname = wname;
		this.address = address;
		this.sdate = sdate;
		this.fdate = fdate;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getWstate() {
		return wstate;
	}

	public void setWstate(String wstate) {
		this.wstate = wstate;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getFdate() {
		return fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

}
