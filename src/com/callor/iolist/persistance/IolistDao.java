package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
	
	/*
	 * mybatis 의 queyr method 에 값을 전달할 때
	 * 가능하면 Dto(VO)에 데이터를 담아서 전달하라
	 * 만약 불가피하게 일반 변수(int, String 등등)를 사용하여
	 * 전달할 때 1개만 전달할 때는 문제가 없다
	 * 하지만 2개이상 전달할 때는 반드시 @Param() Annotation 을 사용하여
	 * 변수이름도 함께 전달해 주어야 한다.
	 */
	// 기간별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where iodate between #{sDate} and #{eDate} " + " order by iodate, iotime")
	public List<IolistDto> selectBetweenDate(@Param("sDate") String sDate, @Param("eDate") String eDate);
	
	// 고객별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where ioBuId = #{buId} order by iodate, iotime")
	public List<IolistDto> selectByBuyer(String buId);
	
	// 상품별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where iopcode = #{pCode} order by iodate, iotime")
	public List<IolistDto> selectByProduct(String pCode);
	
	// 고객 + 기간별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where iobuid = #{buid} and iodate between #{sDate} and #{eDate} " + " order by iodate, iotime")
	public List<IolistDto> selectByBuyerBetweenDate(@Param("buId") String buId, @Param("sDate") String sDate, @Param("eDate")String eDate);
	
	// 상품 + 기간별 리스트
	@Select("select * from " + DBContract.TABLE.IOLIST + " where iopcode = #{pcode} and iodate between #{sDate} and #{eDate} " + " order by iodate, iotime")
	public List<IolistDto> selectByProductBetweenDate(@Param("pCode") String pCode, @Param("sDate")String sDate, @Param("eDate") String eDate);
	
	@Insert("insert into " + DBContract.TABLE.IOLIST 
			+ " (ioDate, ioTime, ioBuId, "
			+ "ioPCode, ioQuan, ioPrice, ioTotal) "
			+ " values (#{ioDate}, #{ioTime}, #{ioBuId},"
			+ "#{ioPCode}, #{ioQuan}, #{ioPrice}, #{ioTotal}) ")
	public int insert(IolistDto iolistDto);

}
