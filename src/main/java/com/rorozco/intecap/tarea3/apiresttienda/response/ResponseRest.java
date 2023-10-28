package com.rorozco.intecap.tarea3.apiresttienda.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResponseRest<T> {

    /**
     * la metadata de respuesta
     */
    private ArrayList<HashMap<String, String>> metadata = new ArrayList<HashMap<String, String>>();

    /**
     * la data de respuesta
     */
    private List<T> data;

    /**
     * definir el estado, codigo y mensaje de respuesta a la API
     * @return ArrayList<HashMap<String, String>>
     */
    public ArrayList<HashMap<String, String>> getMetadata() {
        return metadata;
    }

    /**
     * establece la información de respuesta
     */
    public void setMetadata(String tipo, String codigo, String mensaje) {
        HashMap<String, String> meta = new HashMap<String, String>();
        meta.put("tipo", tipo);
        meta.put("codigo", codigo);
        meta.put("mensaje", mensaje);
        this.metadata.add(meta);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
