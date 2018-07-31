package br.com.adrianob;

/**
 *
 * @author drink Lembre-se de que na implementação você precisa manter um atributo connection que deve ser passado como injeçao de dependencia no construtor.
 */
public interface CrudInterface {
 
    /**
     * você deve implementar este método e fazer uma consulta para listar os dados
     */
    public void retriveAll();
    /**
     * Aqui você deve implementar e fazer inserir, ao menos 5 registros no banco
     */
    public void insert();
    /**
     * Aqui você deve atualizar um dos registros, ou todos
     */
    public void update();
    /**
     * Aqui você deve apagar um registro
     */
    public void delete();
    
    
}
