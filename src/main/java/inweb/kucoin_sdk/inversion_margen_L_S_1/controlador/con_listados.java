/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.kucoin_sdk.inversion_margen_L_S_1.controlador;

import static innui.kucoin_sdk.kucoin_sdks.k_margen;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_comunes.k_ok_txt;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_comunes.k_subtitulo_txt;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_kucoin_sdk_identificaciones.k_inversion_margen_L_S_1;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_balances_de_cuenta_de_intercambio_a_vista;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_balances_de_cuenta_de_margen;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_balances_de_cuentas;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_simbolos;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_simbolos_con_BTC;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_simbolos_con_BTC_en_Margen;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_simbolos_con_USDC;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_simbolos_con_USDC_en_Margen;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_simbolos_con_USDT;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_menu_principal.k_listar_simbolos_con_USDT_en_Margen;
import inweb.kucoin_sdk.inversion_margen_L_S_1.kucoin_sdk_webs;
import inweb.kucoin_sdk.inversion_margen_L_S_1.web_inversion_margen_L_S_1s;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author emilio
 */
@Controller
public class con_listados {
    public static String k_in_ruta = "in/inweb/kucoin_sdk/in";
    public static String k_listados = "listados";
    public static String k_mapas_mapa="mapas_mapa";
           
    @GetMapping("/listados/{id}")
    public String menu_principal(@PathVariable("id") String menu_principal_opcion
            , Model model
            , HttpSession session) {
        oks ok = new oks();
        String retorno = k_listados;
        try {
            ResourceBundle in = null;            
            in = ResourceBundles.getBundle(k_in_ruta);
            web_inversion_margen_L_S_1s inversion_margen_L_S_1 = null;
            kucoin_sdk_webs kucoin_sdk_web = null;
            while (true) {
                poner_atributos(model, ok);
                if (ok.es == false) { break; }
                inversion_margen_L_S_1 = (web_inversion_margen_L_S_1s) session.getAttribute(k_inversion_margen_L_S_1);
                ok.no_nul(inversion_margen_L_S_1, tr.in(in, "No hay objeto gestor para la realización de los listados. "));
                if (ok.es == false) { break; }
                if (inversion_margen_L_S_1.kucoin_sdk instanceof kucoin_sdk_webs == false) {
                    ok.setTxt(tr.in(in, "El objeto gestor no es de la clase requerida. "));
                }
                if (ok.es == false) { break; }
                kucoin_sdk_web = (kucoin_sdk_webs) inversion_margen_L_S_1.kucoin_sdk;
                if (menu_principal_opcion.equals(k_listar_balances_de_cuentas)) {
                    kucoin_sdk_web.listar_balances_de_cuentas(ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar balances de cuentas"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_balances_de_cuenta_de_intercambio_a_vista)) {
                    kucoin_sdk_web.listar_balances_de_cuenta_intercambio(ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar balances de cuenta de intercambio a vista"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_balances_de_cuenta_de_margen)) {
                    kucoin_sdk_web.listar_balances_de_cuenta_margen(ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar balances de cuenta de margen"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_simbolos)) {
                    kucoin_sdk_web.listar_simbolos(ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar símbolos"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_simbolos_con_BTC)) {
                    kucoin_sdk_web.listar_simbolos("BTC", null, ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar símbolos con BTC"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_simbolos_con_USDT)) {
                    kucoin_sdk_web.listar_simbolos("USDT", null, ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar símbolos con USDT"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_simbolos_con_USDC)) {
                    kucoin_sdk_web.listar_simbolos("USDC", null, ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar símbolos con USDC"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_simbolos_con_BTC_en_Margen)) {
                    kucoin_sdk_web.listar_simbolos("BTC", k_margen, ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar símbolos en Margen con BTC"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_simbolos_con_USDT_en_Margen)) {
                    kucoin_sdk_web.listar_simbolos("USDT", k_margen, ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar símbolos en Margen con USDT"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                } else if (menu_principal_opcion.equals(k_listar_simbolos_con_USDC_en_Margen)) {
                    kucoin_sdk_web.listar_simbolos("USDC", k_margen, ok);
                    if (ok.es == false) { break; }
                    model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listar símbolos en Margen con USDC"));
                    model.addAttribute(k_mapas_mapa, kucoin_sdk_web.mapas_mapa);
                }
                break;
            }
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
            in = ResourceBundles.getBundle(con_listados.k_in_ruta);
            Map <String, String> mapa = new LinkedHashMap<>();
            con_comunes.poner_atributos(model, ok);
            if (ok.es == false) { return false; }
            model.addAttribute(k_subtitulo_txt, tr.in(in, "Kucoin SDK. Listado"));
            return ok.es;
        } catch (Exception e) {
            ok.setTxt(e); 
            return false;
        }
    }
    
}
