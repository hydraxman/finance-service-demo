echo "Listing all components in the cluster"
echo "Listing all pods in the cluster"
kubectl get pods
echo "Listing all services in the cluster"
kubectl get services
echo "Listing all deployments in the cluster"
kubectl get deployments
echo "Listing all configMaps in the cluster"
kubectl get configmaps
echo "Listing all secrets in the cluster"
kubectl get secrets
echo "Listing all persistentVol in the cluster"
kubectl get pv
echo "Listing all persistentVolClaims in the cluster"
kubectl get pvc
echo "Listing all ingress in the cluster"
kubectl get ingress
echo "Listing all Horizontal Pod Autoscalers in the cluster"
kubectl get hpa
echo "Listing all jobs in the cluster"
kubectl get jobs
echo "Listing all cronjobs in the cluster"
kubectl get cronjobs
echo "Listing all statefulsets in the cluster"
kubectl get statefulsets
echo "Listing all daemonsets in the cluster"
kubectl get daemonsets
echo "Listing all replicasets in the cluster"
kubectl get replicasets
echo "Listing all nodes in the cluster"
kubectl get nodes
echo "Listing metrics-server"
kubectl get deployment metrics-server -n kube-system