# 20191119_consoleApp
비트캠프 첫번째 개인프로젝트: 홈카페 만들기

* 요구사항   
	: Bitcamp.java142기 홈카페 만들기. (회원등록 25명)

* 리드타임   
	: 2019-11-18(월) ~ 2019-11-19(화)
	  하루 9시간(점심시간 1시간) = 8시간
	  16시간 - 2시간 = 14시간

* 요건 정의   
	: 자바 콘솔 어플리케이션
	  순번, 아이디, 비번, 이름, 이메일, 핸드폰번호, 생년월일, 
	  도로명 우편번호, 도로명 주소, 삭제여부, 가입일, 수정일

* 패키지명 : bitcamp.java142.ch5.kcmjf
* 컬럼명 : 본인 첫번째 이니셜 + 컬럼명

* 회원등록에 필요한 데이터
<pre>
순번 : 회원번호 : MYYYYMMDD0001		kmem		(primary key)
아이디 : 영어 + 숫자			kid		(not null)
비번 : 영어 + 숫자 + 특수문자		kpw		(not null)
이름 : 한글 + 영어				kname
이메일 : 영어 + 숫자			kemail		(not null)
핸드폰번호 : 숫자 (00000000000)		khp
생년월일	: YYYYMMDD			kbirth
도로명 우편번호				kpostno
도로명 주소				kjuso
삭제여부	: (Y/N)				kdeleteYN
가입일 : YYYYMMDD			kinsertdate
수정일 : YYYYMMDD			kupdatedate
</pre>
* 테이블 이름 : 본인이니셜 + _MEMBER		KCM_MEMBER

* 패키지, 클래스 정의
<pre>
main class : bitcamp.java142.ch5.kcmjf.KcmMemberScr
	void funcSelector
	KcmMemberVO dataScanner
	List<KcmMemberVO> selectKcmMember
	List<KcmMemberVO> searchKcmMember
	List<KcmMemberVO> likeSearchKcmMember
	boolean insertKcmMember
	boolean updateKcmMember
	boolean deleteKcmMember
	List<KcmMemberVO> displayFunc
VO   class : bitcamp.java142.ch5.kcmjf.vo.KcmMemberVO
	Constructor - 데이터 생성할 때 VO의 setter 함수 이용하는 것으로. -> 기본 생성자만
	setter/getter
DAO class : bitcamp.java142.ch5.kcmjf.dao.KcmMemberDAO
	 : bitcamp.java142.ch5.kcmjf.dao.KcmMemberDAOImpl
	List<KcmMemberVO> selectKcmMember
	List<KcmMemberVO> searchKcmMember
	List<KcmMemberVO> likeSearchKcmMember
	boolean insertKcmMember
	boolean updateKcmMember
	boolean deleteKcmMember 
	KcmMemberVO setterKmvo
SQL  class : bitcamp.java142.ch5.kcmjf.sql.KcmSqlQueryMap
	String getSelectQuery
	String getSearchQuery
	String getLikeSearchQuery
	String getInsertQuery
	String getUpdateQuery
	String getDeleteQuery
Chaebun : bitcamp.java142.ch5.kcmjf.common.KcmChaebunClass
	String memberNo
Connection : bitcamp.java142.ch5.kcmjf.common.KcmConnProperty
	Connection getConnection
	void connClose
</pre>
* 제출 시간 : 2019-11-19(화요일) 오후 5:50
* 제출 폴더 : C:\80.자바142기\90.Exam_Project\20191118_console_dao_work\본인이름

데이터 입력 : Scanner 클래스이용
데이터 구분자: Scanner 클래스 이용리드타임   