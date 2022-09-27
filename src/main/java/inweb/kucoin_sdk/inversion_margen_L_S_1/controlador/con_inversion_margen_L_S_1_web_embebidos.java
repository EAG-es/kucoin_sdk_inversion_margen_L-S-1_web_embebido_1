/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.kucoin_sdk.inversion_margen_L_S_1.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class con_inversion_margen_L_S_1_web_embebidos {

	@GetMapping("/")
	public String inicio(Model model) {
		return "redirect:/kucoin_sdk_identificaciones";
	}
        
}
