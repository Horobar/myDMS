package myoffice.dms.controller


import myoffice.dms.model.FileModel
import myoffice.dms.controller.ControllerConfig.Companion.VERSION
import myoffice.dms.service.ScannedFileService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest

@Controller("/$VERSION/dms")
class DmsController(
    val fileCollectorService: ScannedFileService
) {

    @ModelAttribute("files")
    fun fileList(): List<FileModel> = fileCollectorService.listFiles()




    @GetMapping("/")
    fun getDms(request: HttpServletRequest): ModelAndView{
        val modelAndView = ModelAndView("dmsMain")
        modelAndView.addObject("files", fileList())
        return modelAndView

    }

}