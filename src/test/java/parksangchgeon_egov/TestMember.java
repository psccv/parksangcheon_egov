package parksangchgeon_egov;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.human.com.member.service.EmployerInfoVO;
import edu.human.com.member.service.impl.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={
"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-servlet.xml",
"file:src/main/resources/egovframework/spring/com/*.xml"})
@WebAppConfiguration
public class TestMember {
	
	@Inject
	private DataSource ds;
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testSelectMember() throws Exception {
		List<EmployerInfoVO> list = dao.selectMember();
		for(EmployerInfoVO vo:list) {
			System.out.print("회원아이디: " + vo.getEMPLYR_ID());
			System.out.println(" / 회원이름: " + vo.getUSER_NM());
		}
	}
	
	@Test
	public void testViewMember() throws Exception{
		EmployerInfoVO vo = dao.viewMember("admin");
		System.out.print("상세정보: " + vo.toString());
	}
	
	@Test
	public void testInsertMember() throws Exception {
		EmployerInfoVO vo = new EmployerInfoVO();
		int uid = (int) (Math.random()*100); 
		vo.setEMPLYR_ID("user_" + uid);
		vo.setESNTL_ID("test");
		vo.setPASSWORD("JfQ7FIatlaE5jj7rPYO8QBABX8yb7bNbQy4AKY1QIfc=");
		vo.setPASSWORD_HINT("학교 종이");
		vo.setPASSWORD_CNSR("땡땡떙");
		vo.setUSER_NM("둘리");
		vo.setZIP("456");
		vo.setHOUSE_ADRES("천안");
		vo.setEMAIL_ADRES("dooli@test.com");
		vo.setGROUP_ID("GROUP_00000000000001");
		vo.setORGNZT_ID("ORGNZT_0000000000001");
		vo.setEMPLYR_STTUS_CODE("P");
		dao.insertMember(vo);
	}
	
	@Test
	public void testUpdateMember() throws Exception {
		EmployerInfoVO vo = new EmployerInfoVO();
		vo.setEMPLYR_ID("admin");
		vo.setESNTL_ID("test");
		vo.setPASSWORD("JfQ7FIatlaE5jj7rPYO8QBABX8yb7bNbQy4AKY1QIfc=");
		vo.setPASSWORD_HINT("학교 종이");
		vo.setPASSWORD_CNSR("땡땡떙");
		vo.setUSER_NM("둘리");
		vo.setZIP("456");
		vo.setHOUSE_ADRES("천안");
		vo.setEMAIL_ADRES("dooli@test.com");
		vo.setGROUP_ID("GROUP_00000000000000");
		vo.setORGNZT_ID("ORGNZT_0000000000000");
		vo.setEMPLYR_STTUS_CODE("P");
		dao.updateMember(vo);
	}
	
	@Test
	public void testDeleteMember() throws Exception{
		dao.deleteMember("user_82");
	}
	
	
	@Test
	public void testDBConnect() throws SQLException {
		Connection con = ds.getConnection();
		System.out.println("데이터베이스 커넥션 결과: " + con);
	}
	@Test
	public void test() {
		//fail("Not yet implemented");
		System.out.println("Junit 테스트");
	}

}
