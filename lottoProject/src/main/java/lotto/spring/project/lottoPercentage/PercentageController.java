package lotto.spring.project.lottoPercentage;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PercentageController {
	@Autowired
	PercentageService percentageService;
	
	@RequestMapping(value = "/percentageList", method = RequestMethod.GET)
	public String home(Locale locale,Model model, PercentageVO percentageVO) {
		//21.08.26 문의게시판 리스트 페이지로 이동
		List<PercentageVO> percentageList = null;
		percentageList = this.percentageService.percentageSelectList(percentageVO);
		
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonFirst = new JSONArray();
		jsonFirst.add("로또숫자");
		jsonFirst.add("횟수");
		jsonArray.add(jsonFirst);
		
		for(int a=0;a<percentageList.size();a++) {
			JSONArray jsonCell = new JSONArray();
			jsonCell.add(Integer.toString(percentageList.get(a).getBall_number()));
			jsonCell.add(percentageList.get(a).getBallCount());
			jsonArray.add(jsonCell);
		}
		System.out.println("나는야"+jsonArray.get(0));
		
		model.addAttribute("percentageList", percentageList);
		model.addAttribute("jsonArray", jsonArray);
		
		return ".tiles/percentage/percentageList";
	}
}
