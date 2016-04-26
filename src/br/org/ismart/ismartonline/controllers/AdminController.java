package br.org.ismart.ismartonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.org.ismart.ismartonline.daos.MissionDAO;
import br.org.ismart.ismartonline.models.Mission;
import br.org.ismart.ismartonline.models.StudentMission;

@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController {

	@Autowired
	private MissionDAO missionDao;

	@RequestMapping
	public String home() {

		return "admin/home";

	}

	@RequestMapping("/avaliacao/ano-{year}")
	public ModelAndView avaliacaoAnoId(@PathVariable("year") Long year) {

		ModelAndView model = new ModelAndView("admin/evaluate");

		List<Mission> missions = missionDao.finbByYear(year);

		model.addObject("missions", missions);
		model.addObject("year", year);

		return model;

	}

	@RequestMapping("/avaliacao/ano-{year}/missao-{missionNumber}")
	public ModelAndView avaliacaoAnoMissao(@PathVariable("year") Long year,
			@PathVariable("missionNumber") Long missionNumber) {
		ModelAndView model = new ModelAndView("admin/evaluate-mission");

		List<StudentMission> missions = missionDao.finbByYearAndNumber(year, missionNumber);

		for (StudentMission sm : missions) {
			System.out.println(sm.getUser().getIsmartId() + "-" + sm.getUser().getName());
		}

		model.addObject("missions", missions);
		model.addObject("year", year);
		model.addObject("number", missionNumber);

		return model;

	}

}
