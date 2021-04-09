package cn.itcast.jd.dao;

import cn.itcast.jd.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Itemdao extends JpaRepository<Item,Long> {
}
