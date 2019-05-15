package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.LoginLog;
import com.sicnu.bulb.entity.table.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by HY
 * 2019/5/15 10:38
 */
public interface OperationLogRepository extends JpaRepository<OperationLog, Integer> {

    /**
     * 查询日志总数
     */
    @Query(value = "select count(1) from tb_operation_log", nativeQuery = true)
    int queryTotalNum();

    /**
     * 查询当前页面的log日志
     *
     * @param start      开始 从0开始
     * @param prePageNum 结束
     */
    @Query(value = "select * from tb_operation_log order by id limit :mStart,:num ", nativeQuery = true)
    List<OperationLog> getCurrentPageLogs(@Param("mStart") int start, @Param("num") int prePageNum);

}
