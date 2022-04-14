package com.KernelByte.ProjectIsMutant.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.KernelByte.ProjectIsMutant.models.Mutant;
import com.KernelByte.ProjectIsMutant.service.MutantService;

import lombok.RequiredArgsConstructor;

@RestController	
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MutantController {
    
	@Autowired
	private  MutantService mutantService;
	
	@PostMapping("/mutant")
	public void save(@RequestBody Mutant mutant){
		mutantService.save(mutant);
	}

    @GetMapping("/mutants")
	public List<Mutant> findALL(){
    	return mutantService.findALL();
    }
    
    @GetMapping("/mutant/{id}")
    public Mutant findById( @PathVariable String id) {
    	return mutantService.findId(id).get();
    }
    
    @GetMapping("/mutantcheck/{dna}")
    public ResponseEntity<String> isMutant (@PathVariable String[] dna) {
    	
    	boolean responseDna = mutantService.isMutant(dna);
    	
    	if (responseDna) {
    		return new ResponseEntity<>(HttpStatus.OK + ": HTTP 200-OK", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN + ": 403-Forbidden", HttpStatus.FORBIDDEN);
		}
    }
    
	
    @DeleteMapping("/mutant/{id}")
	public void deleteById( @PathVariable String id) {
		mutantService.deleteById(id);
	}
    
    @PutMapping("/mutants")
    public void update(@RequestBody Mutant mutant) {
    	mutantService.save(mutant);
    }
}
