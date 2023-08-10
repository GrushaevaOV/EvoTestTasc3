package evo.task.evoTestTask3.controllers;

import evo.task.evoTestTask3.models.*;
import evo.task.evoTestTask3.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    private final BrandService brandService;
    private final ProcessorService processorService;
    private final HardDiskService hardDiskService;
    private final OperatingFeeService operatingFeeService;
    private final CoolerService coolerService;
    private final MotherboerderService motherboerderService;

    @Autowired
    public BrandsController(BrandService brandService, ProcessorService processorService, HardDiskService hardDiskService, OperatingFeeService operatingFeeService, CoolerService coolerService, MotherboerderService motherboerderService) {
        this.brandService = brandService;
        this.processorService = processorService;
        this.hardDiskService = hardDiskService;
        this.operatingFeeService = operatingFeeService;
        this.coolerService = coolerService;
        this.motherboerderService = motherboerderService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("brands", brandService.findAll());
        return "brands/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model,
                       @ModelAttribute("processor") Processor processor,
                       @ModelAttribute("disc") HardDisc hardDisc,
                       @ModelAttribute("operating") OperatingFee operatingFee,
                       @ModelAttribute("cooler") Cooler cooler,
                       @ModelAttribute("motherboarder") Motherboarder motherboarder) {
        model.addAttribute("brand", brandService.findOne(id));
        model.addAttribute("brandsProcessor", processorService.findChoice());
        model.addAttribute("brandsDisc", hardDiskService.findChoice());
        model.addAttribute("brandsOperating", operatingFeeService.findChoice());
        model.addAttribute("brandCooler", coolerService.findChoice());
        model.addAttribute("brandsMotherboarder", motherboerderService.findChoice());
        model.addAttribute("processors", brandService.getProcessor(id));
        model.addAttribute("discs", brandService.getHardDisc(id));
        model.addAttribute("operatingfees", brandService.getOperatingFee(id));
        model.addAttribute("coolers", brandService.getCooler(id));
        model.addAttribute("motherboarders",brandService.getMotherboarder(id));
        return "brands/show";
    }

    @PatchMapping("/addprocessor/{id}")
    public String makeProcessorBrand(@PathVariable("id") int id, @ModelAttribute("processor") Processor processor) {
        processorService.makeProcessorBrand(processor);
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/adddisc/{id}")
    public String makeDiscBrand(@PathVariable("id") int id, @ModelAttribute("disc") HardDisc disc) {
        hardDiskService.makeYardDiscBrand(disc);
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/addoperating/{id}")
    public String makeOpeeratingFeeBrand(@PathVariable("id") int id, @ModelAttribute("operating") OperatingFee operatingFee) {
        operatingFeeService.makeOperatingFeeBrand(operatingFee);
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/addcooler/{id}")
    public String makeCoolerBrand(@PathVariable("id") int id, @ModelAttribute("cooler") Cooler cooler) {
        coolerService.makeCoolerBrand(cooler);
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/addmotherboarder/{id}")
    public String makeMotherboarderBrand(@PathVariable("id") int id, @ModelAttribute("motherboarder") Motherboarder motherboarder) {
        motherboerderService.makeMotherboarderBrand(motherboarder);
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/freeprocessor/{id}")
    public String freeProcessor(@PathVariable("id") int id) {
        processorService.freedomBrand(processorService.findChoice());
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/freedisc/{id}")
    public String freeDisc(@PathVariable("id") int id) {
        hardDiskService.freedomBrand(hardDiskService.findChoice());
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/freeoperating/{id}")
    public String freeOperatinfFee(@PathVariable("id") int id) {
        operatingFeeService.freedomBrand(operatingFeeService.findChoice());
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/freecooler/{id}")
    public String freeCooler(@PathVariable("id") int id) {
        coolerService.freedomBrand(coolerService.findChoice());
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/freemotherboarder/{id}")
    public String freeMotherboarder(@PathVariable("id") int id) {
        motherboerderService.freedomBrand(motherboerderService.findChoice());
        return "redirect:/brands/" + id;
    }

    @PatchMapping("/freebrandonindex")
    public String freeBookIndex() {
        try {
            processorService.freedomBrand(processorService.findChoice());
            hardDiskService.freedomBrand(hardDiskService.findChoice());
            operatingFeeService.freedomBrand(operatingFeeService.findChoice());
            coolerService.freedomBrand(coolerService.findChoice());
            motherboerderService.freedomBrand(motherboerderService.findChoice());
            return "redirect:/brands";
        } catch (NullPointerException ignored) {
        }

        return "redirect:/brands";
    }

}
