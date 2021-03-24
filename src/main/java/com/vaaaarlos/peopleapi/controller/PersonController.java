package com.vaaaarlos.peopleapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.vaaaarlos.peopleapi.dto.MessageResponseDTO;
import com.vaaaarlos.peopleapi.dto.PersonDTO;
import com.vaaaarlos.peopleapi.exception.PersonNotFoundException;
import com.vaaaarlos.peopleapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
  
  private PersonService personService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
    return personService.createPerson(personDTO);
  }

  @GetMapping
  public List<PersonDTO> listAll() {
    return personService.listAll();
  }

  @GetMapping("{id}")
  public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
    return personService.findById(id);
  }

  @DeleteMapping("{id}")
  public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
    personService.deleteById(id);
  }

  @PutMapping("{id}")
  public MessageResponseDTO updatePerson(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
    return personService.updateById(id, personDTO);
  }
}
