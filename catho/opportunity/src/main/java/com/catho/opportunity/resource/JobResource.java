package com.catho.opportunity.resource;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.catho.opportunity.services.JobService;
import com.catho.opportunity.to.ResultTO;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
@RestController
@RequestMapping("/job")
public class JobResource {

    @Autowired
    private JobService jobService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Object> save() {
        this.jobService.save();
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "q", value = "Search value", required = true, dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "fields", value = "Search fields", defaultValue="title,description,cidade,salario", required = false, dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "page", value = "Search page", defaultValue="0", required = false, dataType = "integer", paramType = "query"),
        @ApiImplicitParam(name = "limit", value = "Search limit", defaultValue="10", required = false, dataType = "long", paramType = "query"),
        @ApiImplicitParam(name = "orderby", value = "Search orderby", defaultValue="salario", required = false, dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "sorted", value = "Search sorted", defaultValue="asc", required = false, dataType = "string", paramType = "query")
      })
    public @ResponseBody
    ResponseEntity<Object> search(HttpServletRequest request) {
        long start = System.currentTimeMillis();
        Map<String, String[]> parameterMap = request.getParameterMap();
        ResultTO resultTO = jobService.search(parameterMap);
        resultTO.setTotalTime(System.currentTimeMillis() - start);
        return new ResponseEntity<>(resultTO, HttpStatus.OK);
    }

}
