package de.c24.finacc.klt.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.c24.finacc.klt.service.AddNewApplication;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * IndexController
 *
 * @author Jörn Schricker
 */
@Controller
public class IndexController {
    private static final Logger LOGGER = LogManager.getLogger(IndexController.class);
    
    @Inject
	AddNewApplication addNewApplication;

    @Value("${form.title}")
    private String formTitle;

    /**
     * the index page
     *
     * @return ModelAndView for index page.
     */
    @GetMapping({"/", "/index"})
    public String index(Map<String, Object> model) {
        model.put("formName", formTitle);

        return "index";
    }


    /**
     * the index page
     *
     * @return ModelAndView for index page.
     */
    @PostMapping({"/", "/index"})
    public String submitForm(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,@RequestParam("age") int age) {
        LOGGER.debug("submit first name {} last name {}", firstName, lastName);
        addNewApplication.addNewApplicationToInMemory(firstName, lastName,age);
		return "registrationSuccess";
    }
}
