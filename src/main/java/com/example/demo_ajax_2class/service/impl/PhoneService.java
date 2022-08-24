package com.example.demo_ajax_2class.service.impl;

import com.example.demo_ajax_2class.model.Phone;
import com.example.demo_ajax_2class.repository.PhoneRepository;
import com.example.demo_ajax_2class.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PhoneService implements IPhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void delete(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return phoneRepository.findById(id);
    }
}
