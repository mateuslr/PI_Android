package com.pedidospizzaria;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pedidospizzaria.dao.BebidaDAO;
import com.pedidospizzaria.dao.PizzaDAO;
import com.pedidospizzaria.vo.BebidaVO;
import com.pedidospizzaria.vo.PizzaVO;

public class Bebidas extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		BebidaDAO bdao = new BebidaDAO();
		List<BebidaVO> listaBebidas;
		listaBebidas = bdao.getAll();
		
		
		setListAdapter(new ArrayAdapter<BebidaVO>(getBaseContext(), android.R.layout.simple_list_item_1,listaBebidas));
		
	}
	
	@Override
	protected void onListItemClick( ListView l,  View v, int position, long id){
		setResult(RESULT_OK,new Intent().putExtra("bebidas", l.getAdapter().getItem(position).toString()));
		finish();
		
	}
}

