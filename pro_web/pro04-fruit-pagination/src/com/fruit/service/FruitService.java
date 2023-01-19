package com.fruit.service;

import com.fruit.dao.FruitDAO;
import com.fruit.domain.Fruit;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class FruitService {
    private FruitDAO fruitDAO = new FruitDAO();

    //分页查询
    public List<Fruit> listFruit(Integer pageNo) {
        List<Fruit> fruitList = fruitDAO.queryMulti("select * from fruit limit ?,5", Fruit.class, (pageNo - 1) * 5);

        return fruitList;
    }

    //查询总记录数
    public int getFruitCount() {
        int fruitCount = ((Long) fruitDAO.queryScalar("select count(*) from fruit")).intValue();

        return fruitCount;
    }
}
