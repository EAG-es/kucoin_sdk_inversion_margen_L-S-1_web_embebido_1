/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.kucoin_sdk.inversion_margen_L_S_1;

import com.kucoin.sdk.rest.response.AccountBalancesResponse;
import com.kucoin.sdk.rest.response.MarketItemResponse;
import com.kucoin.sdk.rest.response.SymbolResponse;
import innui.kucoin_sdk.kucoin_sdks;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import org.springframework.ui.Model;

/**
 *
 * @author emilio
 */
public class kucoin_sdk_webs extends kucoin_sdks {
    public static String k_in_ruta = "in/inweb/kucoin_sdk/in";
    public static String k_cabecera = "cabecera";
    public static String k_listar_balances_de_cuentas="listar_balances_de_cuentas";
    public Map <String, Map<String, String>> mapas_mapa = new LinkedHashMap<>();
    
    @Override
    public boolean listar_balances_de_cuentas_escribir(List<AccountBalancesResponse> accountBalancesResponses_list, oks ok, Object... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Map<String, String> lineas_mapa = null;
            int fila_num = 0;
            int columna_num = 0;
            ResourceBundle in = null;            
            in = ResourceBundles.getBundle(k_in_ruta);
            mapas_mapa.clear();
            if (ok.es == false) { return false; }
            lineas_mapa = new LinkedHashMap<>();
            lineas_mapa.put(String.valueOf(columna_num), "Tipo");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Moneda");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Balance");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Disponible");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Retenido");
            mapas_mapa.put(k_cabecera,lineas_mapa);
            for (AccountBalancesResponse accountBalancesResponse : accountBalancesResponses_list) {
                columna_num = 0;
                lineas_mapa = new LinkedHashMap<>();
                lineas_mapa.put(String.valueOf(columna_num), accountBalancesResponse.getType());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), accountBalancesResponse.getCurrency());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), accountBalancesResponse.getBalance().toPlainString());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), accountBalancesResponse.getAvailable().toPlainString());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), accountBalancesResponse.getHolds().toPlainString());
                mapas_mapa.put(String.valueOf(fila_num),lineas_mapa);
                fila_num = fila_num + 1;
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean listar_simbolos_escribir(List<SymbolResponse> symbolResponse_list, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Map<String, String> lineas_mapa = null;
            int fila_num = 0;
            int columna_num = 0;
            ResourceBundle in = null;            
            in = ResourceBundles.getBundle(k_in_ruta);
            mapas_mapa.clear();
            if (ok.es == false) { return false; }
            lineas_mapa = new LinkedHashMap<>();
            lineas_mapa.put(String.valueOf(columna_num), "Símbolo");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Nombre");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Mercado");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Moneda base");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Moneda contra");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Moneda pago");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "A vista");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Margen");
            mapas_mapa.put(k_cabecera,lineas_mapa);
            for (SymbolResponse symbolResponse : symbolResponse_list) {
                columna_num = 0;
                lineas_mapa = new LinkedHashMap<>();
                lineas_mapa.put(String.valueOf(columna_num), symbolResponse.getSymbol());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), symbolResponse.getName());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), symbolResponse.getMarket());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), symbolResponse.getBaseCurrency());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), symbolResponse.getQuoteCurrency());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), symbolResponse.getFeeCurrency());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), symbolResponse.getEnableTrading()?"Sí":"No");
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), symbolResponse.getIsMarginEnabled()?"Sí":"No");
                mapas_mapa.put(String.valueOf(fila_num),lineas_mapa);
                fila_num = fila_num + 1;
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Escribir los datos del mercado de prestamos a 7 dias para un simbolo
     * @param marketItemResponse_list Listado que escribir
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    @Override
    public boolean consultar_mercado_de_prestamos_7_dias_escribir(String simbolo, List<MarketItemResponse> marketItemResponse_list, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Map<String, String> lineas_mapa = null;
            int fila_num = 0;
            int columna_num = 0;
            ResourceBundle in = null;            
            in = ResourceBundles.getBundle(k_in_ruta);
            mapas_mapa.clear();
            if (ok.es == false) { return false; }
            lineas_mapa = new LinkedHashMap<>();
            lineas_mapa.put(String.valueOf(columna_num), "Interés diario");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Cant.prestable");
            columna_num = columna_num + 1;
            lineas_mapa.put(String.valueOf(columna_num), "Duración");
            mapas_mapa.put(k_cabecera,lineas_mapa);
            for (MarketItemResponse marketItemResponse : marketItemResponse_list) {
                columna_num = 0;
                lineas_mapa = new LinkedHashMap<>();
                lineas_mapa.put(String.valueOf(columna_num), marketItemResponse.getDailyIntRate().toPlainString());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), marketItemResponse.getSize().toPlainString());
                columna_num = columna_num + 1;
                lineas_mapa.put(String.valueOf(columna_num), String.valueOf(marketItemResponse.getTerm()));
                mapas_mapa.put(String.valueOf(fila_num),lineas_mapa);
                fila_num = fila_num + 1;
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
