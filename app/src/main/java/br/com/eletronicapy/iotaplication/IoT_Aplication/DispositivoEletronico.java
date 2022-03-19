package br.com.eletronicapy.iotaplication.IoT_Aplication;

public class DispositivoEletronico {
    private boolean ligado;
    private int id;
    private String topicoMqtt;
    public boolean isLigado() {
        return ligado;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTopicoMqtt() {
        return topicoMqtt;
    }
    public void setTopicoMqtt(String topicoMqtt) {
        this.topicoMqtt = topicoMqtt;
    }

    public String ligarDispositivo(){
        this.ligado = true;
        return "1";
    }

    public String desligarDispositov() {
        this.ligado = false;
        return "0";
    }
}
