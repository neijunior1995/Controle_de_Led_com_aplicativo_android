package br.com.eletronicapy.iotaplication;
import static org.apache.commons.lang3.StringUtils.isNumeric;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.eletronicapy.iotaplication.IoT_Aplication.LedRGB;
import br.com.eletronicapy.iotaplication.modelos.mqtt.ClienteMQTT;

public class MainActivity extends AppCompatActivity {
    EditText editVermelhor;
    EditText editVerde;
    EditText editAzul;
    Button enviar;
    String sred;
    String sgreen;
    String sblue;
    int red;
    int green;
    int blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editVermelhor = findViewById(R.id.activity_vermelho);
        editVerde = findViewById(R.id.activity_verde);
        editAzul = findViewById(R.id.activity_azul);
        enviar = findViewById(R.id.botao_enviar);


        ClienteMQTT clienteMQTT = new ClienteMQTT("tcp://mqtt.eclipseprojects.io:1883", null, null);
        clienteMQTT.iniciar();

        LedRGB led1 = new LedRGB();
        led1.setTopicoMqtt("labnei/ledControler");
        led1.ligarDispositivo();
        led1.configuraLed(0,0,0);
        clienteMQTT.publicar(led1.getTopicoMqtt(), led1.comandoLed().getBytes(), 0);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sred = editVermelhor.getText().toString();
                sgreen = editVerde.getText().toString();
                sblue = editAzul.getText().toString();
                if (isNumeric(sred.replace('.','1')) &&
                        isNumeric(sgreen.replace('.','1'))&&
                        isNumeric(sblue.replace('.',','))){
                    red = Integer.parseInt(sred);
                    blue = Integer.parseInt(sblue);
                    green = Integer.parseInt(sgreen);
                    led1.configuraLed(red,green,blue);
                    clienteMQTT.publicar(led1.getTopicoMqtt(), led1.comandoLed().getBytes(), 0);
                }
            }
        });


    }
}