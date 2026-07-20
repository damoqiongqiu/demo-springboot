# Task CRUD API — 产品 Spec

**状态**: ✅ 已交付 | **创建**: 2026-07-20

## 用户故事
用户需要一个 REST API 来管理任务列表，支持基本的增删改查。

## 接口

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | /api/tasks | 创建任务 |
| GET | /api/tasks | 列表（支持 ?status= 筛选）|
| GET | /api/tasks/{id} | 单条详情 |
| PATCH | /api/tasks/{id}/status | 更新状态 |
| DELETE | /api/tasks/{id} | 删除任务 |

## 数据模型
```json
{ "id": 1, "title": "...", "status": "todo", "createdAt": "2026-07-20T..." }
```
status 枚举: todo / in_progress / done

## 验收
- [ ] POST /api/tasks → 201 + 返回创建的任务
- [ ] GET /api/tasks → 200 + 数组
- [ ] GET /api/tasks?status=done → 200 + 筛选结果
- [ ] GET /api/tasks/{id} → 200 / 404
- [ ] PATCH /api/tasks/{id}/status → 200 / 404
- [ ] DELETE /api/tasks/{id} → 204 / 404
- [ ] mvn test 全部通过
