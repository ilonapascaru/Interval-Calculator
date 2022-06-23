package ness.controller;

import ness.beans.Input;
import ness.beans.Output;
import ness.service.IntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RestControllerNess {

    @Autowired
    IntervalService intervalService;

    @PostMapping(value= "/api/duration", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Output> returnJson(@RequestBody List<Input> inputs){
        return intervalService.getOutputIntervals(inputs);
    }

    @RequestMapping(value="/intervals")
    public ResponseEntity<Object> getIntervals(){
        return new ResponseEntity<>(intervalService.getIntervals(), HttpStatus.OK);
    }

    @PutMapping(value="/intervals/{id}")
    public ResponseEntity<Object> updateIntervals(@PathVariable("id") int id, @RequestBody Input input){
        intervalService.updateInterval(id,input);
        return new ResponseEntity<>("interval added", HttpStatus.OK);
    }

    @DeleteMapping(value="/intervals/{id}")
    public ResponseEntity<Object> deleteIntervals(@PathVariable("id") int id) {
        intervalService.deleteProduct(id);
        return new ResponseEntity<>("interval deleted", HttpStatus.OK);
    }

    @GetMapping(value="/intervals/{id}")
    public ResponseEntity<Object> getInterval(@PathVariable("id") int id){
        return new ResponseEntity<>(intervalService.getInterval(id), HttpStatus.OK);
    }

}
