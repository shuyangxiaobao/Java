package cn.itcast.jd.service.impl;

import cn.itcast.jd.dao.Itemdao;
import cn.itcast.jd.domain.Item;
import cn.itcast.jd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Autowired
    private Itemdao itemdao;

    @Override
    @Transactional // 开启事务 提交事务
    public void saveItem(Item item) {
        itemdao.save ( item );
    }

    @Override
    public List<Item> findAll(Item item) {
        Example<Item> example = Example.of ( item );
        List<Item> list = this.itemdao.findAll ( example );
        return list;
    }




}
