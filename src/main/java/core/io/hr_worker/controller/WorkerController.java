package core.io.hr_worker.controller;

import core.io.hr_worker.repository.WorkerRepository;
import core.io.hr_worker.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerController {
    private final WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workers = workerRepository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Optional<Worker> worker = workerRepository.findById(id);
        return ResponseEntity.ok(worker.get());
    }
}
