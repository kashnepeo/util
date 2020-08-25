package com.diquest.ta.util.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository("UtilDao")
public class UtilDao {

    protected static final String NAMESPACE = "com.diquest.ta.util.mapper.UtilDao.";

    @Autowired
    private SqlSession sqlSession;

    public List<Map<String, Object>> getDailyCallList(Map<String, Object> param) {
        return (List) sqlSession.selectList(NAMESPACE + "getDailyCallList", param);
    }
}
