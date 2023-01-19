package com.fruit.service;

import com.fruit.dao.FruitDAO;
import com.fruit.domain.Fruit;
import com.myssm.basedao.ConnUtil;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class FruitService {
    private FruitDAO fruitDAO = null;

    //分页查询+根据关键字查询
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        System.out.println("getFruitList -> " + ConnUtil.getConn());
        List<Fruit> fruitList =
                fruitDAO.queryMulti("select * from fruit where fname like ? or remark like ? limit ?,5", Fruit.class,
                        "%" + keyword + "%", "%" + keyword + "%", (pageNo - 1) * 5);

        return fruitList;
    }

    //根据关键字查询总页数（每页展示5条记录）
    public int getPageCount(String keyword) {
        System.out.println("getPageCount -> " + ConnUtil.getConn());
        int fruitCount =
                ((Long) fruitDAO.queryScalar("select count(*) from fruit where fname like ? or remark like ?",
                        "%" + keyword + "%", "%" + keyword + "%")).intValue();
        int pageCount = (fruitCount + 4) / 5;

        return pageCount;
    }

    //添加新记录
    public int addFruit(String fname, Integer price, Integer fcount, String remark) {
        int update = fruitDAO.update("insert into fruit values(null,?,?,?,?)", fname, price, fcount, remark);
        //故意写错sql, 测试事务回滚
//        fruitDAO.update("updat fruit set fcount=? where fid=?", 10000, 19);

        return update;
    }

    //根据fid删除记录
    public int delFruitById(Integer fid) {
        int update = fruitDAO.update("delete from fruit where fid=?", fid);

        return update;
    }

    //根据fid查询记录
    public Fruit getFruitById(Integer fid) {
        Fruit fruit = fruitDAO.querySingle("select * from fruit where fid=?", Fruit.class, fid);

        return fruit;
    }

    //修改记录
    public int updateFruit(String fname, Integer price, Integer fcount, String remark, Integer fid) {
        int update =
                fruitDAO.update("update fruit set fname=?,price=?,fcount=?,remark=? where fid=?", fname, price, fcount, remark, fid);

        return update;
    }
}
