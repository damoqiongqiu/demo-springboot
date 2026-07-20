# Task CRUD API — 技术 Spec

**关联**: specs/task-crud/product.md

## 新增文件
- `src/main/java/com/example/demo/task/Task.java` — 实体
- `src/main/java/com/example/demo/task/TaskController.java` — REST 控制器
- `src/test/java/com/example/demo/task/TaskControllerTest.java` — 集成测试

## 实现要点
- 内存 ConcurrentHashMap 存储（线程安全）
- AtomicLong 生成自增 ID
- status 校验：仅接受 todo/in_progress/done
- 404 返回纯文本 "Not Found"

## 测试策略
- MockMvc + @WebMvcTest
- 覆盖 6 个端点，含 404/status 枚举校验
