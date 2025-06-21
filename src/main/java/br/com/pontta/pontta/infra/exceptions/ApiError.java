package br.com.pontta.pontta.infra.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ApiError {
    private int status;
    private String erro;
    private List<CampoInvalido> camposInvalidos = new ArrayList<>();

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getErro() {
        return erro;
    }
    public void setErro(String erro) {
        this.erro = erro;
    }
    public List<CampoInvalido> getCamposInvalidos() {
        return camposInvalidos;
    }
    public void setCamposInvalidos(List<CampoInvalido> camposInvalidos) {
        this.camposInvalidos = camposInvalidos;
    }

}
