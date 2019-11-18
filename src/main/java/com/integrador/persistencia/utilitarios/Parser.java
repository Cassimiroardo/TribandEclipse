package com.integrador.persistencia.utilitarios;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.integrador.model.annotations.ChaveEstrangeira;
import com.integrador.model.annotations.ChavePrimaria;
import com.integrador.model.annotations.Tabela;
import com.integrador.model.utilitarios.EntidadeBase;


public class Parser<T extends EntidadeBase> {
	T auxiliar;
	public Parser(T obj) {
		auxiliar = obj;
	}

	public boolean ehChaveEstrangeira(Field atributo) {
		return atributo.isAnnotationPresent(ChaveEstrangeira.class);
	}
	public boolean ehChavePrimaria(Field atributo) {
		return atributo.isAnnotationPresent(ChavePrimaria.class);
	}
	


	public Object geraObjeto(Field w, Object q) {
	
		try {
			Object ans = w.get(q);
			if (ans == null) {
				return ans;
			}

			if (ehChaveEstrangeira(w)) {
				ans = ((EntidadeBase) ans).getId();

			}

			return ans;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public String geraInnerJoin(Class<T> aux) throws IllegalArgumentException, IllegalAccessException {
		String ans = "";
		Field atributos[] = aux.getDeclaredFields();
		String nomeTabelaAux = aux.getAnnotation(Tabela.class).nome();
		for(Field w: atributos) {
			w.setAccessible(true);
			
			if(ehChaveEstrangeira(w)) {
				String nome = w.getType().getAnnotation(Tabela.class).nome(); // Pega o valor nome da anotação Tabela da classe W; 
				
				ans +=  " INNER JOIN "+nome+" ON "+nome+".id_"+nome+"="+nomeTabelaAux+".id_"+nome; 
				
			}
		}
		
		return ans;
	}

	
	
	public Field geraAtributo(String nome) {
		try {
			Field ans = auxiliar.getClass().getDeclaredField(nome);
			ans.setAccessible(true);
			return ans;
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public<S> S geraObjetodeClasse(Class<S> classe){
		try {
			return classe.getConstructor().newInstance();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
