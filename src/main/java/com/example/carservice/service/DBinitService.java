package com.example.carservice.service;

import com.example.carservice.entity.*;
import com.example.carservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBinitService implements CommandLineRunner {

    @Autowired
    private BodyTypeRepository bodyTypeRepository;

    @Autowired
    private CarMarkRepository carMarkRepository;

    @Autowired
    private EngineLayoutTypeRepository engineLayoutTypeRepository;

    @Autowired
    private ManufactureRepository manufactureRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Client admin=clientRepository.findClientByTelephoneNumber("7777777777");
        if (admin==null)
        {
            admin=new Client();
            admin.setName("admin");
            admin.setSurname("admin");
            admin.setTelephoneNumber("7777777777");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setPassportData("UniqueAndSecret");
            clientRepository.save(admin);
        }
        List<BodyType> bodyTypes=List.of(new BodyType("PICKIUP"),new BodyType("SUV"),new BodyType("COUPE"),new BodyType("CONVERTIBLE"),new BodyType("SEDAN"),new BodyType("MINICAR"));
        if (bodyTypeRepository.findAll().size()!= bodyTypes.size())
        {
            bodyTypeRepository.saveAll(bodyTypes);
        }
        List<CarMark> carMarks =List.of(new CarMark("Mercedes","AMG"),new CarMark("Mercedes","Maybach"),new CarMark("Mercedes","EQ"),new CarMark("BMW","X3"),new CarMark("BMW","X5"),new CarMark("BMW","X7"));
        if (carMarkRepository.findAll().size()!=carMarks.size())
        {
            carMarkRepository.saveAll(carMarks);
        }
        List<EngineLayoutType> engineLayoutTypes=List.of(new EngineLayoutType("Longitudinal"),new EngineLayoutType("Transverse"));
        if (engineLayoutTypeRepository.findAll().size()!=engineLayoutTypes.size())
        {
            engineLayoutTypeRepository.saveAll(engineLayoutTypes);
        }
        List<Manufacture> manufactures=List.of(new Manufacture("Russia","Moscow"),new Manufacture("Russia","Saint-Petersburg"),new Manufacture("German","Stuttgart"),new Manufacture("Japan","Tokyo"),new Manufacture("German","Munchen"),new Manufacture("Chine","Hong Kong"),new Manufacture("China","Taiwan"));
        if (manufactureRepository.findAll().size()!=manufactures.size())
        {
            manufactureRepository.saveAll(manufactures);
        }

        List<PaymentType> paymentTypes=List.of(new PaymentType("VISA"),new PaymentType("MASTERCARD"),new PaymentType("QIWI"),new PaymentType("CASH"));
        if (paymentTypeRepository.findAll().size()!=paymentTypes.size())
        {
            paymentTypeRepository.saveAll(paymentTypes);
        }
    }

}
