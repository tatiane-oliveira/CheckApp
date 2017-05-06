package com.example.iossenac.checkapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AlertDialog.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initValores(50.75, 328.67, 90.00, 49.99);
    }

    public void atualizaValorPago(View v) {
        CheckBox cbx = (CheckBox) v;
        TextView txtValorPago = (TextView) findViewById(R.id.txtPago);

        double valorPago = Float.parseFloat(txtValorPago.getText().toString());
        double valorConta = Float.parseFloat(cbx.getTag().toString());

        if (cbx.isChecked()) {
            txtValorPago.setText(String.valueOf(formataValor(valorPago + valorConta)));
        } else {
            txtValorPago.setText(String.valueOf(formataValor(valorPago - valorConta)));
        }
    }

    public void initValores(double agua, double luz, double celular, double telefone) {
        ((TextView) findViewById(R.id.txtPago)).setText("0.00");
        ((TextView) findViewById(R.id.txtTotal)).setText(String.valueOf(agua + luz + celular + telefone));
        ((CheckBox) findViewById(R.id.cbxAgua)).setTag(String.valueOf(agua));
        ((CheckBox) findViewById(R.id.cbxCelular)).setTag(String.valueOf(celular));
        ((CheckBox) findViewById(R.id.cbxLuz)).setTag(String.valueOf(luz));
        ((CheckBox) findViewById(R.id.cbxTelefone)).setTag(String.valueOf(telefone));
    }

    double formataValor(double valor) {
        return Double.valueOf(new DecimalFormat("####.##").format(valor));
    }

    private void confirmaPagamento() {
        AlertDialog.Builder msgConfirmacao = new AlertDialog.Builder(this);
        msgConfirmacao.setTitle("Pagamento");
        msgConfirmacao.setMessage("Confirma o pagamento da conta?");
        msgConfirmacao.setNeutralButton("Sim", null);
        msgConfirmacao.setNegativeButton("Não", null);
        msgConfirmacao.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == AlertDialog.BUTTON_NEUTRAL) {

        } else {

        }
    }
}
