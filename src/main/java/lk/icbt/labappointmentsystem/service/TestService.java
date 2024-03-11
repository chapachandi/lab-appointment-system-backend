package lk.icbt.labappointmentsystem.service;

import lk.icbt.labappointmentsystem.dto.TestDTO;
import lk.icbt.labappointmentsystem.dto.TestParameterDTO;
import lk.icbt.labappointmentsystem.entity.Test;
import lk.icbt.labappointmentsystem.entity.TestParameter;

import java.util.List;
import java.util.stream.Collectors;

public interface TestService {

    public List<TestDTO> getAllTests() ;

    public TestDTO getTestById(Integer testId) ;

    public TestDTO createTest(TestDTO testDTO);

    public TestDTO updateTest(Integer testId, TestDTO testDTO) ;

    public void deleteTest(Integer testId);

    public List<TestParameterDTO>  getTestParameter(Integer testId);

}
