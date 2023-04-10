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
    public String hello(@RequestParam String coder, String language) {
        return createMessage(coder,language);
    }
    public static String createMessage(String name,String language){
        String message = "";
        if (language.equals("english")){
            message= "Hello, " + name + "!";
        }
        else if(language.equals("merican")){
            message= "Howdy, " + name + "!";
        }else if(language.equals("german")){
            message= "Hallo, " + name + "!";
        }
        else if(language.equals("ukrainian")){
            message= "Pryvit, " + name + "!";
        }else if(language.equals("spanish")){
            message= "Hola, " + name + "!";
        }
        return message;
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<label>What is your name?</label>"+
                        "<form method = 'post' action = '/hello'>" + // sends to url/hello
                        "<input type = 'text' name = 'coder' />" + // sends ?coder=string
                        "<select name='language' id='language-select'>"+
                        "<option value='german'>german</option>"+
                        "<option value='english'>english</option>"+
                        "<option value='ukrainian'>ukrainian</option>"+
                        "<option value='spanish'>spanish</option>"+
                        "<option value='merican'>merican</option>"+
                        "</select>"+
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;

//                "<select name='language' id='language-select'>"+
//                "<option value='german'>german</option>"+
//                "<option value='english'>english</option>"+
//                "<option value='ukrainian'>ukrainian</option>"+
//                "<option value='spanish'>spanish</option>"+
//                "<option value='merican'>merican</option>"+
//                "</select>"
    }
}





