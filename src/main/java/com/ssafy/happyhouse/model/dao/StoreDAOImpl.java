//package com.ssafy.happyhouse.model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.happyhouse.util.DBClose;
//import com.happyhouse.util.DBConnection;
//import com.ssafy.happyhouse.model.dto.User;
//
//public class StoreDAOImpl implements StoreDAO {
//	// Singleton Pattern
//	private static StoreDAO storeDao;
//
//	private StoreDAOImpl() {
//		
//	}
//
//	public static StoreDAO getInstance() {
//		storeDao = new StoreDAOImpl();
//		return storeDao;
//	}
//	
//	// 구, 군 기준 검색
//	@Override
//	public void getStoreInfoByGugun(User user) {
//		System.out.println("구, 군 기준 주변 업종 검색");
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;		
//		String gugunCode = user.getDongcode().substring(0, 5);
//		
//		int cnt = 0;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = "select storename, branchname, midclass, address\r\n" + 
//					"from storeinfo\r\n" + 
//					"where substring(dongcode, 1, 5) = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, gugunCode);			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String storeName = rs.getString(1);
//				String branchName = rs.getString(2);
//				String midClass = rs.getString(3);
//				String address = rs.getString(4);
//				
//				System.out.println("매장 이름: " + storeName
//						+ "\t매장 지점: " + branchName
//						+ "\t업종: " + midClass
//						+ "\t주소: " + address);
//				
//				cnt++;
//			}
//			
//			System.out.println("총 " + cnt + "건 검색 완료");
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//	
//	// 동 기준 검색
//	@Override
//	public void getStoreInfoByDong(User user) {
//		System.out.println("구, 군 기준 주변 업종 검색");
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		int cnt = 0;
//		
//		try {
//			conn = DBConnection.getConnection();
//			String sql = "select storename, branchname, midclass, address\r\n" + 
//					"from storeinfo\r\n" + 
//					"where dongcode = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, user.getDongcode());			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String storeName = rs.getString(1);
//				String branchName = rs.getString(2);
//				String midClass = rs.getString(3);
//				String address = rs.getString(4);
//				
//				System.out.println("매장 이름: " + storeName
//						+ "\t매장 지점: " + branchName
//						+ "\t업종: " + midClass
//						+ "\t주소: " + address);
//				
//				cnt++;
//			}
//			
//			System.out.println("총 " + cnt + "건 검색 완료");
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//}
