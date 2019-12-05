package com.example.dataSourceDemo.app.controllers;

import com.example.dataSourceDemo.domain.models.Person;
import com.example.dataSourceDemo.domain.services.PersonService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

  private PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/")
  public ModelAndView index(ModelAndView modelAndView) {
    // stgのpersonレコードを取得
    List<Person> stgPersonList = personService.findAllPersonInStg();
    modelAndView.addObject(stgPersonList);

    // prodのpersonレコードを取得
    List<Person> prodPersonList = personService.findAllPersonInProd();
    modelAndView.addObject(prodPersonList);

    modelAndView.setViewName("template");
    return modelAndView;
  }
}
