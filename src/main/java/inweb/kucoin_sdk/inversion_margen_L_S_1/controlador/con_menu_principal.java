/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.kucoin_sdk.inversion_margen_L_S_1.controlador;

import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_comunes.k_ok_txt;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_comunes.k_subtitulo_txt;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_listados.k_listados;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author emilio
 */
@Controller
public class con_menu_principal {
    public static String k_in_ruta = "in/inweb/kucoin_sdk/in";
    public static String k_mapa = "mapa";
    public static String k_menu_principal = "menu_principal";
    public static String k_listar_balances_de_cuentas = "listar_balances_de_cuentas";
    public static String k_listar_balances_de_cuenta_de_intercambio_a_vista = "listar_balances_de_cuenta_de_intercambio_a_vista";
    public static String k_listar_balances_de_cuenta_de_margen = "listar_balances_de_cuenta_de_margen";
    public static String k_listar_simbolos = "listar_simbolos";
    public static String k_listar_simbolos_con_BTC = "listar_simbolos_con_BTC";
    public static String k_listar_simbolos_con_USDT = "listar_simbolos_con_USDT";
    public static String k_listar_simbolos_con_USDC = "listar_simbolos_con_USDC";
    public static String k_listar_simbolos_con_BTC_en_Margen = "listar_simbolos_con_BTC_en_Margen";
    public static String k_listar_simbolos_con_USDT_en_Margen = "listar_simbolos_con_USDT_en_Margen";
    public static String k_listar_simbolos_con_USDC_en_Margen = "listar_simbolos_con_USDC_en_Margen";
           
    @GetMapping("/menu_principal")
    public String menu_principal(Model model) {
        oks ok = new oks();
        try {
            poner_atributos(model, ok);
        } catch (Exception e) {
            ok.setTxt(e); 
        }
        try {
            model.addAttribute(k_ok_txt, ok.getTxt());
        } catch (Exception e_ignorar) {
        }
        return k_menu_principal;
    }

    @PostMapping("/menu_principal")
    public String menu_principal_post(@RequestParam(name = "menu_principal_opcion", required = true) String menu_principal_opcion
            , Model model
            , HttpSession session) {
        oks ok = new oks();
        String retorno = k_menu_principal;
        try {
            if (menu_principal_opcion.equals(k_listar_balances_de_cuentas)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_balances_de_cuenta_de_intercambio_a_vista)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_balances_de_cuenta_de_margen)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_simbolos)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_simbolos_con_BTC)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_simbolos_con_USDT)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_simbolos_con_USDC)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_simbolos_con_BTC_en_Margen)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_simbolos_con_USDT_en_Margen)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            } else if (menu_principal_opcion.equals(k_listar_simbolos_con_USDC_en_Margen)) {
                retorno = "redirect:/" + k_listados + "/" + menu_principal_opcion;
            }
            if (ok.es == false) {
                model.addAttribute(k_ok_txt, ok.getTxt());
                return retorno;
            }
            poner_atributos(model, ok);
        } catch (Exception e) {
            ok.setTxt(e); 
        }
        try {
            model.addAttribute(k_ok_txt, ok.getTxt());
        } catch (Exception e_ignorar) {
        }
        return retorno;
    }

    public boolean poner_atributos(Model model, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            ResourceBundle in = null;            
            in = ResourceBundles.getBundle(inclui.kucoin_sdk.inversion_margen_L_S_1.inversion_margen_L_S_1s.k_in_ruta);
            Map <String, String> mapa = new LinkedHashMap<>();
            con_comunes.poner_atributos(model, ok);
            if (ok.es == false) { return false; }
            mapa.put(k_listar_balances_de_cuentas, tr.in(in, "Listar balances de cuentas. "));
            mapa.put(k_listar_balances_de_cuenta_de_intercambio_a_vista, tr.in(in, "Listar balances de cuenta de intercambio a vista. "));
            mapa.put(k_listar_balances_de_cuenta_de_margen, tr.in(in, "Listar balances de cuenta de margen. "));
            mapa.put(k_listar_simbolos, tr.in(in, "Listar simbolos. "));
            mapa.put(k_listar_simbolos_con_BTC, tr.in(in, "Listar simbolos con BTC. "));
            mapa.put(k_listar_simbolos_con_USDT, tr.in(in, "Listar simbolos con USDT. "));
            mapa.put(k_listar_simbolos_con_USDC, tr.in(in, "Listar simbolos con USDC. "));
            mapa.put(k_listar_simbolos_con_BTC_en_Margen, tr.in(in, "Listar simbolos con BTC en Margen. "));
            mapa.put(k_listar_simbolos_con_USDT_en_Margen, tr.in(in, "Listar simbolos con USDT en Margen. "));
            mapa.put(k_listar_simbolos_con_USDC_en_Margen, tr.in(in, "Listar simbolos con USDC en Margen. "));
            in = ResourceBundles.getBundle(con_menu_principal.k_in_ruta);
            model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Menu principal"));
            model.addAttribute(k_mapa, mapa);
            return ok.es;
        } catch (Exception e) {
            ok.setTxt(e); 
            return false;
        }
    }
    
}
