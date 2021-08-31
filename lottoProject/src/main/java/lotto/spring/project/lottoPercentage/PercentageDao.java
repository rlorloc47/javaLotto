package lotto.spring.project.lottoPercentage;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PercentageDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<PercentageVO> percentageSelectList(PercentageVO percentageVO) {
		return this.sqlSessionTemplate.selectList("pct.percentageSelectList",percentageVO);
	}
}
