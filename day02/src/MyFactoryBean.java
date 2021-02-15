import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        return new Book(9,"王羲之","兰亭集序",100,100);
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
