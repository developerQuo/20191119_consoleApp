package bitcamp.java142.ch5.kcmjf.sql;

public abstract class KcmSqlQueryMap {
	
	public static final String KMEM_CHAEBUN = 
			"SELECT /*+ INDEX_DESC(A SYS_C0011147) */ "
			+ "LPAD(TO_CHAR(NVL(MAX(SUBSTR(A.KMEM, -4)), 0) + 1), 4, '0') AS COMMNO "
			+ "FROM  KCM_MEMBER A";
//			"SELECT LPAD(TO_CHAR(COUNT(A.KMEM)+1), 4, '0') AS NUMBERING FROM  KCM_MEMBER A";
	
	public static String getSelectQuery(){
		System.out.println("(log) KcmSqlQueryMap.getSelectQuery() entered");
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT								\n");
		sb.append("       A.KMEM           KMEM			\n");
		sb.append("      ,A.KID            KID			\n");
		sb.append("      ,A.KPW            KPW			\n");
		sb.append("      ,A.KNAME          KNAME		\n");
		sb.append("      ,A.KEMAIL         KEMAIL		\n");
		sb.append("      ,A.KHP            KHP			\n");
		sb.append("      ,A.KBIRTH         KBIRTH		\n");
		sb.append("      ,A.KPOSTNO        KPOSTNO		\n");
		sb.append("      ,A.KJUSO          KJUSO		\n");
		sb.append("      ,A.KDELETEYN      KDELETEYN	\n");
		sb.append("      ,A.KINSERTDATE    KINSERTDATE	\n");
		sb.append("      ,A.KUPDATEDATE    KUPDATEDATE	\n");
		sb.append("FROM  KCM_MEMBER A					\n");
		sb.append("WHERE A.KDELETEYN = 'Y'				\n");
		System.out.println("(log) KcmSqlQueryMap.getSelectQuery() left");
		return sb.toString();
	}
	
	public static String getSearchQuery(){
		System.out.println("(log) KcmSqlQueryMap.getSearchQuery() entered");
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT								\n");
		sb.append("       A.KMEM           KMEM			\n");
		sb.append("      ,A.KID            KID			\n");
		sb.append("      ,A.KPW            KPW			\n");
		sb.append("      ,A.KNAME          KNAME		\n");
		sb.append("      ,A.KEMAIL         KEMAIL		\n");
		sb.append("      ,A.KHP            KHP			\n");
		sb.append("      ,A.KBIRTH         KBIRTH		\n");
		sb.append("      ,A.KPOSTNO        KPOSTNO		\n");
		sb.append("      ,A.KJUSO          KJUSO		\n");
		sb.append("      ,A.KDELETEYN      KDELETEYN	\n");
		sb.append("      ,A.KINSERTDATE    KINSERTDATE	\n");
		sb.append("      ,A.KUPDATEDATE    KUPDATEDATE	\n");
		sb.append("FROM  KCM_MEMBER A					\n");
		sb.append("WHERE A.KID = ?						\n");
		sb.append("AND   A.KDELETEYN = 'Y'				\n");
		System.out.println("(log) KcmSqlQueryMap.getSearchQuery() left");
		return sb.toString();
	}
	
	public static String getLikeSearchQuery(){
		System.out.println("(log) KcmSqlQueryMap.getLikeSearchQuery() entered");
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT								\n");
		sb.append("       A.KMEM           KMEM			\n");
		sb.append("      ,A.KID            KID			\n");
		sb.append("      ,A.KPW            KPW			\n");
		sb.append("      ,A.KNAME          KNAME		\n");
		sb.append("      ,A.KEMAIL         KEMAIL		\n");
		sb.append("      ,A.KHP            KHP			\n");
		sb.append("      ,A.KBIRTH         KBIRTH		\n");
		sb.append("      ,A.KPOSTNO        KPOSTNO		\n");
		sb.append("      ,A.KJUSO          KJUSO		\n");
		sb.append("      ,A.KDELETEYN      KDELETEYN	\n");
		sb.append("      ,A.KINSERTDATE    KINSERTDATE	\n");
		sb.append("      ,A.KUPDATEDATE    KUPDATEDATE	\n");
		sb.append("FROM  KCM_MEMBER A					\n");
		sb.append("WHERE A.KID LIKE '%' || ? || '%'		\n");
		sb.append("AND   A.KDELETEYN = 'Y'				\n");
		System.out.println("(log) KcmSqlQueryMap.getLikeSearchQuery() left");
		return sb.toString();
	}
	
	public static String getInsertQuery(){
		System.out.println("(log) KcmSqlQueryMap.getInsertQuery() entered");
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO KCM_MEMBER A		\n");
		sb.append("		(						\n");
		sb.append("			 A.KMEM				\n");
		sb.append("			,A.KID				\n");
		sb.append("			,A.KPW				\n");
		sb.append("			,A.KNAME			\n");
		sb.append("			,A.KEMAIL			\n");
		sb.append("			,A.KHP				\n");
		sb.append("			,A.KBIRTH			\n");
		sb.append("			,A.KPOSTNO			\n");
		sb.append("			,A.KJUSO			\n");
		sb.append("			,A.KDELETEYN		\n");
		sb.append("			,A.KINSERTDATE		\n");
		sb.append("			,A.KUPDATEDATE		\n");
		sb.append("		)						\n");
		sb.append("VALUES(						\n");
		sb.append("			 ?					\n");
		sb.append("			,?					\n");
		sb.append("			,?					\n");
		sb.append("			,?					\n");
		sb.append("			,?					\n");
		sb.append("			,?					\n");
		sb.append("			,?					\n");
		sb.append("			,?					\n");
		sb.append("			,?					\n");
		sb.append("			,'Y'				\n");
		sb.append("			,SYSDATE			\n");
		sb.append("			,SYSDATE			\n");
		sb.append("		)						  ");
		System.out.println("(log) KcmSqlQueryMap.getInsertQuery() left");
		return sb.toString();
	}
	
	public static String getUpdateQuery(){
		System.out.println("(log) KcmSqlQueryMap.getUpdateQuery() entered");
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE	KCM_MEMBER	A		\n");
		sb.append("SET		A.KPW = ?			\n");
		sb.append("WHERE	A.KID = ?			\n");
		sb.append("AND 	    A.KDELETEYN = 'Y'	\n");
		System.out.println("(log) KcmSqlQueryMap.getUpdateQuery() left");
		return sb.toString();
	}
	
	public static String getDeleteQuery(){
		System.out.println("(log) KcmSqlQueryMap.getDeleteQuery() entered");
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE	KCM_MEMBER	A		\n");
		sb.append("SET		A.KDELETEYN = 'N'	\n");
		sb.append("WHERE	A.KID = ?			\n");
		sb.append("AND 	    A.KDELETEYN = 'Y'	\n");
		System.out.println("(log) KcmSqlQueryMap.getDeleteQuery() left");
		return sb.toString();
	}
}
