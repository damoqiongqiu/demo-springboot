# 健康检查端点 — 产品 Spec

**状态**: ✅ 已交付 | **创建**: 2026-07-20

## 功能
新增 `/health` 端点，返回 `{"status":"UP"}`，用于 k8s 存活探针。

## 验收
- [x] GET /health → 200 + {"status":"UP"}
- [x] mvn test 通过
