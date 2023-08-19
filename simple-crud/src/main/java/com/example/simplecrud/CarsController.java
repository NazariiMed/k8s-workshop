package com.example.simplecrud;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarsController {

    private final CarRepository carRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public List<Car> getCars() {
        logger.info("list cars");
        return carRepository.findAll();
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        logger.info("update/save car");
        return carRepository.save(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id) {
        logger.info("get car by id");
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            return ResponseEntity.of(carOptional);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        logger.info("delete car");
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
