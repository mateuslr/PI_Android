package com.pedidospizzaria;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.pedidospizzaria.adapter.BebidaAdapter;
import com.pedidospizzaria.adapter.PizzaAdapter;
import com.pedidospizzaria.dao.BebidaDAO;
import com.pedidospizzaria.dao.PizzaDAO;
import com.pedidospizzaria.vo.BebidaVO;
import com.pedidospizzaria.vo.PizzaVO;

public class ListarBebidas extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	protected void onListItemClick( ListView l,  View v, int position, long id){
		BebidaVO vo = (BebidaVO) l.getAdapter().getItem(position);
//		Toast.makeText(getBaseContext(), vo.getId().toString(), Toast.LENGTH_SHORT).show();
		startActivity(new Intent("EdicaoCliente").putExtra("codigo", vo.getId()));
	
	}
	
	@Override
	public void onResume(){
		super.onResume();
		BebidaDAO dao = new BebidaDAO(getBaseContext());		
		
		 setListAdapter(new BebidaAdapter(getBaseContext(), dao.getAll()));
	}
}
