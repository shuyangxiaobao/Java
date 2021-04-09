package cn.itcast.jd.service;

import cn.itcast.jd.domain.Item;

import java.util.List;

public interface ItemService {

    /**
     * 保存
     * @param item
     */
    public void saveItem(Item item);


    /**
     * 根据条件查找商品
     * @param item
     * @return
     */
    public List<Item> findAll(Item item);

}

