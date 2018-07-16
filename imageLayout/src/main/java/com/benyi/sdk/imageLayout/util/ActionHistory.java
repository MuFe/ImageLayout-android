package com.benyi.sdk.imageLayout.util;

import com.benyi.sdk.imageLayout.model.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MuFe on 2018/5/31.
 * 响应操作记录
 * @author MuFe
 */
public class ActionHistory<T> {
    private final List<Action> list=new ArrayList<>();
    public void addNextAction(String time){
        Action action=Action.leftAction(time);
        list.add(action);
    }

    public void addPrevAction(String time){
        Action action=Action.rightAction(time);
        list.add(action);
    }

    public void addTopAction(String time, T data){
        Action action=Action.topAction(time);
        action.data=data;
        list.add(action);
    }

    public void addBottomAction(String time, String name,T data){
        Action action=Action.bottomAction(time,name);
        action.data=data;
        list.add(action);
    }

    public Action getLast(){
        if(list.isEmpty()){
            return null;
        }
        Action action=list.get(list.size()-1);
        list.remove(action);
        return action;
    }

    /**
     *
     * @return 获取全部数据
     */
    public List<Action> getActions(){
        return list;
    }

    /**
     * 加载历史数据
     * @param lists 历史数据
     */
    public void loadActions(List<Action> lists){
        list.addAll(lists);
    }
}
