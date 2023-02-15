### 2023-02-15 第一次更新
加入静态资源(图片)访问配置 WebMvcConfig, 加上图片是能访问了, 但是书籍接口会报错, 所以又加了个配置

```java
@Override
public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
argumentResolvers.add( new PageableHandlerMethodArgumentResolver());
}
```