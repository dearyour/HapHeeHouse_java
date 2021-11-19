//package com.ssafy.happyhouse.model.dao;
//
//
//import java.sql.Connection;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.happyhouse.util.DBClose;
//import com.happyhouse.util.DBConnection;
//import com.ssafy.happyhouse.model.dto.House;
//
//public class HouseInfoDAOImpl implements HouseInfoDAO{
//	// Singleton Pattern
//	private static HouseInfoDAO houseInfoDao;
//	private String mainSql = "select tmp.sido, tmp.gugun, h.dong, h.AptName, h.jibun,\n" + 
//							"		h.buildyear, h.lat, h.lng, h.img\n" + 
//							"from houseinfo h join (\n" + 
//							"						select guguncode, sido, gugun, dong\n" + 
//							"                        from baseaddress\n" + 
//							"					) tmp\n" + 
//							"on h.guguncode = tmp.guguncode and h.dong = tmp.dong\n";
//
//	private HouseInfoDAOImpl() {
//		
//	}
//
//	public static HouseInfoDAO getInstance() {
//		houseInfoDao = new HouseInfoDAOImpl();
//		return houseInfoDao;
//	}
//	
//	private void printHouseInfo(ResultSet rs) throws SQLException {
//		int cnt = 0;
//		
//		while(rs.next()) {
//			House h = new House(rs.getString(1), rs.getString(2), rs.getString(3), 
//					rs.getString(4), rs.getString(5), rs.getInt(6), 
//					rs.getDouble(7), rs.getDouble(8), rs.getString(9));
//			
//			System.out.println(h);
//			
//			cnt++;
//		}
//		
//		System.out.println("총 " + cnt + "건 검색 완료");
//	}
//	
//	// 전체 검색
//	@Override
//	public void searchAll() {
//		System.out.println("아파트 정보, 전체 검색");
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBConnection.getConnection();
//			
//			pstmt = conn.prepareStatement(mainSql);
//			rs = pstmt.executeQuery();
//			
//			printHouseInfo(rs);
//			
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//	
//	// 시, 도 기준 검색
//	@Override
//	public void searchHouseInfoBySido(String sido) {
//		System.out.println("아파트 정보, 시, 도 기준 검색: " + sido);
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = mainSql + 
//					"where tmp.sido like ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			sido = "%" + sido + "%";
//			
//			pstmt.setString(1, sido);
//			
//			rs = pstmt.executeQuery();
//			
//			printHouseInfo(rs);
//			
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//	
//	// 구 기준 검색
//	@Override
//	public void searchHouseInfoByGugun(String gugun) {
//		System.out.println("아파트 정보, 구, 군 기준 검색: " + gugun);
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = mainSql +
//					"where tmp.gugun like ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			gugun = "%" + gugun + "%";
//			
//			pstmt.setString(1, gugun);
//			
//			rs = pstmt.executeQuery();
//			
//			printHouseInfo(rs);
//			
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//	
//	// 동 기준 검색
//	@Override
//	public void searchHouseInfoByDong(String dong) {
//		System.out.println("아파트 정보, 동 기준 검색: " + dong);
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = mainSql +
//					"where h.dong like ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			dong = "%" + dong + "%";
//			
//			pstmt.setString(1, dong);
//			
//			rs = pstmt.executeQuery();
//			
//			printHouseInfo(rs);
//			
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//	
//	// 아파트 이름 기준 검색
//	@Override
//	public void searchHouseInfoByAptName(String aptName) {
//		System.out.println("아파트 정보, 아파트 이름 기준 검색: " + aptName);
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = mainSql +
//					"where h.AptName like ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			aptName = "%" + aptName + "%";
//			
//			pstmt.setString(1, aptName);
//			
//			rs = pstmt.executeQuery();
//			
//			printHouseInfo(rs);
//			
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	public void searchHouseInfoByBuildYear(double min, double max) {
//		if (min > max) {
//			System.out.println("준공년도 범위를 잘못 입력하셨습니다.");
//			return;
//		} else if (min == max) {
//			System.out.println("아파트 거래 정보, 준공년도 기준 검색: " + min + "년");			
//		} else {
//			System.out.println("아파트 거래 정보, 준공년도 기준 검색: " + min + "년 ~ " + max + "년");
//		}
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = mainSql + 
//					"where h.buildYear between ? and ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setDouble(1, min);
//			pstmt.setDouble(2, max);
//			
//			rs = pstmt.executeQuery();
//			
//			printHouseInfo(rs);
//			
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	public void insertHouseInfo(House h) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = "select guguncode\n" + 
//					"from baseaddress\n" + 
//					"where sido = ?\n" + 
//					"and gugun = ?\n" + 
//					"and dong = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, h.getSido());
//			pstmt.setString(2, h.getGugun());
//			pstmt.setString(3, h.getDong());
//			
//			rs = pstmt.executeQuery();
//			rs.next();
//			
//			String gugunCode = rs.getString(1);
//			
////			System.out.println(gugunCode);
//			
//			sql = "insert into houseinfo(guguncode, dong, AptName, jibun, buildYear)\n" + 
//					"values(?, ?, ?, ?, ?);";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, gugunCode);
//			pstmt.setString(2, h.getDong());
//			pstmt.setString(3, h.getName());
//			pstmt.setString(4, h.getJibun());
//			pstmt.setInt(5, h.getBuildYear());
//			
//			pstmt.executeUpdate();
//			
//			System.out.println("아파트 정보 입력 완료!");			
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//}
