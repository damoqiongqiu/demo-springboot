# 健康检查端点 — 技术 Spec

**关联**: specs/health-endpoint/product.md

## 实现
- `DemoApplication.java` 新增 @GetMapping("/health")
- `DemoApplicationTests.java` 新增 `shouldReturnHealthUp` 测试

## 测试
- Spring Boot Test + MockMvc 验证响应
