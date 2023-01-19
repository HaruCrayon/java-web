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
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
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

    //添加新记录
    public int addFruit(String fname, int price, int fcount, String remark) {
        int update = fruitDAO.update("insert into fruit values(null,?,?,?,?)", fname, price, fcount, remark);

        return update;
    }

    //根据fid删除记录
    public int delFruitById(int fid) {
        int update = fruitDAO.update("delete from fruit where fid=?", fid);

        return update;
    }

    //根据fid查询记录
    public Fruit getFruitById(int fid) {
        Fruit fruit = fruitDAO.querySingle("select * from fruit where fid=?", Fruit.class, fid);

        return fruit;
    }

    //修改记录
    public int updateFruit(String fname, int price, int fcount, String remark, int fid) {
        int update =
                fruitDAO.update("update fruit set fname=?,price=?,fcount=?,remark=? where fid=?", fname, price, fcount, remark, fid);

        return update;
    }
}
