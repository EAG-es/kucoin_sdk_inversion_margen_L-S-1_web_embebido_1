/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.kucoin_sdk.inversion_margen_L_S_1.controlador;

import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import java.util.ResourceBundle;
import org.springframework.ui.Model;

/**
 *
 * @author emilio
 */
public class con_comunes {
    public static String k_in_ruta = "in/inweb/kucoin_sdk/in";
    public static String k_titulo_txt = "titulo_txt";
    public static String k_subtitulo_txt = "subtitulo_txt";
    public static String k_seleccionar = "seleccionar";
    public static String k_enviar_txt = "enviar_txt";
    public static String k_ok_txt = "ok_txt";

    public static boolean poner_atributos(Model model, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            ResourceBundle in = null;            
            in = ResourceBundles.getBundle(k_in_ruta);
            model.addAttribute(k_titulo_txt, tr.in(in, "Kucoin SDK. Inversión Margen L-S-1"));
            model.addAttribute(k_seleccionar, tr.in(in, "Seleccionar"));
            model.addAttribute(k_enviar_txt, tr.in(in, "Enviar"));
            return ok.es;
        } catch (Exception e) {
            ok.setTxt(e); 
            return false;
        }
    }
    
}
