package br.org.ismart.ismartonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.ismart.ismartonline.daos.MissionDAO;
import br.org.ismart.ismartonline.models.Mission;
import br.org.ismart.ismartonline.models.StudentMission;

@Controller
@Transactional
public class EvaluateController extends BaseController {

	@Autowired
	private MissionDAO missionDao;

	@RequestMapping("/evaluate")
	public ModelAndView avaliacaoAnoMissaoAvaliar(Long year, Long missionNumber, Long id, Double grade,
			int deliveryOut, int deliveryIn, int lateDelivery, int videoNoiseless, int videoTimeOk,
			int assayCharsRespect, int assayParagraphsDivision, int audioNoiseless, int audioClearTalk,
			int sheetAndReportFormatting, int sheetInfoOrganization) {

		StudentMission sm1 = missionDao.findStudentMissionById(id);
		sm1.setGrade(grade);

		sm1.setDeliveryIn(deliveryIn);
		sm1.setDeliveryOut(deliveryOut);
		
		sm1.setLateDelivery(lateDelivery);

		sm1.setVideoNoiseless(videoNoiseless);
		sm1.setVideoTimeOk(videoTimeOk);

		sm1.setAssayCharsRespect(assayCharsRespect);
		sm1.setAssayParagraphsDivision(assayParagraphsDivision);

		sm1.setAudioNoiseless(audioNoiseless);
		sm1.setAudioClearTalk(audioClearTalk);

		sm1.setSheetAndReportFormatting(sheetAndReportFormatting);
		sm1.setSheetInfoOrganization(sheetInfoOrganization);
		
		sm1.setValued(1);

		missionDao.updateStudentMission(sm1);

		ModelAndView model = new ModelAndView("admin/evaluate-mission");

		List<StudentMission> missions = missionDao.finbByYearAndNumber(year, missionNumber);

		model.addObject("missions", missions);
		model.addObject("year", year);
		model.addObject("number", missionNumber);

		return model;
	}

	// @RequestMapping("/evaluate-list")
	// public ModelAndView avaliacaoAnoMissaoAvaliarList(List<StudentMission>
	// missions) {
	//
	// StudentMission sm1 = missionDao.findStudentMissionById(id);
	// sm1.setGrade(grade);
	// missionDao.saveStudentMission(sm1);
	//
	// ModelAndView model = new ModelAndView("admin/evaluate-mission");
	//
	// List<StudentMission> missions = missionDao.finbByYearAndNumber(year,
	// missionNumber);
	//
	// for (StudentMission sm : missions) {
	// System.out.println(sm.getUser().getIsmartId() + "-" +
	// sm.getUser().getName());
	// }
	//
	// model.addObject("missions", missions);
	// model.addObject("year", year);
	// model.addObject("number", missionNumber);
	//
	// return model;
	// }
}
