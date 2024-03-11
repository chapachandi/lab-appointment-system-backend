package lk.icbt.labappointmentsystem.service.impl;

import lk.icbt.labappointmentsystem.dto.TestDTO;
import lk.icbt.labappointmentsystem.dto.TestParameterDTO;
import lk.icbt.labappointmentsystem.entity.Test;
import lk.icbt.labappointmentsystem.entity.TestParameter;
import lk.icbt.labappointmentsystem.repeository.TestRepository;
import lk.icbt.labappointmentsystem.service.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {



        @Autowired
        private TestRepository testRepository;

        @Autowired
        private ModelMapper modelMapper;

        public List<TestDTO> getAllTests() {
            return testRepository.findAll().stream()
                    .map(test -> modelMapper.map(test, TestDTO.class))
                    .collect(Collectors.toList());
        }

        public TestDTO getTestById(Integer testId) {
            Test test = testRepository.findById(testId).orElse(null);
            return modelMapper.map(test, TestDTO.class);
        }

        public TestDTO createTest(TestDTO testDTO) {
            Test test = modelMapper.map(testDTO, Test.class);
           // test.setCreatedDate(Instant.now());
            test = testRepository.save(test);
            return modelMapper.map(test, TestDTO.class);
        }

        public TestDTO updateTest(Integer testId, TestDTO testDTO) {
            Test test = testRepository.findById(testId).orElse(null);
            if (test != null) {
                /*test.setTestName(testDTO.getName());
                test.setPrice(testDTO.getPrice());*/
                test = testRepository.save(test);
                return modelMapper.map(test, TestDTO.class);
            }
            return null;
        }

        public void deleteTest(Integer testId) {
            testRepository.deleteById(testId);
        }

    @Override
    public List<TestParameterDTO> getTestParameter(Integer testId) {
        Optional<Test> test = testRepository.findById(testId);
        List<TestParameter> testParameterList = test.get().getTestParameterList();
        List<TestParameterDTO> testParameterDTOS = testParameterList.stream().map((e) ->
                modelMapper.map(e, TestParameterDTO.class)
        ).collect(Collectors.toList());


        return testParameterDTOS;
    }
}