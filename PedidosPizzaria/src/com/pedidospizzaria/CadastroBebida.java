package com.pedidospizzaria;

import com.pedidospizzaria.dao.BebidaDAO;
import com.pedidospizzaria.vo.BebidaVO;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroBebida extends Activity{
	private EditText txtNome;
	private EditText txtDesc;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_bebida);
        
        Button btnOk = (Button)findViewById(R.id.btCadBebida);
        
        txtNome = (EditText)findViewById(R.id.inputNomeBebida);
        txtDesc = (EditText)findViewById(R.id.inputDescBebida);
        
        
        btnOk.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				BebidaVO vo = new BebidaVO();
				vo.setNome(txtNome.getText().toString());
				vo.setDesc(txtDesc.getText().toString());
				
				
				BebidaDAO dao = new BebidaDAO(getBaseContext());
				if(dao.insert(vo)){Toast.makeText(
						getBaseContext(), "sucesso!", Toast.LENGTH_SHORT).show();
				finish();
				}
				
			}
		});
    }
}
