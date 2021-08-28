package lotto.spring.project.qna;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<QnaVO> qnaSelectList() {
		return this.sqlSessionTemplate.selectList("qna.qnaSelectList");
	}
}
