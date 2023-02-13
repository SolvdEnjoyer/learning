package mappers;


public interface IBaseMapper<T> {
    void deleteEntity(Long id);
    void insertEntity(T object);
    void updateEntity(T object);
}
