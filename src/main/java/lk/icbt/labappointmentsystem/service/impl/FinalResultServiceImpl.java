package lk.icbt.labappointmentsystem.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.icbt.labappointmentsystem.dto.CreateFinalResultDTO;
import lk.icbt.labappointmentsystem.dto.PrameterDataDTO;
import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.dto.pdf.ReportPrintDTO;
import lk.icbt.labappointmentsystem.dto.pdf.report.TestParameterDataDTO;
import lk.icbt.labappointmentsystem.entity.*;
import lk.icbt.labappointmentsystem.repeository.*;
import lk.icbt.labappointmentsystem.service.FinalResultService;
import lk.icbt.labappointmentsystem.util.PrintUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class FinalResultServiceImpl implements FinalResultService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private FinalResultRepository finalResultRepository;

    @Autowired
    private FinalResultHasTestRepository finalResultHasTestRepository;


    @Autowired
    private TestParameterRepository testParameterRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    TemplateEngine templateEngine;



    public ReservationDTO createFinalResult(CreateFinalResultDTO createFinalResultDTO){
        Optional<Reservation> reservationRepositoryById = reservationRepository.findById(createFinalResultDTO.getReservationId());
        if(reservationRepositoryById.isEmpty()){}
        Reservation reservation = reservationRepositoryById.get();
        FinalResult finalResult = new FinalResult();
        if(createFinalResultDTO.getDescription()!=null){
        finalResult.setDescription(createFinalResultDTO.getDescription());}
        finalResult.setReservation(reservationRepositoryById.get());
        FinalResult savedFinalResult = finalResultRepository.save(finalResult);
        List<FinalResultHasTest> finalResultHasTestList=new ArrayList<>();
        for (PrameterDataDTO a:createFinalResultDTO.getPrameterDataDTOList()){
            FinalResultHasTest finalResultHasTest = new FinalResultHasTest();
            Optional<TestParameter> byId = testParameterRepository.findById(a.getTestParameterId());
            finalResultHasTest.setFinalResult(savedFinalResult);
            finalResultHasTest.setTestParameter(byId.get());
            finalResultHasTest.setDescription(a.getDescription());
            finalResultHasTestRepository.save(finalResultHasTest);
            finalResultHasTestList.add(finalResultHasTest);

        }
        finalResult.setFinalResultHasTestList(finalResultHasTestList);
        finalResultRepository.save(savedFinalResult);
        reservation.setIsTested(Boolean.TRUE);
        reservationRepository.save(reservation);

        return modelMapper.map(reservation, ReservationDTO.class);

    }


    @Override
    public ByteArrayResource printReport(HttpServletRequest request, HttpServletResponse response, Long id) {
        Optional<Reservation> reservationRepositoryById = reservationRepository.findById(id);
        Reservation reservation = reservationRepositoryById.get();
        ReportPrintDTO reportPrintDTO = new ReportPrintDTO();
        reportPrintDTO.setName(reservation.getUser().getName());
        reportPrintDTO.setEmail(reservation.getUser().getEmail());
        reportPrintDTO.setTestName(reservation.getTest().getTestName());
        List<TestParameterDataDTO> printDTOList =new ArrayList<>();
        FinalResult finalResult = reservation.getFinalResult();
        List<FinalResultHasTest> finalResultHasTestList = finalResult.getFinalResultHasTestList();

        finalResultHasTestList.forEach((e)->{
            TestParameterDataDTO testParameterDataDTO = new TestParameterDataDTO();
            Optional<TestParameter> byId = testParameterRepository.findById(e.getTestParameter().getTestParameterId());
            testParameterDataDTO.setParameterName(byId.get().getTestName());
            testParameterDataDTO.setResult(e.getDescription());
            testParameterDataDTO.setParameterRange(byId.get().getParameterRange());
            printDTOList.add(testParameterDataDTO);
        });
        reportPrintDTO.setTestDetails(printDTOList);


        PrintUtils printUtils = new PrintUtils();

        ByteArrayResource pdfByteArray = printUtils.pdfGenerator(request,response,reportPrintDTO,"report",templateEngine);
        return pdfByteArray;
    }
}
