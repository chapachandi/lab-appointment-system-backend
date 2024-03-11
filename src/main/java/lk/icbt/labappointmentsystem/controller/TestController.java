package lk.icbt.labappointmentsystem.controller;

import lk.icbt.labappointmentsystem.dto.TestDTO;
import lk.icbt.labappointmentsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/test")
@CrossOrigin
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public List<TestDTO> getAllTests() {
        return testService.getAllTests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestDTO> getTestById(@PathVariable Integer id) {
        TestDTO testDTO = testService.getTestById(id);
        if (testDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(testDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TestDTO>> getTestAll() {
        List<TestDTO> allTests = testService.getAllTests();
        return new ResponseEntity<>(allTests, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<TestDTO> createTest(@RequestBody TestDTO testDTO) {
        TestDTO createdTestDTO = testService.createTest(testDTO);
        return new ResponseEntity<>(createdTestDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestDTO> updateTest(@PathVariable Integer id, @RequestBody TestDTO testDTO) {
        TestDTO updatedTestDTO = testService.updateTest(id, testDTO);
        if (updatedTestDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTestDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Integer id) {
        testService.deleteTest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
