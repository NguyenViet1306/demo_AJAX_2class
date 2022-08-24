package com.example.demo_ajax_2class.controller;

import com.example.demo_ajax_2class.model.Phone;
import com.example.demo_ajax_2class.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping(value = "/phones")
public class PhoneController {
    @Autowired
    public IPhoneService iPhoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> findAll() {
        return new ResponseEntity<>(iPhoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Phone> create(@RequestBody Phone phone) {
        return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Phone> update(@RequestBody Phone phone) {
        Optional<Phone> phoneOptional = iPhoneService.findById(phone.getId());
        if (phoneOptional.isPresent()) {
            return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Phone> delete(@PathVariable("id") Long id) {
        iPhoneService.findById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
