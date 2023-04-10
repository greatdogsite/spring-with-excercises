package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("hi")
    @ResponseBody
    public String hello(){
        return "Hello, party people.";
    }

//    @PostMapping("bye")
//    @ResponseBody
//    public String bye(){
//        return "Bye, party people.";
//    }
//    @RequestMapping("bye") //defaults to Get
    @RequestMapping(value="bye", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String bye(){
        return "Bye, party people.";
    }

//    // Responds to get requests at /hello?coder=LaunchCoder
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(@RequestParam String coder) {
//        return "Hello, " + coder + "!";
//    }

    // Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String coder) {
        return "Hello, " + coder + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" + // sends to url/hello
                        "<input type = 'text' name = 'coder' />" + // sends ?coder=string
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }
}





