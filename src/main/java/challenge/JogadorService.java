package challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;

public class JogadorService {

	private List<Jogador> listaJogadores;

	public JogadorService() {
		listaJogadores = new ArrayList<>();

		try {
			FileReader leitor = abrirArquivo();

			listaJogadores = new CsvToBeanBuilder(leitor).withType(Jogador.class).build().parse();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int q1() {
		Long qtdNacionalidades = listaJogadores.stream().map(Jogador::getNacionalidade).distinct().count();
		return qtdNacionalidades.intValue();
	}

	public int q2() {
		Long qtdClubes = listaJogadores.stream().filter(x -> !x.getClube().isEmpty()).map(Jogador::getClube).distinct()
				.count();
		return qtdClubes.intValue();
	}

	public List<String> q3() {
		List<String> primeirosVinteJogadores = listaJogadores.stream().limit(20).map(Jogador::getNomeCompleto)
				.collect(Collectors.toList());
		return primeirosVinteJogadores;
	}

	public List<String> q4() {
		List<String> topDezJogadoresMaioresSalarios = listaJogadores.stream().filter(j -> j.getEurRelease() != null)
				.sorted(Comparator.comparing(Jogador::getEurRelease).reversed()).map(Jogador::getNomeCompleto)
				.limit(10).collect(Collectors.toList());
		return topDezJogadoresMaioresSalarios;
	}

	public List<String> q5() {
		Comparator<Jogador> comparator = Comparator.comparing(Jogador::getBirthDate)
				.thenComparingDouble(Jogador::getEurWage);

		List<String> jogadoresMaisVelhos = listaJogadores.stream().sorted(comparator).limit(10)
				.map(Jogador::getNomeCompleto).collect(Collectors.toList());
		return jogadoresMaisVelhos;
	}
	
	public Map<Integer, Integer> q6() {
		Collector<Object, ?, Integer> contador = Collectors.reducing(0, e -> 1, Integer::sum);

        return listaJogadores.stream()
                .sorted(Comparator.comparingInt(Jogador::getAge))
                .collect(Collectors.groupingBy(Jogador::getAge, contador));
	}

	private FileReader abrirArquivo() throws FileNotFoundException {

		ClassLoader classLoader = getClass().getClassLoader();
		FileReader fileReader = new FileReader(classLoader.getResource("data.csv").getFile());

		return fileReader;
	}

}
