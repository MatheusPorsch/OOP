import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Persistencia {

	    private static final ObjectMapper mapper = new ObjectMapper();

	    // SALVAR
	    public static void salvarEmpresa(Empresa empresa) {
	        try {
	            mapper.writeValue(new File("empresa.json"), empresa);
	            System.out.println("Dados salvos com sucesso!");
	        } catch (Exception e) {
	            System.out.println("Erro ao salvar: " + e.getMessage());
	        }
	    }

	    // CARREGAR
	    public static Empresa carregarEmpresa() {
	        try {
	            Empresa empresa = mapper.readValue(new File("empresa.json"), Empresa.class);
	            System.out.println("Dados carregados com sucesso!");
	            return empresa;
	        } catch (Exception e) {
	            System.out.println("Erro ao carregar: " + e.getMessage());
	            return null;
	        }
	    }
	}


