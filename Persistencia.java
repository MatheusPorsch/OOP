import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Persistencia {

	    private static final ObjectMapper mapper = new ObjectMapper();

	    // Monta o nome do arquivo de persistência a partir do nome da empresa
	    private static String nomeArquivo(String nomeEmpresa) {
	        return "empresa_" + nomeEmpresa.replaceAll("\\s+", "_") + ".json";
	    }

	    // SALVAR
	    public static void salvarEmpresa(Empresa empresa) {
	        try {
	            mapper.writeValue(new File(nomeArquivo(empresa.getNome())), empresa);
	            System.out.println("Dados salvos com sucesso!");
	        } catch (Exception e) {
	            System.out.println("Erro ao salvar: " + e.getMessage());
	        }
	    }

	    // CARREGAR
	    public static Empresa carregarEmpresa(String nomeEmpresa) {
	        try {
	            Empresa empresa = mapper.readValue(new File(nomeArquivo(nomeEmpresa)), Empresa.class);
	            System.out.println("Dados carregados com sucesso!");
	            return empresa;
	        } catch (Exception e) {
	            System.out.println("Erro ao carregar: " + e.getMessage());
	            return null;
	        }
	    }
	}