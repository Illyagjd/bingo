package com.nwafu.bingo.service;

import com.nwafu.bingo.dao.EvaluationDao;
import com.nwafu.bingo.dao.GameDao;
import com.nwafu.bingo.dao.OrderlistDao;
import com.nwafu.bingo.dao.SystemReqDao;
import com.nwafu.bingo.entity.Evaluation;
import com.nwafu.bingo.entity.Game;
import com.nwafu.bingo.entity.Orderlist;
import com.nwafu.bingo.entity.SystemReq;
import com.nwafu.bingo.utils.Search;
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
    * @Description
    * @Param []
    * @return List<Game>
    * @author yolia
    * @Date 8:40 2020/8/21
    **/
    public List<Game> getAllGame() throws Exception {
        return gameDao.getAll();
    }
    /**
    * @MethodName getGameById
    * @Description 根据id获取商品信息
    * @Param [id]
    * @return com.nwafu.bingo.entity.Game
    * @author yolia
    * @Date 14:43 2020/8/22
    **/
    public Game getGameById(Integer id) throws Exception {
        return gameDao.getById(id);
    }
    /**
    * @MethodName getGameByNameExact
    * @Description 根据name精确查询相关数据
    * @Param [name]
    * @return com.nwafu.bingo.entity.Game
    * @author yolia
    * @Date 10:18 2020/8/22
    **/
    public Game getGameByNameExact(String name) throws Exception {
        return gameDao.getByNameExact(name);
    }
    /**
    * @MethodName getGameByName
    * @Description 模糊查询相关游戏
    * @Param [name]
    * @return java.util.List<com.nwafu.bingo.entity.Game>
    * @author yolia
    * @Date 16:40 2020/8/24
    **/
    public List<Game> getGameByName(String name) throws Exception {
        return gameDao.getByName(name);
    }
    /**
    * @MethodName getGameByType
    * @Description 根据类别模糊查询
    * @Param [types]
    * @return java.util.List<com.nwafu.bingo.entity.Game>
    * @author yolia
    * @Date 8:23 2020/8/25
    **/
    public List<Game> getGameByType(List<String> types) throws Exception {
        return gameDao.getByType(types);
    }
    /**
    * @MethodName searchCount
    * @Description 获取搜索总数
    * @Param [search]
    * @return java.lang.Integer
    * @author yolia
    * @Date 10:06 2020/8/26
    **/
    public Integer searchCount(Search search) throws Exception {
        return gameDao.searchCount(search);
    }
    /**
    * @MethodName search
    * @Description 按照相对应的要求进行搜索
    * @Param [search]
    * @return java.util.List<com.nwafu.bingo.entity.Game>
    * @author yolia
    * @Date 14:39 2020/8/25
    **/
    public List<Game> search(Search search) throws Exception {
        return gameDao.search(search);
    }
    /**
    * @MethodName addGame
    * @Description 向数据库中添加Game数据
    * @Param [game]
    * @return []
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
    * @return []
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
    * @return []
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
    * @return List<Orderlist>
    * @author yolia
    * @Date 8:54 2020/8/21
    **/
    public List<Orderlist> getAllOrderList() throws Exception {
        return orderlistDao.getAll();
    }
    /**
    * @MethodName getOrderListById
    * @Description 根据相应的id获取该id下的订单列表
    * @Param [idType, idValue] ------ 根据不同的id来查询, idType的值应为oid,uid
    * @return List<Orderlist>
    * @author yolia
    * @Date 9:12 2020/8/21
    **/
    public List<Orderlist> getOrderListById(String idType, Integer idValue) throws Exception {
        return orderlistDao.getById(idType, idValue);
    }
    /**
    * @MethodName getOrderListByCurTime
    * @Description 查询当前时间，以及当前时间前30天内的订单列表
    * @Param []
    * @return java.util.List<com.nwafu.bingo.entity.Orderlist>
    * @author yolia
    * @Date 14:12 2020/8/27
    **/
    public List<Orderlist> getOrderListByCurTime() throws Exception {
        return orderlistDao.getByCurTime();
    }
    /**
    * @MethodName addOrderList
    * @Description 向数据库中添加新的订单
    * @Param [orderlist]
    * @return []
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
    * @return []
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
    * @return com.nwafu.bingo.entity.SystemReq
    * @author yolia
    * @Date 9:21 2020/8/21
    **/
    public SystemReq getSystemReq(Integer id) throws Exception {
        return systemReqDao.getById(id);
    }
    /**
    * @MethodName getExact
    * @Description 精确查询系统配置
    * @Param [systemReq]
    * @return com.nwafu.bingo.entity.SystemReq
    * @author yolia
    * @Date 10:20 2020/8/22
    **/
    public SystemReq getExact(SystemReq systemReq) throws Exception {
        return systemReqDao.getExact(systemReq);
    }
    /**
    * @MethodName addSystemReq
    * @Description 添加系统配置(SystemReq)
    * @Param [systemReq]
    * @return []
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
    * @return []
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
    * @return []
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
    * @Param [idType, idValue] ------ 根据不同的id来查询, idType的值应为eid,uid,gid
    * @return List<Evaluation>
    * @author yolia
    * @Date 9:33 2020/8/21
    **/
    public List<Evaluation> getEvaluationById(String idType, Integer idValue) throws Exception {
        return evaluationDao.getById(idType, idValue);
    }
    /**
    * @MethodName getEvaluationByUidAndGid
    * @Description 根据uid和gid查找评测
    * @Param [uid, gid]
    * @return com.nwafu.bingo.entity.Evaluation
    * @author yolia
    * @Date 9:53 2020/8/26
    **/
    public Evaluation getEvaluationByUidAndGid(Integer uid, Integer gid) throws Exception {
        return evaluationDao.getByUidAndGid(uid, gid);
    }
    /**
    * @MethodName addEvaluation
    * @Description 添加Evaluation记录数据
    * @Param [evaluation]
    * @return []
    * @author yolia
    * @Date 9:35 2020/8/21
    **/
    public void addEvaluation(Evaluation evaluation) throws Exception {
        evaluationDao.add(evaluation);
    }
    /**
    * @MethodName deleteEvaluationById
    * @Description 根据相对应的id类型和id值删除指定的Evaluation数据
    * @Param [idType, idValue] ------ 根据不同的id来查询, idType的值应为eid,uid,gid
    * @return []
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
    * @return []
    * @author yolia
    * @Date 9:37 2020/8/21
    **/
    public void updateEvaluation(Evaluation evaluation) throws Exception {
        evaluationDao.update(evaluation);
    }
    //endregion
}
