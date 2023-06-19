package com.callor.iolist.persistance.sql;

public class BuyerSQL {
	
	public static final String INSERT = "insert into tbl_buyer (buid, buname, butel, buaddr) "
			+ " values (#{buId}, #{buName}, #{buTel}, #{buAddr})";
	public static final String UPDATE = "";

}
