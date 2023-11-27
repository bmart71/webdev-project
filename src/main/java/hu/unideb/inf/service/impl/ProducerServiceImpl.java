package hu.unideb.inf.service.impl;

import hu.unideb.inf.dto.ProducerDTO;
import hu.unideb.inf.model.Producer;
import hu.unideb.inf.repository.ProducerRepository;
import hu.unideb.inf.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    ProducerRepository producerRepository;

    @Override
    public void saveProducer(ProducerDTO producerDTO) {
        Producer e = new Producer(producerDTO.getProducerId(), producerDTO.getName(), producerDTO.getWebAddress());
        producerRepository.save(e);
    }

    @Override
    public List<ProducerDTO> findAll() {
        List<Producer> producers = producerRepository.findAll();
        List<ProducerDTO> producerDTOS = new ArrayList<>();

        for (Producer p : producers){
            producerDTOS.add(new ProducerDTO(p.getProducerId(), p.getName(), p.getWebAddress()));
        }
        return producerDTOS;
    }
}
