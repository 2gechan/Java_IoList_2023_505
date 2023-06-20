package com.callor.iolist.persistance.sql;

import com.callor.iolist.config.DBContract;

public class ProductSQL {
	
	public static final String INSERT = "insert into "+ DBContract.TABLE.PRODUCT + " (pCode, pName, pItem, pIPrice, pOPrice) "
			+ " values (#{pCode}, #{pName}, #{pItem}, #{pIPrice}, #{pOPrice})";
	public static final String UPDATE = "update " + DBContract.TABLE.PRODUCT + " set "
			+ " pName = #{pName}, "
			+ " pItem = #{pItem}, "
			+ " pIPrice = #{pIPrice}, "
			+ " pOPrice = #{pOPrice} "
			+ " where pCode = #{pCode}";

}
