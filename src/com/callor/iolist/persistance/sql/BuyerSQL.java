package com.callor.iolist.persistance.sql;

import com.callor.iolist.config.DBContract;

public class BuyerSQL {
	
	public static final String INSERT = "insert into tbl_buyer (buid, buname, butel, buaddr) "
			+ " values (#{buId}, #{buName}, #{buTel}, #{buAddr})";
	public static final String UPDATE = "update " + DBContract.TABLE.BUYER + " set "
			+ " buName = #{buName}, "
			+ " buTel = #{buTel}, "
			+ " buAddr = #{buAddr} "
			+ " where buId = #{buId}";

}
