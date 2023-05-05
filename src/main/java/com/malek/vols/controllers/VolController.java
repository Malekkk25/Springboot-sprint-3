package com.malek.vols.controllers;

import java.text.ParseException;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;

import com.malek.vols.entities.Aeroport;
import com.malek.vols.entities.Vol;
import com.malek.vols.service.AeroportService;
import com.malek.vols.service.VolService;

import jakarta.validation.Valid;



@Controller
public class VolController {
@Autowired
VolService volService;

@Autowired
AeroportService aeroportService;



@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Aeroport> cats = volService.getAllAeroports();
Vol prod =new Vol();
modelMap.addAttribute("vol", new Vol());
Aeroport cat=new Aeroport();
cat = cats.get(0);
prod.setAeroport(cat);
modelMap.addAttribute("aeroport",prod);
modelMap.addAttribute("mode", "new");
modelMap.addAttribute("aeroports", cats);
modelMap.addAttribute("page",0);
return "formVol";
}
@RequestMapping("/saveVol")
public String saveProduit(@Valid Vol produit,
BindingResult bindingResult,
@ModelAttribute("page") int pageFromPrevious,
@RequestParam (name="size", defaultValue = "2") int size,
RedirectAttributes redirectAttributes)
{
int page;
if (bindingResult.hasErrors()) return "formVol";

if (produit.getIdVol()==null) //adding
    page = volService.getAllVols().size()/size; // calculer le nbr de pages
else //updating
    page = pageFromPrevious;

volService.saveVol(produit);

redirectAttributes.addAttribute("page", page);
return "redirect:/ListeVols";
}

@RequestMapping("/ListeVols")
public String listeVols(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Vol> vo = volService.getAllVolsParPage(page, size);
modelMap.addAttribute("vols", vo);
 modelMap.addAttribute("pages", new int[vo.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeVols";
}

@RequestMapping("/supprimerVol")
public String supprimerVol(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
{
volService.deleteVolById(id);
Page<Vol> vo = volService.getAllVolsParPage(page, size);
modelMap.addAttribute("vols", vo);
modelMap.addAttribute("pages", new int[vo.getTotalPages()]);
modelMap.addAttribute("pages", new int[vo.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeVols";
}

@RequestMapping("/modifierVol")
public String editerVol(@RequestParam("id") Long id,ModelMap modelMap,
		@RequestParam("page") int page,
        @RequestParam (name="size", defaultValue = "2") int size)
{
	Vol vol=volService.getVol(id);
	List<Aeroport>aeroports=aeroportService.getAllAeroports();
	modelMap.addAttribute("vol", vol);
    modelMap.addAttribute("aeroports", aeroports);
    modelMap.addAttribute("selectedAeroport", vol.getAeroport());
    modelMap.addAttribute("mode", "edit");
    modelMap.addAttribute("page",page);
return "formVol";
}

@RequestMapping("/updateVol")
public String updateVol(@ModelAttribute("vol") Vol vol,
@RequestParam("date") String date,
ModelMap modelMap,
@ModelAttribute("page") int page,
RedirectAttributes redirectAttributes
		
		) throws ParseException 
{
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateDepart = dateformat.parse(String.valueOf(date));
	 vol.setDateDepart(dateDepart);
	 volService.updateVol(vol);
 return "redirect:/ListeVols";
}

}
	

