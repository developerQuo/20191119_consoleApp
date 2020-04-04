package bitcamp.java142.ch5.kcmjf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java142.ch5.kcmjf.KcmMemberScr;
import bitcamp.java142.ch5.kcmjf.common.KcmChaeBunClass;
import bitcamp.java142.ch5.kcmjf.common.KcmConnProperty;
import bitcamp.java142.ch5.kcmjf.sql.KcmSqlQueryMap;
import bitcamp.java142.ch5.kcmjf.vo.KcmMemberVO;

public class KcmMemberDAOImpl implements KcmMemberDAO {

	@Override
	public List<KcmMemberVO> selectKcmMember() {
		// TODO Auto-generated method stub
		System.out.println("(log) KcmMemberDAOImpl.selectKcmMember() entered");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		List<KcmMemberVO> aList = null;
		KcmMemberVO kmvo = null;
		
		try{
			conn = KcmConnProperty.getConnection();
			System.out.println("DB연결 성공! " + conn);
			pstmt = conn.prepareStatement(KcmSqlQueryMap.getSelectQuery());
			System.out.println("KcmSqlQueryMap.getSelectQuery() >>> \n" + KcmSqlQueryMap.getSelectQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				aList = new ArrayList<KcmMemberVO>();
				while (rsRs.next()){
					kmvo = KcmMemberDAOImpl.setterKmvo(kmvo, rsRs);
					aList.add(kmvo);
				}
			}else{
				System.out.println("데이터를 제대로 받아오지 못 했습니다.");
			}
			
			KcmConnProperty.connClose(conn, pstmt, rsRs);
		}catch(Exception e){
			System.out.println("DB연결 또는 쿼리에 문제가 발생했습니다.");
		}finally{
			KcmConnProperty.connClose(conn, pstmt, rsRs);
		}
		
		System.out.println("(log) KcmMemberDAOImpl.selectKcmMember() left");
		return aList;
	}

	@Override
	public List<KcmMemberVO> searchKcmMember(KcmMemberVO _kmvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) KcmMemberDAOImpl.searchKcmMember(KcmMemberVO _kmvo) entered");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		List<KcmMemberVO> aList = null;
		KcmMemberVO kmvo = null;
		
		try{
			conn = KcmConnProperty.getConnection();
			System.out.println(" DB연결 성공! " + conn);
			pstmt = conn.prepareStatement(KcmSqlQueryMap.getSearchQuery());
			System.out.println("KcmSqlQueryMap.getSearchQuery() >>> \n " + KcmSqlQueryMap.getSearchQuery());
			pstmt.setString(1, _kmvo.getKid());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				aList = new ArrayList<KcmMemberVO>();
				while (rsRs.next()){
					kmvo = KcmMemberDAOImpl.setterKmvo(kmvo, rsRs);
					aList.add(kmvo);
				}
			}else{
				System.out.println("쿼리의 결과가 없습니다. null");
			}
			
