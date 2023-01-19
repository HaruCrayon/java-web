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

    //分页查询+根据关键字查询
    public List<Fruit> listFruit(String keyword, Integer pageNo) {
        List<Fruit> fruitList =
                fruitDAO.queryMulti("select * from fruit where fname like ? or remark like ? limit ?,5", Fruit.class,
                        "%" + keyword + "%", "%" + keyword + "%", (pageNo - 1) * 5);

        return fruitList;
    }

    //根据关键字查询总记录数
    public int getFruitCount(String keyword) {
        int fruitCount =
                ((Long) fruitDAO.queryScalar("select count(*) from fruit where fname like ? or remark like ?",
                        "%" + keyword + "%", "%" + keyword + "%")).intValue();

        return fruitCount;
    }
}
