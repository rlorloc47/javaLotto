package lotto.spring.project.api;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lotto.spring.project.lottoSearch.LottoSearchService;
import lotto.spring.project.lottoSearch.LottoSearchVO;

@Controller
public class apiController {
	@Autowired
	LottoSearchService lottoSearchService;
	private static final Logger logger = LoggerFactory.getLogger(apiController.class);
	
	@RequestMapping(value = "/apiDownload", method = RequestMethod.GET)
	public String apiList(Locale locale, Model model) {
		//21.09.14 api 다운로드 페이지로 이동
		model.addAttribute("leftMenu", "apiDownload");
		return ".tiles/api/apiDownload";
	}
	
	@RequestMapping(value = "/apiAjax", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> apiAjax(Model model, LottoSearchVO lottoSearchVO){
		//21.09.14 apiAjax 작동
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if(lottoSearchVO.getSearchNumber()!=null) {
			String[] SearchNumberList = lottoSearchVO.getSearchNumber().split(",");
			lottoSearchVO.setSearchNumberCount(SearchNumberList.length);
		}else {
			lottoSearchVO.setSearchNumberCount(45);
		}
		List<LottoSearchVO> percentageList = null;
		percentageList = this.lottoSearchService.percentageSelectList(lottoSearchVO);
		
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonArrayCell = new JSONArray();
		
		for(int b=0;b<percentageList.size();b++) {
			JSONArray jsonCell = new JSONArray();
			jsonCell.add(Integer.toString(percentageList.get(b).getBall_number()));
			jsonCell.add(percentageList.get(b).getBallCount());
			jsonArrayCell.add(jsonCell);
		}
		jsonArray.add(jsonArrayCell);
		
		model.addAttribute("jsonArray", jsonArray);
		
		resultMap.put("jsonArray", jsonArray);
		
		return resultMap;
	}
	
}
