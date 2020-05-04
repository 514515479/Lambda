/**
 * @Author: tobi
 * @Date: 2020/5/4 16:40
 **/
@FunctionalInterface
public interface TestLong<T, R> {

    R getValue(T x, T y);
}
