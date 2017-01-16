package com.catho.opportunity.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
@RestController
@RequestMapping("/")
@ApiIgnore
public class SwaggerResource {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public RedirectView redirectToSwagger() {
        return new RedirectView("swagger-ui.html#");
    }

}
