package eurasia;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.threem.eurasia.sample.EurasiaMapper;

public class MyBatisTest {

	//MyBatis XML 설정 값 자바로 직접 연결해서 사용해 보기 !! 
	@Test
	public void testMybatis_sqlSession_직접연결사용해보기() throws Exception {
		
		String resource = "spring/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		EurasiaMapper mapper = session.getMapper(EurasiaMapper.class);
		
		String sampleResult = mapper.selectEurasia();
		
		System.out.println(sampleResult);
		
		session.close();
		
	}
	
	//MyBatis XML 설정 값 자바로 직접 연결해서 사용해 보기 !! 
	@Test
	public void testMybatis_sqlSession_직접연결사용해보기2() throws Exception {
		
		String resource = "spring/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();

		String sampleResult = (String)session.selectOne("com.threem.eurasia.sample.EurasiaMapper.selectEurasia");
		
		System.out.println(sampleResult);
		
		session.close();
		
	}
	
	//MyBatis XML 설정 값 자바로 직접 연결해서 사용해 보기 !! 
	@Test
	public void testMybatis_sqlSession_직접연결사용해보기_annotation이용() throws Exception {
		
		String resource = "spring/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();

		String sampleResult = (String)session.selectOne("com.threem.eurasia.sample.EurasiaMapper.selectAnnotationEurasia");
		
		session.close();
		
		System.out.println(sampleResult);
		
	}
	
	
}
