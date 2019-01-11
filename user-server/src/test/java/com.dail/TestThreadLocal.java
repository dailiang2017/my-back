package com.dail;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: dailiang
 * @Date: 2019/1/10 18:13
 * @Description:
 */
public class TestThreadLocal {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        TestThreadLocal test = new TestThreadLocal();
        ThreadLocalContext context = test.new ThreadLocalContext();
        context.set("aaa", map);
        map.put("bb", 123);
        System.out.println("bb");
    }

     class ThreadLocalContext {

        public final ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String,Object>>() {
            @Override
            protected Map<String,Object> initialValue() {
                return new HashMap<String,Object>();
            }
        };

        public <T> T get(Class<T> cls) {
            if (threadLocal.get().get(cls.getName()) != null) {
                return (T) threadLocal.get().get(cls.getName());
            }
            return null;
        }

        public <T> void set(T obj) {
            threadLocal.get().put(obj.getClass().getName(), obj);
        }

        public <T> void set(String key,T obj) {
            threadLocal.get().put(key, obj);
        }

        public <T> T get(String key) {
            return (T) threadLocal.get().get(key);
        }

        public <T> void remove(T obj) {
            threadLocal.get().remove(obj.getClass().getName());
        }

        public <T> void remove(String key) {
            threadLocal.get().remove(key);
        }

        public void remove() {
            threadLocal.remove();
        }

    }
}
