package com.malek.vols.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.malek.vols.entities.Aeroport;
import com.malek.vols.service.AeroportService;
import com.malek.vols.service.VolService;

import jakarta.validation.Valid;

@Controller
public class AeroportController {
	@Autowired
	AeroportService aeroportService;
	
	@RequestMapping("/Create")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("aeroport", new Aeroport());
	modelMap.addAttribute("mode", "new");
	return "formAeroport";
	}

	
	@RequestMapping("/saveAeroport")
	public String saveAeroport(@Valid Aeroport aeroport,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formAeroport";

	aeroportService.saveAeroport(aeroport);
	return "redirect:/ListAeroports";
	}
	
	
	@RequestMapping("/ListAeroports")
	public String listAeroports(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Aeroport> rays = aeroportService.getAllAeroportsParPage(page, size);
	modelMap.addAttribute("aeroports", rays);
	 modelMap.addAttribute("pages", new int[rays.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listAeroports";
	}
	
	
	
	
	@RequestMapping("/supprimerAeroport")
	public String supprimerAeroport(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	aeroportService.deleteAeroportByRef(id);
	Page<Aeroport> rays = aeroportService.getAllAeroportsParPage(page, 
	size);
	modelMap.addAttribute("aeroports", rays);
	modelMap.addAttribute("pages", new int[rays.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listAeroports";
	}
	
	
	@RequestMapping("/modifierAeroport")
	public String editerAeroport(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Aeroport p= aeroportService.getAeroport(id);
	modelMap.addAttribute("aeroport", p);
	modelMap.addAttribute("mode", "edit");
	return "formAeroport";
	}

	
}
