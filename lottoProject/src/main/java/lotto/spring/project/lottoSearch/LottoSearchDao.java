package lotto.spring.project.lottoSearch;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LottoSearchDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<LottoSearchVO> percentageSelectList(LottoSearchVO lottoSearchVO) {
		return this.sqlSessionTemplate.selectList("pct.percentageSelectList",lottoSearchVO);
	}

	public List<LottoSearchVO> lottoSearchList(LottoSearchVO lottoSearchVO) {
		return this.sqlSessionTemplate.selectList("pct.lottoSearchList",lottoSearchVO);
	}

	public int lottoSearchCount(LottoSearchVO lottoSearchVO) {
		return this.sqlSessionTemplate.selectOne("pct.lottoSearchCount",lottoSearchVO);
	}
}
