/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.kucoin_sdk.inversion_margen_L_S_1;

import inclui.kucoin_sdk.inversion_margen_L_S_1.inversion_margen_L_S_1s;
import static inclui.kucoin_sdk.inversion_margen_L_S_1.inversion_margen_L_S_1s.k_in_ruta;
import innui.kucoin_sdk.kucoin_sdks;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.Loggers;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author emilio
 */
public class web_inversion_margen_L_S_1s extends inversion_margen_L_S_1s {
    /**
     * Inicio de la aplicación desde un objeto instanciado
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    @Override
    public boolean run(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Map <String, Object> mapa;
            oks ok_local = new oks();
            ResourceBundle in = null;
            in = ResourceBundles.getBundle(k_in_ruta);
            iniciar(this.getClass(), ok);
            if (ok.es == false) { return false; }
            Map<String, Object> logger_mapa = new HashMap<>();
            logger_mapa.put(Loggers.k_handlers_no_ConsoleHandler, true);
            Loggers.reconfigurar(logger.getLogger(), logger_mapa, ok);
            logger.log(System.Logger.Level.INFO, "");
            kucoin_sdk = new kucoin_sdk_webs();
            kucoin_sdk.iniciar(ok);
            if (ok.es == false) { return false; }
            kucoin_sdk.modelo.clave = properties.getProperty(kucoin_sdks.modelos.k_clave);
            if (ok.no_nul(kucoin_sdk.modelo.clave) == false) {
                ok.txt = tr.in(in, "No se encuentra el dato clave. ");
                ok.es = true;
            }
            if (ok.es == false) { return false; }
            kucoin_sdk.modelo.secreto = properties.getProperty(kucoin_sdks.modelos.k_secreto);
            if (ok.no_nul(kucoin_sdk.modelo.secreto) == false) {
                ok.txt = tr.in(in, "No se encuentra el dato secreto. ");
                ok.es = true;
            }
            if (ok.es == false) { return false; }
            kucoin_sdk.modelo.contraseña = properties.getProperty(kucoin_sdks.modelos.k_contraseña);
            if (ok.no_nul(kucoin_sdk.modelo.contraseña) == false) {
                ok.txt = tr.in(in, "No se encuentra la contraseña. ");
                ok.es = true;
            }
            if (ok.es == false) { return false; }
            String texto = properties.getProperty(kucoin_sdks.modelos.k_es_modo_prueba);
            if (ok.no_nul(texto, tr.in(in, "No se encuentra la opción es_modo_prueba. ")) == false) {
                ok.es = true;
            } else {
                kucoin_sdk.modelo.es_modo_prueba = (texto.equals("0") == false);
            }
            if (ok.es == false) { return false; }
            if (extra_array.length > 0) {
                if (extra_array[0] instanceof Map) {
                    mapa = (Map<String, Object>) extra_array[0];
                    ok_local.iniciar();
                    kucoin_sdk.modelo.clave = (String) mapa.get(kucoin_sdks.modelos.k_clave);
                    ok_local.no_nul(kucoin_sdk.modelo.clave, tr.in(in, "No se encuentra el dato clave. "));
                    if (ok_local.es == false) { ok.setTxt(ok.getTxt(), ok_local.getTxt()); }
                    ok_local.iniciar();
                    kucoin_sdk.modelo.secreto = (String) mapa.get(kucoin_sdks.modelos.k_secreto);
                    ok_local.no_nul(kucoin_sdk.modelo.secreto, tr.in(in, "No se encuentra el dato secreto. "));
                    if (ok_local.es == false) { ok.setTxt(ok.getTxt(), ok_local.getTxt()); }
                    ok_local.iniciar();
                    kucoin_sdk.modelo.contraseña = (String) mapa.get(kucoin_sdks.modelos.k_contraseña);
                    ok_local.no_nul(kucoin_sdk.modelo.contraseña, tr.in(in, "No se encuentra la contraseña. "));
                    if (ok_local.es == false) { ok.setTxt(ok.getTxt(), ok_local.getTxt()); }
                    ok_local.iniciar();
                    if (mapa.get(kucoin_sdks.modelos.k_es_modo_prueba) != null) {
                        kucoin_sdk.modelo.es_modo_prueba = (boolean) mapa.get(kucoin_sdks.modelos.k_es_modo_prueba);
                    } else {
                        ok_local.setTxt(tr.in(in, "No se encuentra la opción es_modo_prueba. "));
                    }
                    if (ok_local.es == false) { ok.setTxt(ok.getTxt(), ok_local.getTxt()); }
                }
            }
            if (ok.es == false) { return false; }
            kucoin_sdk.crear_cliente(ok);
            if (ok.es == false) { return false; }
            ok.iniciar();
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
