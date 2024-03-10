package lk.icbt.labappointmentsystem.service.impl;

import lk.icbt.labappointmentsystem.dto.InvoiceCreateDTO;
import lk.icbt.labappointmentsystem.dto.InvoiceDTO;
import lk.icbt.labappointmentsystem.dto.UserDTO;
import lk.icbt.labappointmentsystem.entity.Invoice;
import lk.icbt.labappointmentsystem.entity.Reservation;
import lk.icbt.labappointmentsystem.entity.User;
import lk.icbt.labappointmentsystem.exception.NotFoundException;
import lk.icbt.labappointmentsystem.exception.ValidateException;
import lk.icbt.labappointmentsystem.repeository.InvoiceRepository;
import lk.icbt.labappointmentsystem.repeository.ReservationRepository;
import lk.icbt.labappointmentsystem.repeository.UserRepository;
import lk.icbt.labappointmentsystem.service.InvoiceService;
import lk.icbt.labappointmentsystem.service.ReservationService;
import lk.icbt.labappointmentsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public InvoiceDTO createInvoice(InvoiceCreateDTO invoiceCreateDTO) {
        List<Reservation> allReservations = reservationRepository.findAllById(invoiceCreateDTO.getReservationIdList());

        Optional<User> user = userRepository.findById(invoiceCreateDTO.getUserId());
        StringBuilder stringBuilder = new StringBuilder();
        BigDecimal totalAmout = new BigDecimal(0);
        for (Reservation e : allReservations) {
            totalAmout = totalAmout.add(e.getTest().getPrice());
            stringBuilder.append(e.getTest().getTestName());

        }

        Invoice invoice = Invoice.builder().amount(totalAmout).user(user.get()).productDescription(stringBuilder.toString()).build();
        Invoice saveInvoice = invoiceRepository.save(invoice);
        allReservations.stream().forEach((e)->{
            e.setInvoice(saveInvoice);
        });
        List<Reservation> reservations = reservationRepository.saveAll(allReservations);

        return  modelMapper.map(saveInvoice, InvoiceDTO.class);
    }
}
