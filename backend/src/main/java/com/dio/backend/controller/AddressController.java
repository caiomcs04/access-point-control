package com.dio.backend.controller;

import com.dio.backend.model.Address;
import com.dio.backend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.save(address);
    }

    @GetMapping
    public List<Address> getAddressList(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address>  getAddressById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(addressService.findById(id).orElseThrow(()->new Exception("address not found")));
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address){
        return addressService.update(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
