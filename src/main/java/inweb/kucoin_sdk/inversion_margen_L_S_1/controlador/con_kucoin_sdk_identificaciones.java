package inweb.kucoin_sdk.inversion_margen_L_S_1.controlador;

import static innui.kucoin_sdk.kucoin_sdks.modelos.k_clave;
import static innui.kucoin_sdk.kucoin_sdks.modelos.k_contraseña;
import static innui.kucoin_sdk.kucoin_sdks.modelos.k_es_modo_prueba;
import static innui.kucoin_sdk.kucoin_sdks.modelos.k_secreto;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import static inweb.kucoin_sdk.inversion_margen_L_S_1.controlador.con_comunes.k_ok_txt;
import inweb.kucoin_sdk.inversion_margen_L_S_1.web_inversion_margen_L_S_1s;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class con_kucoin_sdk_identificaciones {
    public static String k_in_ruta = "in/inweb/kucoin_sdk/in";
    public static String k_inversion_margen_L_S_1 = "inversion_margen_L_S_1";
    public static String k_clave_txt = "clave_txt";
    public static String k_secreto_txt = "secreto_txt";
    public static String k_contrasenha_txt = "contrasenha_txt";
    public static String k_es_modo_prueba_txt = "es_modo_prueba_txt";
    public static String k_kucoin_sdk_identificaciones="kucoin_sdk_identificaciones";
    
    @GetMapping("/kucoin_sdk_identificaciones")
    public String kucoin_sdk_identificaciones(@RequestParam(name = "clave", required = false) String clave
            , @RequestParam(name = "secreto", required = false) String secreto
            , @RequestParam(name = "contrasenha", required = false) String contraseña
            , @RequestParam(name = "es_modo_prueba", required = false) boolean es_modo_prueba
            , Model model
            , HttpSession session) {
        oks ok = new oks();
        try {
            if (clave == null) {
                poner_atributos(model, ok);
            } else {
                return kucoin_sdk_identificaciones_post(clave, secreto, contraseña, es_modo_prueba, model, session);
            }
        } catch (Exception e) {
            ok.setTxt(e); 
        }
        try {
            model.addAttribute(k_ok_txt, ok.getTxt());
        } catch (Exception e_ignorar) {
        }
        return k_kucoin_sdk_identificaciones;
    }

    @PostMapping("/kucoin_sdk_identificaciones")
    public String kucoin_sdk_identificaciones_post(@RequestParam(name = "clave", required = true) String clave
            , @RequestParam(name = "secreto", required = true) String secreto
            , @RequestParam(name = "contrasenha", required = true) String contraseña
            , @RequestParam(name = "es_modo_prueba", required = false) boolean es_modo_prueba
            , Model model
            , HttpSession session) {
        oks ok = new oks();
        String retorno = k_kucoin_sdk_identificaciones;
        try {
            web_inversion_margen_L_S_1s inversion_margen_L_S_1 = new web_inversion_margen_L_S_1s();
            Map <String, Object> mapa = new HashMap();
            session.setAttribute(k_inversion_margen_L_S_1, inversion_margen_L_S_1);
            mapa.put(k_clave, clave);
            mapa.put(k_secreto, secreto);
            mapa.put(k_contraseña, contraseña);
            mapa.put(k_es_modo_prueba, es_modo_prueba);
            inversion_margen_L_S_1.run(ok, mapa);
            if (ok.es == false) {
                model.addAttribute(k_ok_txt, ok.getTxt());
                return retorno;
            }
            poner_atributos(model, ok);
            if (ok.es) {
                retorno ="redirect:/menu_principal";
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
            in = ResourceBundles.getBundle(k_in_ruta);
            con_comunes.poner_atributos(model, ok);
            if (ok.es == false) { return false; }
            model.addAttribute(k_clave_txt, tr.in(in, "Clave"));
            model.addAttribute(k_secreto_txt, tr.in(in, "Secreto"));
            model.addAttribute(k_contrasenha_txt, tr.in(in, "Contraseña"));
            model.addAttribute(k_es_modo_prueba_txt, tr.in(in, "Es modo prueba"));
            return ok.es;
        } catch (Exception e) {
            ok.setTxt(e); 
            return false;
        }
    }
}
