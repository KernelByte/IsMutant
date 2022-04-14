package com.KernelByte.ProjectIsMutant.service;

import com.KernelByte.ProjectIsMutant.models.Mutant;
import com.KernelByte.ProjectIsMutant.utility.ComString;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.KernelByte.ProjectIsMutant.repository.MutantRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MutantService {
	
	@Autowired
   private MutantRepository mutantRepository;
   
   public void save(Mutant mutant) {
	   mutantRepository.save(mutant);
   }
   
   // Otener todo
   public List<Mutant> findALL(){
	   return mutantRepository.findAll();
   }
   
   //Obtener un registro por el id
   public Optional<Mutant> findId(String id) {
	   return mutantRepository.findById(id);
   }
   
   //Eliminar un registro
   public void deleteById(String id) {
	   mutantRepository.deleteById(id);
   }
   
   
   // Verificar si es humano o mutante
   public boolean isMutant(String[] dna) {  
	   boolean respuesta = false;
	   int contadorDna = 0;
	   
	   for (int i = 0; i < dna.length; i++) {
			for (int j = 0; j < dna[i].length(); j++) {
				if (j < dna[i].length() - 3) {

					if (ComString.areEqualDna(dna[i].charAt(j), dna[i].charAt(j + 1), dna[i].charAt(j + 2), dna[i].charAt(j + 3))) {
						contadorDna++;
					}
				}
				if (contadorDna > 0) {
					respuesta = true;
				}
			}
		}
	   return respuesta;
	   
   }
   
   public void getCheckMutant(String[] dna) {
        Mutant mutant = new Mutant();
		mutant.setCadenaDna(dna);
		
		mutantRepository.save(mutant);
		
	}
   
}
