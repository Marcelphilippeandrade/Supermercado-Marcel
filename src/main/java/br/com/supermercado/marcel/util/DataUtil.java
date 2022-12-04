package br.com.supermercado.marcel.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

	public String FormataDataRetornaDataString(LocalDate data) {

		String dataFormatada = null;

		if (data != null) {
			dataFormatada = data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}

		return dataFormatada;
	}

	public LocalDate FormataDataRetornaDataLocalDate(String data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dataFormatada = LocalDate.parse(data, formato);
		return dataFormatada;
	}

	public LocalDate FormataDataRetornaDataLocalDate(LocalDate data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if (data != null) {
			String dataFormatada = data.format(formato);
			data = LocalDate.parse(dataFormatada, formato);
		}
		return data;
	}
}
