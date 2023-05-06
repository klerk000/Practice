package ua.com.hotel.hotelpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.service.CategoryManagerService;
import ua.com.hotel.hotelpractice.service.RoomsManagerService;

@Controller
public class CategoryManagerController {

    private final CategoryManagerService categoryService;
    private final RoomsManagerService roomsManagerService;

    @Autowired
    public CategoryManagerController(CategoryManagerService categoryService, RoomsManagerService roomsManagerService) {
        this.categoryService = categoryService;
        this.roomsManagerService = roomsManagerService;
    }

    @GetMapping("/categoryManager")
    public String getCategoryManagerPage(Model model,
                                         @RequestParam(name = "Err", defaultValue = "") String name,
                                         @RequestParam(name = "Error", defaultValue = "") String name1
    ) {
        model.addAttribute("allCategory", categoryService.getCategoryList());
        model.addAttribute("Err", name);
        model.addAttribute("Error", name1);

        return "/categoryAdminPage";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategoryToDB(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "description") String descr,
                                      @RequestParam(value = "image") String image
    ) {
        categoryService.saveCategory(name, descr, image);
        return "redirect:/categoryManager";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam(value = "id") Long id,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "description") String descr,
                                 @RequestParam(value = "image") String image) {
        categoryService.updateCategory(id, name, descr, image);
        return "redirect:/categoryManager";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(value = "id") Long id,
                                 @RequestParam(value = "id") Category category,
                                 RedirectAttributes redirectAttributes) {


        if (!roomsManagerService.sizeRoomsByCategory(category)) {
            categoryService.deleteCategory(id);
        } else {
            redirectAttributes.addAttribute("Err", "Перед видаленням категорії,будь ласка, видаліть продукцію з категорії");
        }
        return "redirect:/categoryManager";
    }

    @PostMapping("/deleteAllCategory")
    public String deleteAllCategory(RedirectAttributes redirectAttributes) {

        if (roomsManagerService.findAllRooms().size() == 0) {
            categoryService.deleteAllCategory();
        } else {
            redirectAttributes.addAttribute("Error", "Перед видаленням категорій, будь ласка, видаліть всю продукцію з категорій");
        }
        return "redirect:/categoryManager";
    }
}