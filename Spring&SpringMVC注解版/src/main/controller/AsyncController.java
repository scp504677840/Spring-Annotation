package main.controller;

import main.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@Controller
public class AsyncController {

    /**
     * Callable：异常请求
     * 建议只处理简单的异步请求。
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/callable")
    public Callable<String> callable() {
        return () -> "callable";
    }

    /**
     * DeferredResult：异步请求
     * 建议处理复杂的异步请求
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/deferredResult")
    public DeferredResult<Object> deferredResult() {
        DeferredResult<Object> deferredResult = new DeferredResult<>(10000L, "timeout");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    /**
     * 此方法仅仅演示DeferredResult被设置值之后返回的结果。
     * 模拟场景：
     * 1.用户下单，发生请求到应用1的/createOrder，但是应用1没有场景订单的能力。
     * 2.创建订单需要应用1发生请求到应用2。
     * 【注意：应用1与应用2直接可以存在消息中间件，
     * 若有，那么应用1发生请求到消息中间件，
     * 应用2监听到消息中间件有消息，
     * 取出消息，处理消息，返回消息处理结果，
     * 应用1监听到消息中间件有结果返回，
     * 然后拿到结果返回给客户端。】
     * 应用1->消息中间件->应用2
     * 应用1<-消息中间件<-应用2
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/setDeferredResult")
    public String setDeferredResult(){
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult("ok");
        return "success";
    }

}
