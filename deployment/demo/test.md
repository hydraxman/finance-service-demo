## Use nginx to test the canary deployment

Create the nginx deployments:

```bash
kubectl create deployment nginx-deployment --image=nginx:1.23 --replicas=3
kubectl scale deployment/nginx-deployment --replicas=5
kubectl get deploy --watch
```


在Kubernetes部署配置中，`version: tom`标签被定义在了部署对象的顶级`metadata`下。这意味着这个标签被赋予了部署对象本身，而不是部署中创建的Pods。如果你希望Pod也拥有这个标签，你需要确保在Pod模板的`metadata.labels`部分也定义这个标签。

当前配置：

```yaml
template:
  metadata:
    labels:
      app: finance-app
```

为了让Pods也携带`version: tom`标签，需要在`template.metadata.labels`部分添加`version: tom`，如下所示：

```yaml
template:
  metadata:
    labels:
      app: finance-app
      version: tom
```

确保部署的`selector.matchLabels`与`template.metadata.labels`保持一致，这是Kubernetes要求的，以确保选择器能正确找到对应的Pods。在这个例子中，选择器已经正确配置为匹配`app: finance-app`标签，只是缺少了`version: tom`标签。添加上这个标签后，Pods将会正确地携带所有定义在模板标签中的标签。

查看标签：

```bash
kubectl get pods -o=custom-columns='NAME:.metadata.name,LABELS:.metadata.labels'
```