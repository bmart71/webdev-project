package hu.unideb.inf.service;

import hu.unideb.inf.dto.ProducerDTO;

import java.util.List;

public interface ProducerService {
    void saveProducer(ProducerDTO producerDTO);
    List<ProducerDTO> findAll();
}
