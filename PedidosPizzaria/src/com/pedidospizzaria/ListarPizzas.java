package com.pedidospizzaria;

import com.pedidospizzaria.adapter.PizzaAdapter;
import com.pedidospizzaria.dao.PizzaDAO;
import com.pedidospizzaria.vo.PizzaVO;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class ListarPizzas extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	protected void onListItemClick( ListView l,  View v, int position, long id){
		PizzaVO vo = (PizzaVO) l.getAdapter().getItem(position);
//		Toast.makeText(getBaseContext(), vo.getId().toString(), Toast.LENGTH_SHORT).show();
		startActivity(new Intent("EdicaoCliente").putExtra("codigo", vo.getId()));
	
	}
	
	@Override
	public void onResume(){
		super.onResume();
		PizzaDAO dao = new PizzaDAO(getBaseContext());		
		
		 setListAdapter(new PizzaAdapter(getBaseContext(), dao.getAll()));
	}
}
