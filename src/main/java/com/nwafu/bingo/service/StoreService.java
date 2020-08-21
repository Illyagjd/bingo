package com.nwafu.bingo.service;

import com.nwafu.bingo.dao.EvaluationDao;
import com.nwafu.bingo.dao.GameDao;
import com.nwafu.bingo.dao.OrderlistDao;
import com.nwafu.bingo.dao.SystemReqDao;
import com.nwafu.bingo.entity.Evaluation;
import com.nwafu.bingo.entity.Game;
import com.nwafu.bingo.entity.Orderlist;
import com.nwafu.bingo.entity.SystemReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Date: 2020/8/20
 * Description: 商店服务类，应包含EvaluationDao, GameDao, OrderlistDao, SystemReqDao，封装商店相关服务
 * Function: 获取所有游戏，订单(后续补充分页获取) (finished)
 * 根据游戏id或者用户id获取Evaluations (finished)
 * 根据id获取SystemReq (finished)
 * 根据用户id获取Orderlist (finished)
 * Game,Evaluation,SystemReq的添加修改删除 (Game finished, SystemReq finished, Evaluation finished)
 * Orderlist的添加删除 (finished)
 *
 * 其他后续补充
 */
@Service
public class StoreService {
    /**服务类引用**/
    @Resource
    private EvaluationDao evaluationDao;
    @Resource
    private GameDao gameDao;
    @Resource
    private OrderlistDao orderlistDao;
    @Resource
    private SystemReqDao systemReqDao;

    //函数声明
    //region 游戏相关
    /**
    * @MethodName getAllGame
    * @Description 获取数据库中全部游戏
    * @Param []
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 8:40 2020/8/21
    **/
    public List<Game> getAllGame() throws Exception {
        return gameDao.getAll();
    }
    /**
    * @MethodName addGame
    * @Description 向数据库中添加Game数据
    * @Param [game]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 8:41 2020/8/21
    **/
    public void addGame(Game game) throws Exception {
        gameDao.add(game);
    }
    /**
    * @MethodName updateGame
    * @Description 更新数据库中的Game数据
    * @Param [game]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 8:41 2020/8/21
    **/
    public void updateGame(Game game) throws Exception {
        gameDao.update(game);
    }
    /**
    * @MethodName deleteGame
    * @Description 删除数据库中相关的Game数据
    * @Param [game]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 8:45 2020/8/21
    **/
    public void deleteGame(Game game) throws Exception {
        gameDao.delete(game);
    }
    //endregion

    //region 订单相关
    /**
    * @MethodName getAllOrderList
    * @Description 获取所有订单
    * @Param []
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 8:54 2020/8/21
    **/
    public List<Orderlist> getAllOrderList() throws Exception {
        return orderlistDao.getAll();
    }
    /**
    * @MethodName getOrderListById
    * @Description 根据相应的id获取该id下的订单列表
    * @Param [idType, idValue] ------ 根据不同的id来查询comment, idType的值应为oid,uid
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:12 2020/8/21
    **/
    public List<Orderlist> getOrderListById(String idType, Integer idValue) throws Exception {
        return orderlistDao.getById(idType, idValue);
    }
    /**
    * @MethodName addOrderList
    * @Description 向数据库中添加新的订单
    * @Param [orderlist]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:16 2020/8/21
    **/
    public void addOrderList(Orderlist orderlist) throws Exception {
        orderlistDao.add(orderlist);
    }
    /**
    * @MethodName deleteOrderList
    * @Description 删除订单
    * @Param [orderlist]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:15 2020/8/21
    **/
    public void deleteOrderList(Orderlist orderlist) throws Exception {
        orderlistDao.delete(orderlist);
    }
    //endregion

    //region 系统配置相关
    /**
    * @MethodName getSystemReq
    * @Description 根据id获取系统配置
    * @Param [id]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:21 2020/8/21
    **/
    public SystemReq getSystemReq(Integer id) throws Exception {
        return systemReqDao.getById(id);
    }
    /**
    * @MethodName addSystemReq
    * @Description 添加系统配置(SystemReq)
    * @Param [systemReq]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:22 2020/8/21
    **/
    public void addSystemReq(SystemReq systemReq) throws Exception {
        systemReqDao.add(systemReq);
    }
    /**
    * @MethodName deleteSystemReqById
    * @Description 根据id删除指定的系统配置(SystemReq)
    * @Param [id]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:24 2020/8/21
    **/
    public void deleteSystemReqById(Integer id) throws Exception {
        systemReqDao.deleteById(id);
    }
    /**
    * @MethodName updateSystemReq
    * @Description 更新指定的系统配置(SystemReq)数据
    * @Param [systemReq]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:29 2020/8/21
    **/
    public void updateSystemReq(SystemReq systemReq) throws Exception {
        systemReqDao.updateById(systemReq);
    }
    //endregion

    //region 评论(Evaluation)相关
    /**
    * @MethodName getEvaluationById
    * @Description 根据相对应的id类型和id值获取指定的Evaluation列表
    * @Param [idType, idValue] ------ 根据不同的id来查询comment, idType的值应为eid,uid,gid
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:33 2020/8/21
    **/
    public List<Evaluation> getEvaluationById(String idType, Integer idValue) throws Exception {
        return evaluationDao.getById(idType, idValue);
    }
    /**
    * @MethodName addEvaluation
    * @Description 添加Evaluation记录数据
    * @Param [evaluation]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:35 2020/8/21
    **/
    public void addEvaluation(Evaluation evaluation) throws Exception {
        evaluationDao.add(evaluation);
    }
    /**
    * @MethodName deleteEvaluationById
    * @Description 根据相对应的id类型和id值删除指定的Evaluation数据
    * @Param [idType, idValue] ------ 根据不同的id来查询comment, idType的值应为eid,uid,gid
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:36 2020/8/21
    **/
    public void deleteEvaluationById(String idType, Integer idValue) throws Exception {
        evaluationDao.deleteById(idType, idValue);
    }
    /**
    * @MethodName updateEvaluation
    * @Description 更新指定的Evaluation
    * @Param [evaluation]
    * @return com.nwafu.bingo.service.StoreService
    * @author yolia
    * @Date 9:37 2020/8/21
    **/
    public void updateEvaluation(Evaluation evaluation) throws Exception {
        evaluationDao.update(evaluation);
    }
    //endregion
}
