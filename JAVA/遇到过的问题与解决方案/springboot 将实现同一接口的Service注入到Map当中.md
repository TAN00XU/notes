# springboot 将实现同一接口的Service注入到Map当中

## Service

```java
public interface SayService {
    public String hello();
}
```

## implement

```java
@Service("sayOne")
public class SayServiceOne implements SayService {
    @Override
    public String hello() {
        System.out.println("say one");
        return "say one";
    }
}
```

```java
@Service("sayTwo")
public class SayServiceTwo implements SayService {
    @Override
    public String hello() {
        System.out.println("say two");
        return "say two";
    }
}
```

## 装载到map，作为bean注入到spring中

```java
@Component
public class MapConfig {
 
 
     @Bean(name="actServiceMap")
    public Map<String, SayService> getQueryServiceMap(){
        return  new HashMap<>();
        
    }
}
```



**自定义key**



```java
@Component
public class MapConfig {
 
    @Resource(name = "sayOne")
    private SayService sayOne;
 
    @Autowired
    @Qualifier("sayTwo")
    private SayService sayTwo;
 
    @Bean("sayServiceMap")
    public Map<String, SayService> geneSayServiceMap(){
        Map<String, SayService> sayServiceMap = new HashMap<>();
        sayServiceMap.put("sayOne自定义", sayOne);
        sayServiceMap.put("sayTwo自定义", sayTwo);
        return sayServiceMap;
    }
}
```
**这样写也可**

```java
@Component
public class ActMap {
 
    @Bean(name="actServiceMap")
    public Map<String, ActService> geneActServiceMap(@Qualifier("actOne") ActService actOne,
                                                     @Qualifier("actTwo") ActService actTwo){
        Map<String, ActService> map = new HashMap<>();
        map.put("actOne111", actOne);
        map.put("actTwo2222", actTwo);
        return map;
    }
}
```



## 测试

```java
@RestController
@RequestMapping("/beanTest")
public class BeanTest {
 
    @Resource(name="sayServiceMap")
    Map<String, SayService> sayServiceMap;
 
    @GetMapping("/say")
    public String say(){
        SayService sayOne = sayServiceMap.get("sayOne");
        SayService sayTwo = sayServiceMap.get("sayTwo");
 
        return sayOne.hello() + "\n" + sayTwo.hello();
    }
}
```





**更直接的方式**

直接使用即可

```java
@Autowired
private Map<String, SayService> sayServiceMap;
```

