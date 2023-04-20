package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.ArrayList;

@Controller
public class HelloController {

//    @GetMapping("hi")
//    @ResponseBody
//    public String hello(){
//        return "Hello, party people.";
//    }f

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

//    // Responds to get requests at /hello?name=LaunchCoder
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(@RequestParam String name) {
//        return "Hello, " + name + "!";
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

    @RequestMapping(value="hi",method = {RequestMethod.GET,RequestMethod.POST})
    public String hi(@RequestParam String name, Model model){ //Model passes data between controller and view
        String aGreeting = "Hi " + name;
        model.addAttribute("greeting",aGreeting); //sends data to html template
       return "hello"; // returns hello.html from templates
    }




    @GetMapping("form")
    public String helloForm() {
        return "form"; // this will return form.html

//                "<select name='language' id='language-select'>"+
//                "<option value='german'>german</option>"+
//                "<option value='english'>english</option>"+
//                "<option value='ukrainian'>ukrainian</option>"+
//                "<option value='spanish'>spanish</option>"+
//                "<option value='merican'>merican</option>"+
//                "</select>"
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){ //import Model object
        ArrayList<String> names = new ArrayList<>();
        names.add("Donny");
        names.add("Steve");
        names.add("Karen");

        model.addAttribute("names", names); //send names arraylist to names variable in hello-list

        return "hello-list";
    }
}





