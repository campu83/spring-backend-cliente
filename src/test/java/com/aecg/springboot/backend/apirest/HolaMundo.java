package com.aecg.springboot.backend.apirest;

import java.util.ArrayList;
import java.util.List;

public class HolaMundo {


	public static void main(String[] args) {
		List<Double> resultado = new ArrayList<Double>();
		
		System.out.println(resultado.stream().mapToDouble(r-> r).sum());
	}
}
