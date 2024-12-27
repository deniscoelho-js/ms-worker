package core.io.hr_worker.controller;

import core.io.hr_worker.repository.WorkerRepository;
import core.io.hr_worker.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
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

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    private final Environment environment;
    private final WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workers = workerRepository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        logger.info("PORT = " + environment.getProperty("local.server.port"));

        Optional<Worker> worker = workerRepository.findById(id);
        return ResponseEntity.ok(worker.get());
    }
}
