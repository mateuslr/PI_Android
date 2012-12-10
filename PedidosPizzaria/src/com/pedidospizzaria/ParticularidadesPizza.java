package com.pedidospizzaria;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class ParticularidadesPizza extends Activity{
	
	private Spinner spnAcrescimos;
	private Spinner spnDecrescimos;
	private List<String> acrescimos = new ArrayList<String>();
	private List<String> decrescimos;
	ArrayAdapter<String> arrayAdapterAcrescimos;
	ArrayAdapter<String> arrayAdapterDecrescimos;
	ArrayAdapter<String> spinnerArrayAdapterAcrescimos;
	ArrayAdapter<String> spinnerArrayAdapterDecrescimos;
	private String nome;
	private String nome1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.particularidades_pizza);
		
		if(PedidoPizza.nomePizza.equals("mussarela")){
			decrescimos = new ArrayList<String>();
			decrescimos.add("queijo");
			decrescimos.add("tomate");
			decrescimos.add("azeitona");
		}else if(PedidoPizza.nomePizza.equals("calabresa")){
			decrescimos = new ArrayList<String>();
			decrescimos.add("queijo");
			decrescimos.add("tomate");
			decrescimos.add("azeitona");
			decrescimos.add("calabresa");
		}else if(PedidoPizza.nomePizza.equals("palmito")){
			decrescimos = new ArrayList<String>();
			decrescimos.add("queijo");
			decrescimos.add("palmito");
			decrescimos.add("azeitona");
			
		};
		acrescimos.add("Gorgonzola");
		acrescimos.add("Parmesão");
		acrescimos.add("Provolone");
		acrescimos.add("Catupiry");
		acrescimos.add("Lombo");
		acrescimos.add("Calabresa");
		acrescimos.add("Peperoni");
		acrescimos.add("Presunto");
		acrescimos.add("Cheedar");
		acrescimos.add("Camarão");
		
		spnAcrescimos = (Spinner) findViewById(R.id.particularidadesPizzaAcrescimos);
		//Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
		arrayAdapterAcrescimos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, acrescimos);
		spinnerArrayAdapterAcrescimos = arrayAdapterAcrescimos;
		spinnerArrayAdapterAcrescimos.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spnAcrescimos.setAdapter(spinnerArrayAdapterAcrescimos);
		Log.e("debug", "foi3");
		//Método do Spinner para capturar o item selecionado
		
		spnAcrescimos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Log.e("debug", "foi4");
				//pega nome pela posição
				nome = arg0.getItemAtPosition(arg2).toString();
				String id = null;
				decrescimos.add(nome);
				Integer cont = 0;
				
				do {
					
					if(acrescimos.get(cont).equals(nome)){
						acrescimos.remove(cont);
						break;
					}else{
						cont= cont + 1;
					}
					
				} while (cont < acrescimos.size());
				
					
					
				
				
				//imprime um Toast na tela com o nome que foi selecionado
				Toast.makeText(ParticularidadesPizza.this, "Acrescimo Selecionado: " + id, Toast.LENGTH_LONG).show();
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Log.e("debug", "nada");
			}
 
			
			
		});
		
		spnDecrescimos = (Spinner) findViewById(R.id.particularidadesPizzaDecrescimos);
		//Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
		arrayAdapterDecrescimos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, acrescimos);
		spinnerArrayAdapterDecrescimos = arrayAdapterDecrescimos;
		spinnerArrayAdapterDecrescimos.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spnAcrescimos.setAdapter(spinnerArrayAdapterDecrescimos);
		Log.e("debug", "foi3");
		//Método do Spinner para capturar o item selecionado
		
		spnDecrescimos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Log.e("debug", "foi4");
				//pega nome pela posição
				nome1 = arg0.getItemAtPosition(arg2).toString();
				String id = null;
				acrescimos.add(nome1);
				Integer cont = 0;
				
				do {
					
					if(decrescimos.get(cont).equals(nome1)){
						decrescimos.remove(cont);
						break;
					}else{
						cont= cont + 1;
					}
					
				} while (cont < decrescimos.size());
				
					
					
				
				
				//imprime um Toast na tela com o nome que foi selecionado
				Toast.makeText(ParticularidadesPizza.this, "Decrescimo Selecionado: " + id, Toast.LENGTH_LONG).show();
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Log.e("debug", "nada");
			}
 
			
			
		});
	};
};
