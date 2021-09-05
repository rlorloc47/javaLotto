package lotto.spring.project.qna;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<QnaVO> qnaSelectList(QnaVO qnaVO) {
		return this.sqlSessionTemplate.selectList("qna.qnaSelectList",qnaVO);
	}

	public void qnaInsert(QnaVO qnaVO) {
		this.sqlSessionTemplate.insert("qna.qnaInsert",qnaVO);
	}

	public int qnaMaxSeq() {
		return this.sqlSessionTemplate.selectOne("qna.qnaMaxSeq");
	}

	public int qnaMaxGroupSeq() {
		return this.sqlSessionTemplate.selectOne("qna.qnaMaxGroupSeq");
	}
}
