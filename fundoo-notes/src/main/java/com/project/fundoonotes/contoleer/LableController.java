package com.project.fundoonotes.contoleer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.model.Label;
import com.project.fundoonotes.model.Response;
import com.project.fundoonotes.service.LabelService;


@RestController
@RequestMapping("/label")
public class LableController {
	
	@Autowired
	private LabelService labelService;
	
	@GetMapping("/getall")
	public ResponseEntity<Response> getAllLabels() {
		List<Label> labelList = null;
		 labelList = labelService.getAllLabels();
		Response respDTO = new Response("Get call success",  labelList);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getLabelById(@PathVariable("id") int id) {
		Label label = null;
		label = labelService.geLabelById(id);
		Response respDTO = new Response("Get call success for id:" + id, label);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}


	@PostMapping("/create")
	public ResponseEntity<Response> createLabel( @RequestBody LabelDto labelDto) {
		Label createLabel = null;
		createLabel = labelService.creatLabel(labelDto);
		Response respDTO = new Response("created Label successfully", createLabel);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateLabel(@PathVariable("id") int id,
			@RequestBody LabelDto labelDto) {
		Label createLabel = null;
		createLabel = labelService.updateLabel(id, labelDto);
		Response respDTO = new Response("Updated Label successfully", createLabel);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Response> deleteLabel(@PathVariable("id") int id) {
		labelService.deleteLabelbyID(id);
		Response respDTO = new Response("Deleted Label Successfully",
				"deleted labelId is :" + id);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}


}
