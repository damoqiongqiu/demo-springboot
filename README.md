# demo-springboot

**这是一个测试项目，用于验证 [my-harness-flow](https://github.com/damoqiongqiu/my-harness-flow) 框架的 backend profile，没有任何实际业务功能。**

## 验证项

- harness install `--profile backend` ✅
- L1 健康检查 4/4 (运行时/Docker/AGENTS/migration) ✅
- mvn test 2/2 (contextLoads + shouldReturnHealthUp) ✅
- spec: health-endpoint product+tech 双文档 ✅

## 运行

```bash
mvn spring-boot:run                 # localhost:8080
mvn test                            # 单元测试
bash .agents/quality-gate/l1-health-check.sh  # harness L1
```
