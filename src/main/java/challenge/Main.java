package challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	private List<Jogador> listaJogadores;

	public Main() {
		listaJogadores = new ArrayList<>();

		String csvFile = "./src/main/resources/data.csv";

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] jogadores = line.split(cvsSplitBy);
				if (isNumeric(jogadores[0])) {
					Jogador jogador = new Jogador();
					jogador.setNacionalidade(jogadores[14]);
					jogador.setClube(jogadores[3]);
					jogador.setNomeCompleto(jogadores[2]);
					Double valorRecisao = Double.parseDouble(jogadores[18]);
					jogador.setValorRecisao(valorRecisao);
					listaJogadores.add(jogador);
				}
			}
			//listaJogadores.remove(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		Long qtdNacionalidades = listaJogadores.stream().map(Jogador::getNacionalidade).distinct().count();
		return qtdNacionalidades.intValue();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		Long qtdClubes = listaJogadores.stream().filter(x -> !x.getClube().isEmpty()).map(Jogador::getClube).distinct()
				.count();
		return qtdClubes.intValue();
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<String> primeirosVinteJogadores = listaJogadores.stream().limit(20).map(Jogador::getNomeCompleto)
				.collect(Collectors.toList());
		return primeirosVinteJogadores;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		List<String> topDezJogadoresMaioresSalarios = listaJogadores.stream()
				.sorted(Comparator.comparing(Jogador::getValorRecisao).reversed()).map(Jogador::getNomeCompleto)
				.limit(10).collect(Collectors.toList());
		return topDezJogadoresMaioresSalarios;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o
	// campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return null;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde
	// as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return null;
	}

	private boolean isNumeric(String param) {
		try {
			Integer.parseInt(param);
			return true;
		} catch (NumberFormatException  e) {
		      return false;
		}
	}
}
