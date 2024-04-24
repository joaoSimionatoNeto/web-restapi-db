package ps2.restapidb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaRepo DisciplinaRepo;

	@GetMapping("/api/Disciplinas")
	Iterable<Disciplina> getDisciplinas() {
		return DisciplinaRepo.findAll();
	}
	
	@GetMapping("/api/Disciplinas/{id}")
	Optional<Disciplina> getDisciplina(@PathVariable long id) {
		return DisciplinaRepo.findById(id);
	}
	
	@PostMapping("/api/Disciplinas")
	Disciplina createDisciplina(@RequestBody Disciplina f) {
		Disciplina createdFac = DisciplinaRepo.save(f);
		return createdFac;
	}
	
	@PutMapping("/api/Disciplinas/{DisciplinaId}")
	Optional<Disciplina> updateDisciplina(@RequestBody Disciplina DisciplinaReq, @PathVariable long DisciplinaId) {
		Optional<Disciplina> opt = DisciplinaRepo.findById(DisciplinaId);
		if (opt.isPresent()) {
			if (DisciplinaReq.getId() == DisciplinaId) {
				DisciplinaRepo.save(DisciplinaReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da Disciplina com id " + DisciplinaId);
	}	
	
	@DeleteMapping("/api/Disciplinas/{id}")
	void deleteDisciplina(@PathVariable long id) {
		DisciplinaRepo.deleteById(id);
	}	
	
}