			KcmConnProperty.connClose(conn, pstmt, rsRs);
		}catch(Exception e){
			System.out.println("DB연결 또는 쿼리에 문제가 발생했습니다. " + e.getMessage());
		}finally{
			KcmConnProperty.connClose(conn, pstmt, rsRs);
		}

		System.out.println("(log) KcmMemberDAOImpl.searchKcmMember(KcmMemberVO _kmvo) entered");
		return aList;
	}

	@Override
	public List<KcmMemberVO> likeSearchKcmMember(String _sVal) {
		// TODO Auto-generated method stub
		System.out.println("(log) KcmMemberDAOImpl.likeSearchKcmMember(String _sVal) entered");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		List<KcmMemberVO> aList = null;
		KcmMemberVO kmvo = null;
		String sVal = _sVal;
		try{
			conn = KcmConnProperty.getConnection();
			System.out.println(" DB연결 성공! " );
			pstmt = conn.prepareStatement(KcmSqlQueryMap.getLikeSearchQuery());
			System.out.println("KcmSqlQueryMap.getLikeSearchQuery() >>> \n" + KcmSqlQueryMap.getLikeSearchQuery());
			pstmt.setString(1, sVal);
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				aList = new ArrayList<KcmMemberVO>();
				while (rsRs.next()){
					kmvo = KcmMemberDAOImpl.setterKmvo(kmvo, rsRs);
					aList.add(kmvo);
				}
			}else{
				System.out.println("쿼리결과가 없습니다. null");
			}
			
			KcmConnProperty.connClose(conn, pstmt, rsRs);
		}catch(Exception e){
			System.out.println("DB연결 또는 쿼리에 문제가 발생했습니다. " + e.getMessage());
		}finally{
			KcmConnProperty.connClose(conn, pstmt, rsRs);
		}
		
		System.out.println("(log) KcmMemberDAOImpl.likeSearchKcmMember(String _sVal) left");
		return aList;
	}

	@Override
	public boolean insertKcmMember(KcmMemberVO _kmvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) KcmMemberDAOImpl.insertKcmMember(KcmMemberVO _kmvo) entered");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		KcmMemberVO kmvo_2 = null; 
		
		// check data
		KcmMemberScr.displayFunc(_kmvo);
		
		try{
			conn = KcmConnProperty.getConnection();
			pstmt = conn.prepareStatement(KcmSqlQueryMap.getInsertQuery());
			System.out.println("KcmSqlQueryMap.getInsertQuery() >>> \n" + KcmSqlQueryMap.getInsertQuery());
			pstmt.setString(1, KcmChaeBunClass.memberNo());
			pstmt.setString(2, _kmvo.getKid());
			pstmt.setString(3, _kmvo.getKpw());
			pstmt.setString(4, _kmvo.getKname());
			pstmt.setString(5, _kmvo.getKemail());
			pstmt.setString(6, _kmvo.getKhp());
			pstmt.setString(7, _kmvo.getKbirth());
			pstmt.setString(8, _kmvo.getKpostno());
			pstmt.setString(9, _kmvo.getKjuso());
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()) conn.commit();
			System.out.println(" commit 성공! ");
			
			KcmConnProperty.connClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("DB연결 또는 쿼리문에 문제가 발생했습니다. " + e.getMessage());
		}finally{
			KcmConnProperty.connClose(conn, pstmt);
		}
		
		System.out.println("(log) KcmMemberDaoImpl.insertKcmMember(KcmMemberVO _kmvo) left");
		
		if (nCnt == 0) return false;
		return true;
	}

	@Override
	public boolean updateKcmMember(KcmMemberVO _kmvo, String _sVal) {
		// TODO Auto-generated method stub
		System.out.println("(log) KcmMemberDAOImpl.updateKcmMember(KcmMemberVO _kmvo, String _sVal) entered");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		KcmMemberVO kmvo = _kmvo;
		String sVal = _sVal;
		
		try {
			conn = KcmConnProperty.getConnection();
			System.out.println("DB연결 성공!");
			pstmt = conn.prepareStatement(KcmSqlQueryMap.getUpdateQuery());
			System.out.println("KcmSqlQueryMap.getUpdateQuery() >>> \n" + KcmSqlQueryMap.getUpdateQuery());
			pstmt.setString(1, sVal);
			pstmt.setString(2, kmvo.getKid());
			nCnt = pstmt.executeUpdate();

			System.out.println(" nCnt >>>>>" + nCnt );
			if (!conn.getAutoCommit()) conn.commit();
			System.out.println(" 성공적으로 비밀번호를 수정했습니다." );
			
			KcmConnProperty.connClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("DB연결 또는 쿼리문에 문제가 발생했습니다. " +e.getMessage() );
		}finally{
			KcmConnProperty.connClose(conn, pstmt);
		}

		System.out.println("(log) KcmMemberDAOImpl.updateKcmMember(KcmMemberVO _kmvo, String _sVal) left");
		if (nCnt == 0) return false;
		return true;
	}

	@Override
	public boolean deleteKcmMember(KcmMemberVO _kmvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) KcmMemberDAOImpl.deleteKcmMember(KcmMemberVO _kmvo) entered");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		KcmMemberVO kmvo = _kmvo;
		
		try {
			conn = KcmConnProperty.getConnection();
			System.out.println("DB연결 성공!");
			pstmt = conn.prepareStatement(KcmSqlQueryMap.getDeleteQuery());
			System.out.println("KcmSqlQueryMap.getDeleteQuery() >>> \n" + KcmSqlQueryMap.getDeleteQuery());
			pstmt.setString(1, kmvo.getKid());
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()) conn.commit();
			System.out.println(" 성공적으로 삭제쿼리를 수행했습니다." );
			
			KcmConnProperty.connClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("DB연결 또는 쿼리문에 문제가 발생했습니다. " +e.getMessage() );
		}finally{
			KcmConnProperty.connClose(conn, pstmt);
		}

		System.out.println("(log) KcmMemberDAOImpl.deleteKcmMember(KcmMemberVO _kmvo) left");
		if (nCnt == 0) return false;
		return true;
	}
	
	public static KcmMemberVO setterKmvo(KcmMemberVO _kmvo
										,ResultSet _rsRs) throws Exception{
		System.out.println("(log) KcmMemberDAOImpl.setterKmvo(KcmMemberVO _kmVo, ResultSet _rsRs) entered");
		KcmMemberVO kmvo = _kmvo;
		ResultSet rsRs = _rsRs;
		kmvo = new KcmMemberVO();
		kmvo.setKmem(rsRs.getString("KMEM"));
		kmvo.setKid(rsRs.getString("KID"));
		kmvo.setKpw(rsRs.getString("KPW"));
		kmvo.setKname(rsRs.getString("KNAME"));
		kmvo.setKemail(rsRs.getString("KEMAIL"));
		kmvo.setKhp(rsRs.getString("KHP"));
		kmvo.setKbirth(rsRs.getString("KBIRTH"));
		kmvo.setKpostno(rsRs.getString("KPOSTNO"));
		kmvo.setKjuso(rsRs.getString("KJUSO"));
		kmvo.setKdeleteYN(rsRs.getString("KDELETEYN"));
		kmvo.setKinsertdate(rsRs.getString("KINSERTDATE"));
		kmvo.setKupdatedate(rsRs.getString("KUPDATEDATE"));
		
		// check data
		KcmMemberScr.displayFunc(kmvo);
		System.out.println("(log) KcmMemberDAOImpl.setterKmvo(KcmMemberVO _kmVo, ResultSet _rsRs) l");
		return kmvo;
	}

}
