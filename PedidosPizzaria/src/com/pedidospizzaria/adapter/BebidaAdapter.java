package com.pedidospizzaria.adapter;

import java.util.List;

import com.pedidospizzaria.R;
import com.pedidospizzaria.vo.BebidaVO;
import com.pedidospizzaria.vo.PizzaVO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BebidaAdapter extends BaseAdapter{
	private Context ctx;
	private List<BebidaVO> lista;
	
	public BebidaAdapter(Context ctx, List<BebidaVO> lista){
		
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
		BebidaVO vo = (BebidaVO) getItem(position);
		LayoutInflater layout = (LayoutInflater)
				ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View v = layout.inflate(R.layout.mostrar_bebidas, null);
				
				TextView txtID = (TextView) v.findViewById(R.id.textoMostrarBebidaNome);
				txtID.setText(vo.getId().toString());
				
				TextView txtNome = (TextView) v.findViewById(R.id.textoMostrarBebidaDesc);
				txtNome.setText(vo.getId().toString());
		return v;
	}
}
