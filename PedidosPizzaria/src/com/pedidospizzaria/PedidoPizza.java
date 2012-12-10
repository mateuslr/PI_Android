package com.pedidospizzaria;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Spinner;
import android.widget.Toast;
import android.util.Log;
import android.view.View;

public class PedidoPizza extends Activity {
	
		private Spinner spnTamanho;
		private Spinner spnBorda;
		private Spinner spnSabor1;
		private Spinner spnSabor2;
		private Spinner spnSabor3;
		private List<String> tamanho = new ArrayList<String>();
		private List<String> borda = new ArrayList<String>();
		private List<String> pizzas = new ArrayList<String>();
		ArrayAdapter<String> arrayAdapterTamanho;
		ArrayAdapter<String> arrayAdapterBorda;
		ArrayAdapter<String> arrayAdapterSabor1;
		ArrayAdapter<String> arrayAdapterSabor2;
		ArrayAdapter<String> arrayAdapterSabor3;
		ArrayAdapter<String> spinnerArrayAdapterTamanho;
		ArrayAdapter<String> spinnerArrayAdapterBorda;
		ArrayAdapter<String> spinnerArrayAdapterSabor1;
		ArrayAdapter<String> spinnerArrayAdapterSabor2;
		ArrayAdapter<String> spinnerArrayAdapterSabor3;
		private String nome;
		private String nome1;
		private String nome2;
		private String nome3;
		private String nome4;
		static String nomePizza;
	 
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.pedido_pizza);
			Log.e("debug", "foi1");
			
			
			
			
			
			Log.e("debug", "foi2");
			//Identifica o Spinner no layout
			spnTamanho = (Spinner) findViewById(R.id.pedidoPizzaListTamanho);
			//Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
			arrayAdapterTamanho = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tamanho);
			spinnerArrayAdapterTamanho = arrayAdapterTamanho;
			spinnerArrayAdapterTamanho.setDropDownViewResource(android.R.layout.simple_spinner_item);
			
			
			
			spnTamanho.setAdapter(spinnerArrayAdapterTamanho);
			Log.e("debug", "foi3");
			//Método do Spinner para capturar o item selecionado
			
			
			
			spnTamanho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Log.e("debug", "foi4");
					//pega nome pela posição
					nome = arg0.getItemAtPosition(arg2).toString();
					
					String id = null;
					
					if(nome.equals("pequeno")){
						id = "1";
						spnSabor2 = (Spinner) findViewById(R.id.pedidoPizzaListSabor2);
						spnSabor3 = (Spinner) findViewById(R.id.pedidoPizzaListSabor3);
						spnSabor2.setEnabled(false);
						spnSabor3.setEnabled(false);
					}else if (nome.equals("médio")) {
						id = "2";
						spnSabor2 = (Spinner) findViewById(R.id.pedidoPizzaListSabor2);
						spnSabor3 = (Spinner) findViewById(R.id.pedidoPizzaListSabor3);
						spnSabor2.setEnabled(true);
						spnSabor3.setEnabled(false);
						
					}else if (nome.equals("grande")){
						id = "3";
						spnSabor2 = (Spinner) findViewById(R.id.pedidoPizzaListSabor2);
						spnSabor3 = (Spinner) findViewById(R.id.pedidoPizzaListSabor3);
						spnSabor2.setEnabled(true);
						spnSabor3.setEnabled(true);
					}
					//imprime um Toast na tela com o nome que foi selecionado
					Toast.makeText(PedidoPizza.this, "Tamanho Selecionado: " + id, Toast.LENGTH_LONG).show();
					
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					Log.e("debug", "nada");
					
				}
	 
				
				
			});
			spnBorda = (Spinner) findViewById(R.id.pedidoPizzaListBorda);
			//Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
			arrayAdapterBorda = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, borda);
			spinnerArrayAdapterBorda = arrayAdapterBorda;
			spinnerArrayAdapterBorda.setDropDownViewResource(android.R.layout.simple_spinner_item);
			spnBorda.setAdapter(spinnerArrayAdapterBorda);
			spnBorda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					nome1 = arg0.getItemAtPosition(arg2).toString();
					String id = null;
					Toast.makeText(PedidoPizza.this, "Borda Selecionado: " + id, Toast.LENGTH_LONG).show();
					
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					Log.e("debug", "nada2");
					borda.add("");
					borda.add("catupiry");
					borda.add("cheedar");
					borda.add("mista");
				}
 
			
				
			});
			
			spnSabor1 = (Spinner) findViewById(R.id.pedidoPizzaListSabor1);
			//Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
			arrayAdapterSabor1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pizzas);
			spinnerArrayAdapterSabor1 = arrayAdapterSabor1;
			spinnerArrayAdapterSabor1.setDropDownViewResource(android.R.layout.simple_spinner_item);
			spnSabor1.setAdapter(spinnerArrayAdapterSabor1);
			spnSabor1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					nome2 = arg0.getItemAtPosition(arg2).toString();
					String id = null;
					Toast.makeText(PedidoPizza.this, "Pizza Selecionada: " + nome2, Toast.LENGTH_LONG).show();
					nomePizza = nome2;
					
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					Log.e("debug", "nada2");
					pizzas.add("");
					pizzas.add("mussarela");
					pizzas.add("calabresa");
					pizzas.add("palmito");
					
				}
 
			
				
			});
			spnSabor2 = (Spinner) findViewById(R.id.pedidoPizzaListSabor2);
			//Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
			arrayAdapterSabor2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pizzas);
			spinnerArrayAdapterSabor2 = arrayAdapterSabor2;
			spinnerArrayAdapterSabor2.setDropDownViewResource(android.R.layout.simple_spinner_item);
			spnSabor2.setAdapter(spinnerArrayAdapterSabor2);
			spnSabor2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					nome3 = arg0.getItemAtPosition(arg2).toString();
					String id = null;
					Toast.makeText(PedidoPizza.this, "Pizza Selecionada: " + nome3, Toast.LENGTH_LONG).show();
					nomePizza = nome3;
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					Log.e("debug", "nada2");
					pizzas.add("");
					pizzas.add("mussarela");
					pizzas.add("calabresa");
					pizzas.add("palmito");
					
				}
 
			
				
			});
			
			spnSabor3 = (Spinner) findViewById(R.id.pedidoPizzaListSabor3);
			//Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
			arrayAdapterSabor3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pizzas);
			spinnerArrayAdapterSabor3 = arrayAdapterSabor3;
			spinnerArrayAdapterSabor3.setDropDownViewResource(android.R.layout.simple_spinner_item);
			spnSabor3.setAdapter(spinnerArrayAdapterSabor3);
			spnSabor3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					nome4 = arg0.getItemAtPosition(arg2).toString();
					String id = null;
					Toast.makeText(PedidoPizza.this, "Pizza Selecionada: " + nome4, Toast.LENGTH_LONG).show();
					nomePizza = nome4;
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					Log.e("debug", "nada2");
					pizzas.add("");
					pizzas.add("mussarela");
					pizzas.add("calabresa");
					pizzas.add("palmito");
					
				}
 
			
				
			});
			
	 
		}
	
	
}
