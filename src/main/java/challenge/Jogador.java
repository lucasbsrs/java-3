package challenge;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class Jogador {

	@CsvBindByName(column = "nationality")
	private String nacionalidade;

	@CsvBindByName(column = "club")
	private String clube;

	@CsvBindByName(column = "full_name")
	private String nomeCompleto;

	@CsvBindByName(column = "eur_release_clause")
	private Double eurRelease;

	@CsvBindByName(column = "eur_wage")
	private Double eurWage;

	@CsvBindByName(column = "birth_date")
	@CsvDate("yyyy-MM-dd")
	private Date birthDate;

	@CsvBindByName(column = "age")
	private Integer age;

	public Jogador() {

	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getClube() {
		return clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Double getEurRelease() {
		return eurRelease;
	}

	public void setValorRecisao(Double valorRecisao) {
		this.eurRelease = valorRecisao;
	}

	public Double getEurWage() {
		return eurWage;
	}

	public void setEurWage(Double eurWage) {
		this.eurWage = eurWage;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
