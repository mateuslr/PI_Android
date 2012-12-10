package com.pedidospizzaria;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.dao.PizzaDAO;
import com.pedidospizzaria.vo.PizzaVO;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Pizzas extends ListActivity{
	ArrayList<String> pizzasListadasId;
	List<PizzaVO> listaPizzas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		PizzaDAO pdao = new PizzaDAO(getBaseContext());
		
		listaPizzas = pdao.getAll();
		List<String> pizzasListadas = new ArrayList<String>();
		pizzasListadasId = new ArrayList<String>();
		for (PizzaVO pizzaVO : listaPizzas) {
			Log.e("", pizzaVO.getNome());
			pizzasListadas.add(pizzaVO.getNome());
			pizzasListadasId.add(pizzaVO.getId().toString());
		}
		
		setListAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1,pizzasListadas));
		
	}
	
	@Override
	protected void onListItemClick( ListView l,  View v, int position, long id){
		
		
		 MainActivity.pizza = listaPizzas.get(0);
		setResult(RESULT_OK, new Intent().putStringArrayListExtra("lista", pizzasListadasId));
		startActivity(new Intent(getBaseContext(),	TesteLista.class));
		
		
		setResult(RESULT_OK,new Intent().putExtra("idPizzas", l.getAdapter().getItem(position).toString()));
		finish();
		
	}
}
