package ma.emsi.recycle1.service;

import java.util.ArrayList;
import java.util.List;

import ma.emsi.recycle1.beans.Fruit;
import ma.emsi.recycle1.dao.IDao;


public class FruitService implements IDao<Fruit> {

    private List<Fruit> fruits;
    private static FruitService instance;

    private FruitService() {
        this.fruits = new ArrayList<>();
    }

    @Override
    public boolean create(Fruit o) {
        return fruits.add(o);
    }

    @Override
    public boolean update(Fruit o) {
        return false;
    }

    @Override
    public boolean delete(Fruit o) {
        return fruits.remove(o);
    }

    @Override
    public Fruit findById(int id) {
        for(Fruit f : fruits){
            if(f.getId() == id)
                return f;
        }
        return null;
    }

    @Override
    public List<Fruit> findAll() {
        return fruits;
    }

    public synchronized static FruitService getInstance() {
        if(instance == null)
            instance = new FruitService();
        return instance;
    }
}
