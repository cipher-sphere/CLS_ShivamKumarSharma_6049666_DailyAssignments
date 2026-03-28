

package com.cg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.cg.demo.service.MovieService;
import com.cg.demo.entities.Movies;

@Controller
public class MyController {

    @Autowired
    MovieService mService;

    @RequestMapping("/greet")
    public ModelAndView processGreet() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "Welcome to Movie App");
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping("/movies")
    public ModelAndView showMovies() throws Exception {
        List<Movies> list = mService.searchAllMovies();

        ModelAndView mv = new ModelAndView();
        mv.addObject("movies", list);
        mv.setViewName("movie");
        return mv;
    }

    @RequestMapping("/addMovie")
    public ModelAndView addMovie(@RequestParam String name,
                                @RequestParam double rating,
                                @RequestParam String genre) throws Exception {

        Movies m = new Movies(name, rating, genre);
        mService.addMovie(m);

        return new ModelAndView("redirect:/movies");
    }
}