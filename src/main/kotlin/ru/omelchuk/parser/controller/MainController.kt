package ru.omelchuk.parser.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.omelchuk.parser.service.ParserService

@Controller
class MainController {
    @Autowired
    private lateinit var parserService: ParserService

    @GetMapping("/")
    fun getMainPage(): String {
        return "hello"
    }

    @RequestMapping("/refresh")
    fun getNewResult(model: Model):String{
        //step-by-step
        //create new model
        //create new service
        //get data
        //post result

        model.addAttribute("result", parserService.fillLoto())
        return "hello"
    }
}