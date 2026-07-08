package main.java.com.imd.respository;

public interface RepositoryInterface <T> {
    void save(T entidade);
    void delete(T entidade);
    void buscarPorNome(String nome);  
}
