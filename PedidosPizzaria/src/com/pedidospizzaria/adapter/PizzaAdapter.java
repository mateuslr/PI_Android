package com.pedidospizzaria.adapter;

import java.util.List;

import com.pedidospizzaria.R;
import com.pedidospizzaria.vo.PizzaVO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class PizzaAdapter extends BaseAdapter{

	private Context ctx;
	private List<PizzaVO> lista;
	
	public PizzaAdapter(Context ctx, List<PizzaVO> lista){
		
		this.ctx = ctx;
		this.lista = lista;
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	public Object getItem(int position) {
		
		return lista.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		PizzaVO vo = (PizzaVO) getItem(position);
		LayoutInflater layout = (LayoutInflater)
				ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View v = layout.inflate(R.layout.mostrar_pizza, null);
				
				TextView txtID = (TextView) v.findViewById(R.id.textoMostrarPizzaNome);
				txtID.setText(vo.getId().toString());
				
				TextView txtNome = (TextView) v.findViewById(R.id.textoMostrarPizzaDesc);
				txtNome.setText(vo.getId().toString());
		return v;
	}
	
}

