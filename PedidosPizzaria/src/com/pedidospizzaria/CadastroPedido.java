package com.pedidospizzaria;



import com.pedidospizzaria.dao.PedidoDAO;
import com.pedidospizzaria.dao.PizzaDAO;
import com.pedidospizzaria.vo.BebidaVO;
import com.pedidospizzaria.vo.PedidoVO;
import com.pedidospizzaria.vo.PizzaVO;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPedido extends Activity{
	private EditText txtmesa;
	private EditText txtpizza;
	private EditText txtbebida;
	private int RETORNO_PIZZA = 1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_pedido);
        
        
        Button btnOk = (Button)findViewById(R.id.btCadPedidoEnviar);
        Button btnPizza = (Button)findViewById(R.id.btCadPedidoPizza);
        Button btnBebida = (Button)findViewById(R.id.btCadPedidoBebida);
        
        txtmesa = (EditText)findViewById(R.id.inputCadPedidoMesa);
        txtpizza = (EditText)findViewById(R.id.inputCadPedidoPizza);
        txtbebida = (EditText)findViewById(R.id.inputCadPedidoBebida);
        
        
        btnOk.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				PedidoVO vo = new PedidoVO();
				PizzaVO pizza = new PizzaVO();
				BebidaVO bebida = new BebidaVO();
				vo.setMesa(Integer.parseInt(txtmesa.getText().toString()));
				if(!txtbebida.getText().toString().equals("")){
					bebida.setId(Integer.parseInt(txtbebida.getText().toString()));
				}
				if(!txtpizza.getText().toString().equals("")){
					pizza.setId(Integer.parseInt(txtpizza.getText().toString()));
				}
				vo.setBebida(bebida);
				vo.setPizza(pizza);
				PedidoDAO dao = new PedidoDAO(getBaseContext());
				if(dao.salva(vo)){Toast.makeText(
						getBaseContext(), "sucesso!", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
        
		btnPizza.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Log.e("debug", "foi");
				startActivity(new Intent(getBaseContext(),	PedidoPizza.class));

			}
		});
    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (RETORNO_PIZZA == requestCode) {
			if (resultCode == RESULT_OK) {
				txtpizza.setText(data.getStringExtra("idPizzas"));
			}

		}

		// super.onActivityResult(requestCode, resultCode, data);

	}

	
}
