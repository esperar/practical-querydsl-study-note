package esperer.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import esperer.querydsl.entity.Hello;
import esperer.querydsl.entity.QHello;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class QuerydslApplicationTests {

	@Autowired
	EntityManager em;


	@Test
	void contextLoads() {
	}

	@Test
	void querydsl() {
		Hello hello = new Hello();
		em.persist(hello);

		JPAQueryFactory query = new JPAQueryFactory(em);
		QHello qHello = QHello.hello; //Querydsl Q타입 동작 확인

		Hello result = query
				.selectFrom(qHello)
				.fetchOne();
		assertThat(result).isEqualTo(hello);
		assertThat(result.getId()).isEqualTo(hello.getId());
	}

}
