package cn.zhangdx.aihome.platform.checkapi;

/**
 * @author zhangdx
 * @date 2025/3/10 17:16
 */
public interface CheckApiHandler<T, R> {

    R handle(T t);
}
