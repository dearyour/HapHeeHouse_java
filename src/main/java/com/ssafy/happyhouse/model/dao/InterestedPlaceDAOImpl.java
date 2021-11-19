//package com.ssafy.happyhouse.model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.happyhouse.util.DBClose;
//import com.happyhouse.util.DBConnection;
//import com.ssafy.happyhouse.model.dto.InterestedPlace;
//
//public class InterestedPlaceDAOImpl implements InterestedPlaceDAO {
//	// Singleton Pattern
//	private static InterestedPlaceDAO InterestedDao;
//
//	private InterestedPlaceDAOImpl() {
//
//	}
//
//	public static InterestedPlaceDAO getInstance() {
//		InterestedDao = new InterestedPlaceDAOImpl();
//		return InterestedDao;
//	}
//
//	// 모든 관심장소 조회
//	@Override
//	public void selectAllPlace() {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBConnection.getConnection();
//			String sql = "select *\n";
//			sql += "from interestplaces";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while(rs.next()) {
//				InterestedPlace tmp = new InterestedPlace(rs.getString(1), rs.getString(2));
//				System.out.println(tmp);
//			}
//
//
//		} catch (SQLException e) {
//			DBClose.close(rs, pstmt, conn);
//			e.printStackTrace();
//		}
//	}
//	
//	// 이미 존재하는 회원인지 중복확인
//	@Override
//	public boolean isExistingUser(String id) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int cnt = 0;
//		
//		try {
//			conn = DBConnection.getConnection();
//			
//			String sql = "select *\n";
//			sql += "from userinfo\n";
//			sql += "where id = ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, id);			
//			rs = pstmt.executeQuery();
//			
//			if (rs.next()) {
//				cnt++;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {				
//			DBClose.close(rs, pstmt, conn);
//		}
//		
//		if (cnt != 0) {
//			return true;
//		}
//		
//		return false;
//	}
//
//
//	// 구군코드 찾아라 
//	@Override
//	public void placeUp(String userid, String gugunCode) {
//		// 존재하지 않는 회원인지 확인
//		if (isExistingUser(userid)) {
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			try {
//				conn = DBConnection.getConnection();
//				
//				String sql = "insert into interestplaces \n"
//							+ "values (?, ?)";
//				pstmt = conn.prepareStatement(sql);
//
//				pstmt.setString(1, userid);
//				pstmt.setString(2, gugunCode);
//
//				pstmt.executeUpdate();
//				System.out.println("관심지역을 등록했습니다.");
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				DBClose.close(rs, pstmt, conn);
//			}
//		} else {
//			System.out.println("존재하지 않는 회원입니다.");
//		}
//	}
//
//	// 
//	@Override
//	public void modifyPlaceInfo(String userid, String oldGugunCode, String newGugunCode) {
//		// 존재하는 회원인지 확인
//		if (isExistingUser(userid)) {
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			try {
//				conn = DBConnection.getConnection();
//
//				String sql = "update interestplaces\n"
//							+ "set guguncode = ?\n"
//							+ "where userid = ? and gugunCode = ?";
//				pstmt = conn.prepareStatement(sql);
//
//				pstmt.setString(1, newGugunCode);
//				pstmt.setString(2, userid);
//				pstmt.setString(3, oldGugunCode);
//
//				pstmt.executeUpdate();
//				System.out.println("관심지역 수정이 완료됐습니다.");
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				DBClose.close(rs, pstmt, conn);
//			}
//		} else {
//			System.out.println("존재하지 않는 회원입니다.");
//		}
//	}
//
//	// 동코드 삭제 삭제
//	@Override
//	public void deletePlaceInfo(String userid, String guguncode) {
//		// 존재하는 회원인지 확인
//		if (isExistingUser(userid)) {
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			try {
//				conn = DBConnection.getConnection();
//
//				// 회원 정보 삭제
//				String sql = "delete from interestplaces \n";
//				sql += "where userid = ? and guguncode = ?";
//				pstmt = conn.prepareStatement(sql);
//
//				pstmt.setString(1, userid);
//				pstmt.setString(2, guguncode);
//				pstmt.executeUpdate();
//				
//				System.out.println("관심지역 삭제가 완료됐습니다.");
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				DBClose.close(rs, pstmt, conn);
//			}
//		} else {
//			System.out.println("존재하지 않는 회원입니다.");
//		}
//	}
//}