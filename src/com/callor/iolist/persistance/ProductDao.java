package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.iolist.config.DBContract;
import com.callor.iolist.models.ProductDto;
import com.callor.iolist.persistance.sql.ProductSQL;

public interface ProductDao {
	
	@Select("select * from " + DBContract.TABLE.PRODUCT + " order by pCode")
	public List<ProductDto> selectAll();
	
	@Select("select * from " + DBContract.TABLE.PRODUCT + " where pCode = #{id}")
	public ProductDto findById(String id);
	
	@Insert(ProductSQL.INSERT)
	public int insert(ProductDto productDto);
	
	@Update(ProductSQL.UPDATE)
	public int update(ProductDto productDto);
	
	@Select("select * from " + DBContract.TABLE.PRODUCT + " where pName LIKE '%' || #{pName} || '%' order by pName")
	public List<ProductDto> findByPName(String pName);

}
