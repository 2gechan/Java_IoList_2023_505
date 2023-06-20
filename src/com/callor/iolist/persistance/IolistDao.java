package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.iolist.config.DBContract;
import com.callor.iolist.models.IolistDto;

/*
* 판매 등록
* 1. 판매내역 등록(장바구니 담기)
* 2. 장바구니 전체 리스트
* 3. 기간별 리스트
* 4. 고객별 리스트
* 5. 상품별 리스트
* 6. 고객 + 거래기간별 리스트
*/
public interface IolistDao {
	
	@Select("select * from " + DBContract.TABLE.IOLIST + " order by iodate, iotime")
	public List<IolistDto> selectAll();
	
	// 기간별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where iodate between #{sDate} and #{eDate} " + " order by iodate, iotime")
	public List<IolistDto> selectBetweenDate(String sDate, String eDate);
	
	// 고객별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where ioBuId = #{buId} order by iodate, iotime")
	public List<IolistDto> selectByBuyer(String buId);
	
	// 상품별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where iopcode = #{pCode} order by iodate, iotime")
	public List<IolistDto> selectByProduct(String pCode);
	
	// 고객 + 기간별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where iobuid = #{buid} and iodate between #{sDate} and #{eDate} " + " order by iodate, iotime")
	public List<IolistDto> selectByBuyerBetweenDate(String buId, String sDate, String eDate);
	
	// 상품 + 기간별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where iopcode = #{pcode} and iodate between #{sDate} and #{eDate} " + " order by iodate, iotime")
	public List<IolistDto> selectByProductBetweenDate(String pCode, String sDate, String eDate);
	
	@Insert("insert into " + DBContract.TABLE.IOLIST 
			+ " (ioDate, ioTime, ioBuId, "
			+ "ioPCode, ioQuan, ioPrice, ioTotal) "
			+ " values (#{ioDate}, #{ioTime}, #{ioBuId},"
			+ "#{ioPCode}, #{ioQuan}, #{ioPrice}, #{ioTotal}) ")
	public int insert(IolistDto iolistDto);

}
